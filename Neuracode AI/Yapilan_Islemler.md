---
title: Yapılan İşlemler Günlüğü
date: 2026-05-04
tags: [gunluk, degisiklik, log]
status: aktif
---

# Yapılan İşlemler Günlüğü

---

## 4 Mayıs 2026

### Obsidian Kasası Kurulumu
- Claudesidian (GitHub) indirildi ve `claudesidian-vault` klasörüne çıkarıldı.
- npm bağımlılıkları kuruldu.
- Gereksiz dosyalar temizlendi (`.github`, `FIRST_RUN`).

### Kasa Yapılandırması
- PARA metoduna uygun klasör yapısı oluşturuldu (`01_Projeler`, `03_Kaynaklar`, `05_Ekler`).
- Klasör ve dosya isimleri Türkçeye çevrildi.
- `CLAUDE.md` → `Yapay_Zeka_Sistem_Beyni.md` olarak yeniden adlandırıldı.

### Neuracode AI Projesi Düzenleme
- `Neuracode AI_Master_Plan.md` → `Neuracode AI_Ana_Plan.md` olarak yeniden adlandırıldı.
- Dosyanın başına YAML frontmatter eklendi (title, version, date, tags, status).
- Metin içindeki kavramlar `[[wikilink]]` formatına dönüştürüldü.
- Araç stratejisi güncellendi: Drone ile başla → Rover devreye girsin → İkisi birlikte.
- Teknoloji yığını onaylandı ve plana eklendi: Kotlin + Jetpack Compose.

### Oluşturulan Yeni Dosyalar
| Dosya | Konum | Ne İçeriyor |
|-------|-------|-------------|
| `00_Genel_Bakis.md` | `01_Projeler/Neuracode AI/` | Projenin kontrol paneli (MOC) |
| `UI_Tasarim_Analizi.md` | `01_Projeler/Neuracode AI/` | 3 mockup ekranının detaylı analizi |
| `Teknik_Yol_Haritasi.md` | `01_Projeler/Neuracode AI/` | 8 fazlı geliştirme planı ve mimari |
| `Tech-Trax Rover.md` | `03_Kaynaklar/` | Kara aracı karakteri |
| `Agri-Drone.md` | `03_Kaynaklar/` | Başlangıç aracı (drone) |
| `Sıfır Klavye Giriş Metodu.md` | `03_Kaynaklar/` | Dokunmatik blok sistemi kararı |
| `TinyML ve AI Optimizasyonu.md` | `03_Kaynaklar/` | TFLite ve edge AI mimarisi |

### Sistem Beyni Güncellemesi
- Aktif proje bağlamı eklendi (Neuracode AI).
- Çalışma tarzı kuralları yazıldı: YAML zorunlu, sürüm zinciri, kavram çıkarımı, içerik silmeme.

### UI Mockup Görsellerinin Kaydedilmesi
- 3 adet tasarım görseli `05_Ekler/Neuracode AI_UI_Tasarimlari/` klasörüne kaydedildi.

### Faz 0: Proje İskeleti Oluşturma
- JDK 17 (Microsoft OpenJDK) `winget` ile kuruldu.
- Android Studio indirme başlatıldı (kurulum devam ediyor).
- `Neuracode AI/` proje klasörü MVVM mimarisiyle oluşturuldu.
- Gradle yapılandırması yazıldı (AGP 8.7.3, Kotlin 2.1.0, Compose BOM).
- AndroidManifest: Landscape kilit, MD3 tema.
- Tema dosyaları: Pastel tarla paleti (açık) + gece tarlası paleti (koyu), tipografi.
- Navigasyon: Home → CodeLab → Lessons → Settings rotaları.
- Ana Menü ekranı (HomeScreen.kt): Geometrik arka plan, PLAY NOW, Devam Et, Dersler, Ayarlar.
- Kod Lab ekranı (CodeLabScreen.kt): İkili bölme, satır numaralı kod, komut blokları, skor rozeti.

---

## 5 Mayıs 2026

