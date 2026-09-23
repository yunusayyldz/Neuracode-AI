package com.neuracode.ai.ui.navigation

/**
 * Uygulama navigasyon rotaları.
 *
 * Taslağa göre 2 ana ekran:
 * - Home: Ders seçim ekranı (giriş ekranı)
 * - CodeLab: Kod editörü + görsel simülasyon
 */
sealed class Screen(val route: String) {
    /** Giriş Ekranı — Ders kartları grid'i */
    data object Home : Screen("home")

    /** Kod Laboratuvarı — İkili bölmeli ana öğrenme ekranı */
    data object CodeLab : Screen("code_lab/{lessonId}") {
        fun createRoute(lessonId: String) = "code_lab/$lessonId"
    }
}
