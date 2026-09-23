package com.neuracode.ai.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.neuracode.ai.ui.screens.HomeScreen
import com.neuracode.ai.ui.screens.CodeLabScreen

@Composable
fun NeuracodeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // ── Giriş Ekranı (Ders Kartları) ──
        composable(Screen.Home.route) {
            HomeScreen(
                onLessonClick = { lessonId ->
                    navController.navigate(Screen.CodeLab.createRoute(lessonId))
                }
            )
        }

        // ── Kod Laboratuvarı ──
        composable(
            route = Screen.CodeLab.route,
            arguments = listOf(navArgument("lessonId") { type = NavType.StringType })
        ) { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId") ?: "hello_world"
            CodeLabScreen(
                lessonId = lessonId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
