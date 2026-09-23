---
title: Neuracode AI Teknik Yol Haritası
version: v1.0
date: 2026-05-04
tags: [Neuracode AI, yol-haritasi, teknik, kotlin]
status: aktif
related: [[Neuracode AI_Ana_Plan]], [[UI_Tasarim_Analizi]]
---

# Neuracode AI: Teknik Yol Haritası

Bu dosya, projenin geliştirme aşamalarını ve teknik kararları takip eder.

---

## Onaylanan Teknoloji Yığını (Tech Stack)

| Katman | Teknoloji |
|--------|-----------|
| **Dil** | Kotlin |
| **UI Framework** | Jetpack Compose (Material Design 3) |
| **Simülasyon** | Compose Canvas API (2D çizim, GPU hızlandırmalı) |
| **Python Motoru** | Chaquopy (Android içinde Python çalıştırma) |
| **Yapay Zeka** | TensorFlow Lite (INT8 Quantized) |
| **Animasyonlar** | Lottie for Compose / Rive |
| **Async İşlemler** | Kotlin Coroutines |
| **Yerel Veritabanı** | Room DB (ilerleme, skor, kullanıcı verileri) |
| **İçerik İndirme** | Play Feature Delivery (On-Demand Modules) |
| **Minimum SDK** | API 24 (Android 7.0) — 2GB RAM hedefi |

---

## Araç Stratejisi

| Aşama | Araç | Açıklama |
|-------|------|----------|
| **Başlangıç görevleri** | 🚁 Agri-Drone | Tarla tarama, köstebek tespiti, hava gözlemi |
| **Orta seviye görevler** | 🚜 [[Tech-Trax Rover]] | Sulama, ekim, hasat gibi kara görevleri |
| **İleri seviye görevler** | 🚁 + 🚜 Birlikte | Drone keşfeder → Rover müdahale eder (koordineli görevler) |

---

## Geliştirme Fazları

### Faz 0 — Proje İskeleti (Hafta 1-2)
- [ ] Android Studio'da Kotlin + Compose projesi oluşturma
- [ ] Material Design 3 tema dosyası (pastel renk paleti, koyu/açık tema)
- [ ] Temel navigasyon yapısı (Ana Menü → Kod Lab → Simülasyon)
- [ ] Yatay (Landscape) mod kilitleme
- [ ] Proje klasör mimarisi (MVVM veya Clean Architecture)

### Faz 1 — Ana Menü Ekranı (Hafta 2-3)
- [ ] "AGRI-CODE / HARVEST LOGIC" karşılama ekranı
- [ ] "PLAY NOW" butonu (büyük dairesel, drone ikonu)
- [ ] "Continue Previous Farm", "Lessons", "Settings" alt butonları
- [ ] Geometrik pastel arka plan deseni
- [ ] Lottie animasyonlu geçiş efektleri

### Faz 2 — Kod Laboratuvarı (CODE LAB) (Hafta 3-6)
- [ ] İkili bölme (Split View): Sol Kod / Sağ Simülasyon
- [ ] Satır numaralı kod gösterimi (syntax highlighting)
- [ ] Boşluk doldurma alanları (`_____`) oluşturma
- [ ] [[Sıfır Klavye Giriş Metodu]]: Komut blokları paleti (scan, scare, continue, wait, loop)
- [ ] Sembol satırı (! @ # $ % vb.)
- [ ] Sürükle-bırak mekanizması (Compose DragAndDrop API)
- [ ] "Drop block here" hedef alanı
- [ ] İlerleme çubuğu ve faz numarası gösterimi

### Faz 3 — Simülasyon Motoru (Hafta 5-8)
- [ ] Compose Canvas ile 2D tarla haritası çizimi
- [ ] Agri-Drone sprite/animasyonu (hareket, dönüş, tarama)
- [ ] Hedef tespiti görselleri (Target: Mole, Status: Detected)
- [ ] "problem" işaretçileri (ünlem ikonu)
- [ ] Dinamik render (cihaz GPU'suna göre Low-Poly/Standard)
- [ ] Kod → Simülasyon bağlantısı (blok yerleştirildiğinde anlık tepki)

### Faz 4 — Python Motoru ve Chaquopy (Hafta 7-9)
- [ ] Chaquopy entegrasyonu
- [ ] Kullanıcı kodunun arka planda Python ile çalıştırılması
- [ ] Sonuçların simülasyona yansıtılması
- [ ] Hata yakalama ve kullanıcı dostu hata mesajları

### Faz 5 — Oyunlaştırma Sistemi (Hafta 8-10)
- [ ] Yıldız seviye sistemi (★★★☆)
- [ ] Skor rozeti (Yeşil/Kırmızı/Turuncu puanlar)
- [ ] Achievements (Başarımlar) sistemi
- [ ] Room DB ile ilerleme kaydetme
- [ ] Görev tamamlama animasyonları

### Faz 6 — [[TinyML ve AI Optimizasyonu]] (Hafta 10-12)
- [ ] TensorFlow Lite modeli entegrasyonu
- [ ] INT8 Quantization ile model optimizasyonu
- [ ] On-device inference (köstebek tespiti görevi)
- [ ] AI Laboratuvarı ekranı (Premium özellik)

### Faz 7 — İçerik ve Müfredat (Hafta 11-14)
- [ ] Değişkenler bölümü (tohum türleri, miktarlar)
- [ ] Döngüler bölümü (tarla sıralarını sulama)
- [ ] Koşullu ifadeler bölümü (toprak nem kontrolü)
- [ ] Animasyonlu giriş sahneleri (Lottie/Rive)
- [ ] En az 3 ücretsiz hikaye

### Faz 8 — Test ve Yayın (Hafta 14-16)
- [ ] 2GB RAM cihazlarda performans testi (60 FPS doğrulama)
- [ ] Play Feature Delivery ile On-Demand modüller
- [ ] Google Play Store yayın hazırlığı
- [ ] Freemium + Tek seferlik ödeme modeli entegrasyonu

---

## Mimari Diyagram

```
┌─────────────────────────────────────────────┐
│              PRESENTATION LAYER             │
│  ┌──────────────┐  ┌─────────────────────┐  │
│  │  Ana Menü    │  │   Kod Laboratuvarı  │  │
│  │  (Compose)   │  │   (Split View)      │  │
│  └──────────────┘  │  ┌──────┐ ┌───────┐ │  │
│                    │  │ Kod  │ │Simüla.│ │  │
│                    │  │Editor│ │Canvas │ │  │
│                    │  └──────┘ └───────┘ │  │
│                    └─────────────────────┘  │
├─────────────────────────────────────────────┤
│              DOMAIN LAYER                   │
│  ┌────────────┐ ┌──────────┐ ┌───────────┐ │
│  │  Görev     │ │ Skorlama │ │  Python   │ │
│  │  Yönetici  │ │ Motoru   │ │  Çalıştır.│ │
│  └────────────┘ └──────────┘ └───────────┘ │
├─────────────────────────────────────────────┤
│              DATA LAYER                     │
│  ┌────────────┐ ┌──────────┐ ┌───────────┐ │
│  │  Room DB   │ │ Chaquopy │ │  TFLite   │ │
│  │  (İlerleme)│ │ (Python) │ │  (AI)     │ │
│  └────────────┘ └──────────┘ └───────────┘ │
└─────────────────────────────────────────────┘
```
