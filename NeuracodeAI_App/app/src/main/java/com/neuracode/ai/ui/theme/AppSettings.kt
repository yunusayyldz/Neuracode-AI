package com.neuracode.ai.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * Uygulama genelinde tema ayarlarını tutan yapı.
 * Koyu tema, ses vb. ayarlar burada tutulur.
 */
data class AppSettings(
    val isDarkTheme: MutableState<Boolean> = mutableStateOf(false),
    val isSoundEnabled: MutableState<Boolean> = mutableStateOf(true)
)

val LocalAppSettings = compositionLocalOf { AppSettings() }
