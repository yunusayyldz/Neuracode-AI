package com.neuracode.ai.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel
import com.neuracode.ai.ui.viewmodel.CodeLabViewModel
import com.neuracode.ai.ui.theme.LocalAppSettings

/**
 * Kod Ekranı — Taslaktaki "Uygulamanın asıl mevzusunun döndüğü ara yüz" birebir.
 *
 * Üst: Öğretilen konunun başlığı (örn: if else)
 * Sol: Kod kısmı
 * Sağ: Görsel kısmı (koda göre çalışacak görsel animasyon)
 * Alt-sol: Kod blokları (if, else vb.) — seçme, silme, geri alma
 * En alt: ← → 🔊 ♪ navigasyon çubuğu
 */
@Composable
fun CodeLabScreen(
    lessonId: String = "hello_world",
    viewModel: CodeLabViewModel = viewModel(),
    onBackClick: () -> Unit
) {
    val codeLines = viewModel.codeLines
    val isRunning by viewModel.isSimulationRunning
    var showSettings by remember { mutableStateOf(false) }
    val appSettings = LocalAppSettings.current
    val lesson = viewModel.currentLesson.value

    LaunchedEffect(lessonId) {
        viewModel.loadLesson(lessonId)
    }

    val lessonTitle = lesson.title

    Box(modifier = Modifier.fillMaxSize()) {
        // ════════════════════════════════
        // ANA İÇERİK
        // ════════════════════════════════
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .then(if (showSettings) Modifier.blur(8.dp) else Modifier)
        ) {
            // ── ÜST: Konu başlığı ──
            // Taslak: "öğretilen konunun başlığı (örn: if else)"
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 1.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = lessonTitle,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // ── HİKAYE METNİ ──
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = lesson.story,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(12.dp)
                )
            }

            // ── İKİLİ BÖLME: Kod + Görsel ──
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // ═══════════════════════
                // SOL: KOD KISMI
                // Taslak: "bu kısım kod kısmı"
                // ═══════════════════════
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.outline,
                            RoundedCornerShape(8.dp)
                        )
                        .padding(1.dp)
                ) {
                    // Kod satırları
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(12.dp)
                    ) {
                        codeLines.forEach { line ->
                            CodeLine(
                                lineNumber = line.number,
                                prefix = line.prefix,
                                suffix = line.suffix,
                                filledValue = line.filledValue,
                                isInteractive = line.isInteractive,
                                onClick = { viewModel.clearLastFilled() }
                            )
                        }
                    }

                    Divider(color = MaterialTheme.colorScheme.outline)

                    // ── KOD BLOKLARI ──
                    // Taslak: "kod kısmındaki if else vb. kod blokları olacak
                    // bu kod bloklarını kullanıcı seçme silme geri ile alarak
                    // düzelteceği kısım burası aynı zamanda kodu çalıştırılacağı
                    // run butonuda bu kısımda"
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            lesson.commandBlocks.forEach { block ->
                                CommandBtn(block) { viewModel.onCommandBlockClick(block) }
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        // Geri al + Çalıştır
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextButton(onClick = { viewModel.clearLastFilled() }) {
                                Icon(
                                    Icons.Default.Undo,
                                    contentDescription = "Geri",
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Geri", fontSize = 12.sp)
                            }

                            // RUN butonu
                            Button(
                                onClick = { viewModel.toggleSimulation() },
                                shape = RoundedCornerShape(6.dp),
                                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
                            ) {
                                Icon(
                                    if (isRunning) Icons.Default.Stop else Icons.Default.PlayArrow,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    if (isRunning) "Durdur" else "Çalıştır",
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }

                // ═══════════════════════
                // Taslak: "kod ekranı ile görsel kısmı ayarlamayı sağlar"
                // (Bölme ayırıcı — şimdilik sabit)
                // ═══════════════════════

                // ═══════════════════════
                // SAĞ: GÖRSEL KISMI
                // Taslak: "bu kısım görsel kısmı"
                // "koda göre çalışacak görsel animasyon"
                // ═══════════════════════
                // Görsel Animasyon Alanı (Canvas)
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
                        .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    val droneX by viewModel.droneX
                    val droneY by viewModel.droneY
                    val actionStatus by viewModel.actionStatus
                    
                    val primaryColor = MaterialTheme.colorScheme.primary

                    androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
                        val canvasWidth = size.width
                        val canvasHeight = size.height
                        
                        // Zemin ızgarası çizimi
                        val gridSize = canvasHeight / 5
                        for (i in 0..5) {
                            drawLine(
                                color = Color.Gray.copy(alpha = 0.3f),
                                start = androidx.compose.ui.geometry.Offset(0f, i * gridSize),
                                end = androidx.compose.ui.geometry.Offset(canvasWidth, i * gridSize),
                                strokeWidth = 1f
                            )
                        }
                        
                        val startX = 20.dp.toPx()
                        val startY = canvasHeight / 2
                        
                        // Hedef Çizimleri (Ders bazlı)
                        when (lesson.id) {
                            "if_else" -> {
                                // Engel
                                drawRect(
                                    color = Color.Red,
                                    topLeft = androidx.compose.ui.geometry.Offset(startX + (0.5f * gridSize), startY - 20.dp.toPx()),
                                    size = androidx.compose.ui.geometry.Size(40.dp.toPx(), 40.dp.toPx())
                                )
                            }
                            "loop" -> {
                                // Bitkiler
                                for (i in 1..3) {
                                    drawCircle(
                                        color = if (actionStatus == "WATERING" && droneX.toInt() == i) Color.Blue else Color.Green,
                                        radius = 15.dp.toPx(),
                                        center = androidx.compose.ui.geometry.Offset(startX + (i * gridSize), startY)
                                    )
                                }
                            }
                        }

                        // Karakter (Drone/Robot)
                        // ViewModel'den gelen X/Y değerleri gridSize ile çarpılarak konumlandırılır
                        val currentX = startX + (droneX * gridSize)
                        val currentY = startY + (droneY * gridSize)
                        val robotColor = when(actionStatus) {
                            "ERROR" -> Color.Red
                            "SUCCESS" -> Color.Green
                            else -> primaryColor
                        }
                        drawCircle(
                            color = robotColor,
                            radius = 20.dp.toPx(),
                            center = androidx.compose.ui.geometry.Offset(currentX, currentY)
                        )
                    }
                }
            }

            // ── EN ALT: Navigasyon çubuğu ──
            // Taslak: ← → (navigasyon) + 🔊 ♪ (ses kontrolleri) + ☰ (ayarlar)
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 1.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // ← Geri
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Geri")
                    }
                    // → İleri
                    IconButton(onClick = { }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, "İleri")
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    // 🔊 Ses
                    IconButton(onClick = {
                        appSettings.isSoundEnabled.value = !appSettings.isSoundEnabled.value
                    }) {
                        Icon(
                            if (appSettings.isSoundEnabled.value) Icons.Default.VolumeUp
                            else Icons.Default.VolumeOff,
                            "Ses"
                        )
                    }
                    // ♪ Müzik
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.MusicNote, "Müzik")
                    }
                    // ☰ Ayarlar
                    IconButton(onClick = { showSettings = true }) {
                        Icon(Icons.Default.Menu, "Ayarlar")
                    }
                }
            }
        }

        // ════════════════════════════════
        // AYARLAR OVERLAY
        // Taslak: "üç çizginin ara yüzü"
        // "açıldıktan sonra arkaplan hafif şeffaf yada blur olur"
        // ════════════════════════════════
        AnimatedVisibility(
            visible = showSettings,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { showSettings = false },
                contentAlignment = Alignment.Center
            ) {
                // Ayarlar kartı — taslaktaki birebir
                Surface(
                    modifier = Modifier
                        .width(300.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { },
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 8.dp,
                    border = ButtonDefaults.outlinedButtonBorder
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Başlık
                        Text(
                            "Ayarlar",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Dil
                        SettingsRow("Dil :", "Türkçe")

                        Spacer(modifier = Modifier.height(8.dp))

                        // Ses — çalışan toggle
                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(6.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 14.dp, vertical = 6.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("Ses :", fontSize = 13.sp)
                                Switch(
                                    checked = appSettings.isSoundEnabled.value,
                                    onCheckedChange = {
                                        appSettings.isSoundEnabled.value = it
                                    }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Öneri ve şikayet
                        OutlinedButton(
                            onClick = { },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text("Öneri ve şikayet", fontSize = 13.sp)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Devam et
                        Button(
                            onClick = { showSettings = false },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text("Devam et", fontSize = 13.sp)
                        }
                    }
                }
            }
        }
    }
}

// ══════════════════════════════════════════════════════════════
// Yardımcı Composable'lar
// ══════════════════════════════════════════════════════════════

@Composable
private fun CodeLine(
    lineNumber: Int,
    prefix: String,
    suffix: String = "",
    filledValue: String = "",
    isInteractive: Boolean = false,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Satır numarası
        Text(
            text = "$lineNumber",
            fontFamily = FontFamily.Monospace,
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.width(24.dp),
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Prefix
        Text(
            text = prefix,
            fontFamily = FontFamily.Monospace,
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        // Boşluk / Doldurulmuş
        if (isInteractive) {
            Surface(
                onClick = onClick,
                color = if (filledValue.isEmpty())
                    MaterialTheme.colorScheme.surfaceVariant
                else
                    MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(
                    text = if (filledValue.isEmpty()) " ____ " else " $filledValue ",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (filledValue.isEmpty())
                        MaterialTheme.colorScheme.onSurfaceVariant
                    else
                        MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
            }
        }

        // Suffix
        if (suffix.isNotEmpty()) {
            Text(
                text = suffix,
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
private fun RowScope.CommandBtn(
    label: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.weight(1f),
        shape = RoundedCornerShape(6.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 6.dp)
    ) {
        Text(label, fontSize = 11.sp)
    }
}

@Composable
private fun SettingsRow(label: String, value: String) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, fontSize = 13.sp)
            Text(value, fontSize = 13.sp, fontWeight = FontWeight.Medium)
        }
    }
}
