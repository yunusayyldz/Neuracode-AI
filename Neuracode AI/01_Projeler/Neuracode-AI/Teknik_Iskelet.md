---
title: Neuracode AI Teknik İskelet Yapısı
version: v1.1
date: 2026-05-05
tags: [neuracode-ai, skeleton, mimari, android, kotlin]
status: aktif
related: [[Teknik_Yol_Haritasi]]
---

# Neuracode AI Teknik İskelet Yapısı (Skeleton)

Bu döküman, oluşturulan Android projesinin fiziksel dosya yapısını ve mimari iskeletini özetler.

## 📁 Proje Klasör Yapısı
Proje, MVVM (Model-View-ViewModel) mimarisine uygun olarak şu şekilde yapılandırılmıştır:

```
NeuracodeAI_App/
├── app/
│   ├── src/main/
│   │   ├── AndroidManifest.xml (Landscape kilitli, MD3 tema tanımlı)
│   │   ├── java/com/neuracode/ai/
│   │   │   ├── MainActivity.kt (Giriş noktası, NavHost kurulumu)
│   │   │   ├── ui/
│   │   │   │   ├── theme/
│   │   │   │   │   ├── Color.kt    (Pastel tarla + gece paleti)
│   │   │   │   │   ├── Type.kt     (Monospace + MD3 tipografi)
│   │   │   │   │   └── Theme.kt    (Açık/Koyu tema değişimi)
│   │   │   │   ├── navigation/
│   │   │   │   │   ├── Screen.kt   (5 rota tanımı)
│   │   │   │   │   └── NavGraph.kt (Splash → Home → CodeLab akışı)
│   │   │   │   ├── screens/
│   │   │   │   │   ├── SplashScreen.kt  (Animasyonlu açılış)
│   │   │   │   │   ├── HomeScreen.kt    (Ana menü + geometrik arka plan)
│   │   │   │   │   └── CodeLabScreen.kt (Etkileşimli kod laboratuvarı)
│   │   │   │   └── viewmodel/
│   │   │   │       └── CodeLabViewModel.kt (Blok tıklama + durum yönetimi)
│   │   │   ├── data/   (Veritabanı ve Repository katmanı - Hazırlık)
│   │   │   └── domain/ (İş mantığı ve UseCase katmanı - Hazırlık)
│   │   └── res/
│   │       ├── values/ (strings.xml, themes.xml)
│   │       ├── drawable/ (ic_launcher_background, ic_launcher_foreground)
│   │       └── mipmap-anydpi-v26/ (Adaptive icon tanımları)
│   └── build.gradle.kts (Modül bağımlılıkları: Compose, Navigation)
├── build.gradle.kts (Proje seviyesi: AGP 8.7.3, Kotlin 2.0.21)
└── settings.gradle.kts (Proje ismi ve modüller)
```

## 🛠️ Kullanılan Teknolojiler
- **Kotlin 2.0.21**: Ana programlama dili.
- **Jetpack Compose**: Modern deklaratif UI framework.
- **Material Design 3**: Google'ın en güncel tasarım sistemi (Pastel renk paleti uygulandı).
- **Navigation Compose**: Ekranlar arası geçiş yönetimi.
- **ViewModel (Lifecycle)**: MVVM durum yönetimi.
- **Chaquopy (Hazırlık)**: Python kodu çalıştırma altyapısı.

## 🎨 Tasarım Sistemi (Theme)
- **Renkler (`Color.kt`):** Mockup'lardaki pastel tarla renkleri ve koyu gece teması paleti tanımlandı.
- **Tipografi (`Type.kt`):** Kod görünümü için `Monospace` font desteği ve MD3 uyumlu başlık stilleri.
- **Tema (`Theme.kt`):** Uygulama genelinde açık/koyu tema desteği entegre edildi.

## 🚦 Navigasyon Yapısı
Uygulama şu an 5 ana rotaya sahip olacak şekilde iskeletleştirildi:
1. `splash`: Animasyonlu Açılış Ekranı (3 sn → Home'a yönlendirme)
2. `home`: Ana Menü (Harvest Logic)
3. `code_lab`: Kod Laboratuvarı (İkili bölmeli, etkileşimli çalışma alanı)
4. `lessons`: Dersler (Hazırlık aşamasında)
5. `settings`: Ayarlar (Hazırlık aşamasında)

## 🧠 ViewModel Mimarisi
- **CodeLabViewModel**: Kod satırlarındaki boşlukları, komut bloğu tıklamalarını ve simülasyon durumunu yönetir.
  - `onCommandBlockClick(command)`: Sıradaki boşluğu doldurur.
  - `clearLastFilled()`: Son doldurulan bloğu geri alır.
  - `toggleSimulation()`: Tüm boşluklar doluysa simülasyonu başlatır.

---
*Bu iskelet, Faz 0 kapsamında oluşturulmuş ve Faz 1'e (etkileşim) geçiş yapılmıştır. (v1.1 — 5 Mayıs 2026)*
