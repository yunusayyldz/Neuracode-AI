package com.neuracode.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.neuracode.ai.ui.navigation.NeuracodeNavGraph
import com.neuracode.ai.ui.theme.AppSettings
import com.neuracode.ai.ui.theme.LocalAppSettings
import com.neuracode.ai.ui.theme.NeuracodeAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appSettings = remember { AppSettings() }

            CompositionLocalProvider(LocalAppSettings provides appSettings) {
                NeuracodeAITheme(darkTheme = appSettings.isDarkTheme.value) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        val navController = rememberNavController()
                        NeuracodeNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}
