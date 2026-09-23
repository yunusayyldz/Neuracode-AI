package com.neuracode.ai.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neuracode.ai.ui.theme.LocalAppSettings
import kotlinx.coroutines.launch
import com.neuracode.ai.data.LessonRepository

// ── Ders verisi ──
data class LessonItem(
    val id: String,
    val title: String,
    val isAvailable: Boolean = false
)

private val lessons = LessonRepository.lessons.values.map { lesson ->
    LessonItem(lesson.id, lesson.title, isAvailable = true)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onLessonClick: (String) -> Unit
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val appSettings = LocalAppSettings.current

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // ════════════════════════════════
            // HAMBURGER MENÜ — çalışan butonlar
            // ════════════════════════════════
            ModalDrawerSheet(
                modifier = Modifier.width(280.dp)
            ) {
                // Üst kısım
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { scope.launch { drawerState.close() } }) {
                        Icon(Icons.Default.Menu, contentDescription = "Kapat")
                    }
                }

                HorizontalDivider()

                Spacer(modifier = Modifier.height(4.dp))

                // Ayarlar
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Settings, null) },
                    label = { Text("Ayarlar") },
                    selected = false,
                    onClick = { },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                // Font özelleştirme
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.FormatSize, null) },
                    label = { Text("Font özelleştirme vs.") },
                    selected = false,
                    onClick = { },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                // Tam erişim kilidi aç
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.LockOpen, null) },
                    label = { Text("Tam erişim kilidi aç") },
                    selected = false,
                    onClick = { },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                // ── KOYU TEMA — ÇALIŞIYOR ──
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            if (appSettings.isDarkTheme.value) Icons.Default.LightMode
                            else Icons.Default.DarkMode,
                            null
                        )
                    },
                    label = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Koyu tema")
                            Switch(
                                checked = appSettings.isDarkTheme.value,
                                onCheckedChange = {
                                    appSettings.isDarkTheme.value = it
                                }
                            )
                        }
                    },
                    selected = false,
                    onClick = {
                        appSettings.isDarkTheme.value = !appSettings.isDarkTheme.value
                    },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                // ── SES AYARLARI — ÇALIŞIYOR ──
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            if (appSettings.isSoundEnabled.value) Icons.Default.VolumeUp
                            else Icons.Default.VolumeOff,
                            null
                        )
                    },
                    label = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Ses ayarları")
                            Switch(
                                checked = appSettings.isSoundEnabled.value,
                                onCheckedChange = {
                                    appSettings.isSoundEnabled.value = it
                                }
                            )
                        }
                    },
                    selected = false,
                    onClick = {
                        appSettings.isSoundEnabled.value = !appSettings.isSoundEnabled.value
                    },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))

                // Ödüller
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.EmojiEvents, null) },
                    label = { Text("Ödüller / başarı kilitleri") },
                    selected = false,
                    onClick = { },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                // Öneri ve şikayetler
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Feedback, null) },
                    label = { Text("Öneri ve şikayetler") },
                    selected = false,
                    onClick = { },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    ) {
        // ════════════════════════════════
        // ANA İÇERİK
        // ════════════════════════════════
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Üst çubuk
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { scope.launch { drawerState.open() } }) {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = "Menü",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            // Ders kartları grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(lessons) { lesson ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.3f)
                            .then(
                                if (lesson.isAvailable)
                                    Modifier.clickable { onLessonClick(lesson.id) }
                                else Modifier
                            ),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            if (lesson.title.isNotEmpty()) {
                                Text(
                                    text = lesson.title,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                            // Kilitli ders ikonu
                            if (!lesson.isAvailable && lesson.title.isEmpty()) {
                                Icon(
                                    Icons.Default.Lock,
                                    contentDescription = "Kilitli",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.3f),
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
