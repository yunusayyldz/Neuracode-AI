package com.neuracode.ai.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.neuracode.ai.data.LessonRepository

// ── Veri Modelleri ──
data class CodeLineData(
    val number: Int,
    val prefix: String,
    val suffix: String = "",
    var filledValue: String = "",
    val isInteractive: Boolean = false,
    val expectedValue: String = ""
)

data class Lesson(
    val id: String,
    val title: String,
    val story: String,
    val initialCodeLines: List<CodeLineData>,
    val commandBlocks: List<String>
)

class CodeLabViewModel : ViewModel() {

    // LessonRepository üzerinden tüm dersleri alıyoruz
    private val allLessons = LessonRepository.lessons

    private val _currentLesson = mutableStateOf(allLessons.values.first())
    val currentLesson: State<Lesson> = _currentLesson

    private val _codeLines = mutableStateListOf<CodeLineData>()
    val codeLines: List<CodeLineData> = _codeLines

    private val _isSimulationRunning = mutableStateOf(false)
    val isSimulationRunning: State<Boolean> = _isSimulationRunning
    
    // Simülasyon Animasyon Durumları
    val droneX = mutableStateOf(0f)
    val droneY = mutableStateOf(0f)
    val actionStatus = mutableStateOf("IDLE") // IDLE, RUNNING, SUCCESS, ERROR

    fun loadLesson(lessonId: String) {
        val lesson = allLessons[lessonId] ?: allLessons.values.first()
        _currentLesson.value = lesson
        _codeLines.clear()
        _codeLines.addAll(lesson.initialCodeLines.map { it.copy() })
        
        resetSimulation()
    }

    private fun resetSimulation() {
        _isSimulationRunning.value = false
        droneX.value = 0f
        droneY.value = 0f
        actionStatus.value = "IDLE"
    }

    fun onCommandBlockClick(command: String) {
        val index = _codeLines.indexOfFirst { it.isInteractive && it.filledValue.isEmpty() }
        if (index != -1) {
            val line = _codeLines[index]
            _codeLines[index] = line.copy(filledValue = command)
        }
    }

    fun clearLastFilled() {
        val index = _codeLines.indexOfLast { it.isInteractive && it.filledValue.isNotEmpty() }
        if (index != -1) {
            val line = _codeLines[index]
            _codeLines[index] = line.copy(filledValue = "")
            resetSimulation()
        }
    }

    fun toggleSimulation() {
        if (_isSimulationRunning.value) {
            resetSimulation()
        } else {
            runSimulation()
        }
    }

    private fun runSimulation() {
        // Kullanıcının girdiği kodlar doğru mu?
        val allInteractiveFilled = _codeLines.filter { it.isInteractive }.all { it.filledValue.isNotEmpty() }
        if (!allInteractiveFilled) {
            actionStatus.value = "ERROR" // Kod eksik
            return
        }

        val isCorrect = _codeLines.filter { it.isInteractive }.all { it.filledValue == it.expectedValue }
        
        if (isCorrect) {
            _isSimulationRunning.value = true
            actionStatus.value = "RUNNING"
            
            // Senkronize animasyon mantığı (Ders türüne göre farklı animasyon)
            viewModelScope.launch {
                when (_currentLesson.value.id) {
                    "hello_world" -> {
                        delay(500)
                        droneX.value = 1f // 1 adım ileri
                        delay(500)
                        actionStatus.value = "SUCCESS"
                    }
                    "if_else" -> {
                        delay(500)
                        droneX.value = 0.5f // Engele yaklaş
                        delay(500)
                        droneY.value = -1f  // Zıpla (Yukarı)
                        droneX.value = 1f   // İleri
                        delay(500)
                        droneY.value = 0f   // Yere in
                        delay(500)
                        actionStatus.value = "SUCCESS"
                    }
                    "loop" -> {
                        for (i in 1..3) {
                            delay(500)
                            droneX.value = i.toFloat() // Bitkiye git
                            actionStatus.value = "WATERING" // Sula
                            delay(500)
                            actionStatus.value = "RUNNING"
                        }
                        delay(500)
                        actionStatus.value = "SUCCESS"
                    }
                    else -> {
                        // Yeni eklenen tüm bölümler için genel bir başarı animasyonu
                        delay(500)
                        droneY.value = -1f // Yukarı kalk (Kalkış)
                        delay(500)
                        droneX.value = 1f  // Biraz ileri git
                        delay(500)
                        actionStatus.value = "SUCCESS"
                    }
                }
            }
        } else {
            // Kod yanlış
            actionStatus.value = "ERROR"
            viewModelScope.launch {
                delay(1000)
                actionStatus.value = "IDLE"
            }
        }
    }
}
