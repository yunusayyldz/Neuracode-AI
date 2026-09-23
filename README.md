# Neuracode AI

8-15 yaş arası çocukların ve gençlerin, tarım temalı bir oyun içinde Python programlamayı ve yapay zekâyı öğrendiği Android uygulaması. T3 Vakfı Creathon projesi.

Kullanıcı klavye kullanmadan, ekrandaki kod bloklarını sürükle-bırak ile yerleştirerek bir tarım dronunu (ve Tech-Trax Rover kara aracını) kontrol eder. Kod çalıştığında drone simülasyon ekranında tarlayı tarar, köstebeği tespit eder.

## Depo Yapısı

- `Neuracode AI/` — Proje dokümantasyonu ve planlama Obsidian vault'u (proje özeti, yapay zekâ sistem beyni notları, ekran görüntüleri, sunum)
- `NeuracodeAI_App/` — Android uygulaması (Kotlin + Jetpack Compose)
- `claudesidian-vault/` — Claudesidian (Claude Code + Obsidian) starter kit vault'u

## Teknoloji

- **Kotlin + Jetpack Compose** (Android native)
- **Chaquopy** — uygulama içinde Python kodu çalıştırma
- **TensorFlow Lite** — düşük donanımda yapay zekâ
- **Material Design 3** — koyu/açık tema desteği

## Kurulum

```bash
cd NeuracodeAI_App
gradlew.bat assembleDebug
```

Android Studio ile `NeuracodeAI_App` klasörünü açıp çalıştırabilirsiniz.