### Kotlin Sürüm Düzeltmesi
- `build.gradle.kts` (root): Kotlin sürümü `2.1.0` → `2.0.21` olarak düşürüldü.
- Sebep: Gradle 8.7.3 ile sürüm uyumsuzluğu ve `kotlin-reflect:2.0.20` çözümlenme hatası.

### Splash Screen Oluşturma
- `SplashScreen.kt` oluşturuldu (`ui/screens/`).
- Saf Compose animasyonları ile tasarlandı (Lottie bağımlılığı kaldırıldı):
  - Drone emojisi pulse (nefes) animasyonu.
  - Marka adı ve slogan fade-in efekti.
  - Pastel degrade arka plan (primaryContainer → background).
- 3 saniye sonra otomatik olarak Ana Menü'ye (`Home`) geçiş sağlanıyor.

### Navigasyon Güncellemesi
- `Screen.kt`: `Splash` rotası eklendi.
- `NavGraph.kt`: Başlangıç rotası `home` → `splash` olarak değiştirildi.
- Splash → Home geçişinde `popUpTo(inclusive = true)` ile geri tuşu koruması eklendi.

### CodeLab Etkileşim Sistemi (ViewModel)
- `ui/viewmodel/` klasörü oluşturuldu.
- `CodeLabViewModel.kt` oluşturuldu:
  - `CodeLineData` veri sınıfı: prefix, suffix, filledValue, isInteractive alanları.
  - `onCommandBlockClick()`: Alt paneldeki bloklara tıklandığında sıradaki boşluğu doldurur.
  - `clearLastFilled()`: Son doldurulan bloğu geri alır.
  - `toggleSimulation()`: Tüm boşluklar doluysa simülasyonu başlatır/durdurur.
- `CodeLabScreen.kt` güncellendi:
  - ViewModel entegrasyonu (`viewModel()` ile enjekte).
  - Kod satırları artık `codeLines.forEach` döngüsüyle dinamik render ediliyor.
  - `CodeLine` composable'ı yeniden yazıldı: prefix + interaktif boşluk (Surface) + suffix yapısı.
  - Komut bloklarına (`scan`, `scare`, `continue`, `wait`, `loop`) `onClick` bağlandı.
  - RUN butonu: Simülasyon durumuna göre Play/Pause ikonu değişiyor.
  - STOP butonu: Yalnızca simülasyon çalışırken aktif.

### Uygulama İkonları
- `res/drawable/ic_launcher_background.xml`: Pastel yeşil (#8FBF9F) vektörel arka plan.
- `res/drawable/ic_launcher_foreground.xml`: Beyaz elmas şekilli vektörel ön plan.
- `res/mipmap-anydpi-v26/ic_launcher.xml`: Adaptive icon tanımı.
- `res/mipmap-anydpi-v26/ic_launcher_round.xml`: Yuvarlak adaptive icon tanımı.

### Android Studio Kurulumu
- Proje `NeuracodeAI_App` klasörü ile Android Studio'da açıldı.
- Gradle Sync başarıyla tamamlandı.
- Emülatör cihazı (Pixel 10 Pro Fold, API 37) yapılandırıldı.

### Güncel Dosya Yapısı
```
NeuracodeAI_App/app/src/main/java/com/neuracode/ai/
├── MainActivity.kt
├── ui/
│   ├── navigation/
│   │   ├── Screen.kt        (5 rota: Splash, Home, CodeLab, Lessons, Settings)
│   │   └── NavGraph.kt      (Splash başlangıç noktası)
│   ├── screens/
│   │   ├── SplashScreen.kt   [YENİ] — Animasyonlu açılış ekranı
│   │   ├── HomeScreen.kt     — Geometrik arka planlı ana menü
│   │   └── CodeLabScreen.kt  [GÜNCELLENDİ] — Etkileşimli kod laboratuvarı
│   ├── theme/
│   │   ├── Color.kt, Type.kt, Theme.kt
│   └── viewmodel/
│       └── CodeLabViewModel.kt [YENİ] — Blok tıklama ve durum yönetimi
├── data/   (Hazırlık)
└── domain/ (Hazırlık)
```
