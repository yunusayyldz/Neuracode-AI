---
title: Neuracode AI Proje Özeti
date: 2026-05-04
tags: [Neuracode AI, ozet]
status: aktif
---

# Neuracode AI — Proje Özeti

## Ne Bu?
Çocuklar ve gençlerin (8-15 yaş) Python programlamayı ve yapay zekayı, tarım temalı bir oyun içinde öğreneceği bir Android uygulaması.

## Temel Fikir
Kullanıcı klavye kullanmadan, ekrandaki kod bloklarını sürükle-bırak yöntemiyle yerleştirerek bir tarım dronunu kontrol ediyor. Kodu çalıştırınca drone ekranda hareket ediyor, tarla tarıyor, köstebek yakalıyor.

## Araçlar
- 🚁 **Agri-Drone:** Başlangıç aracı. Havadan tarama ve tespit.
- 🚜 **Tech-Trax Rover:** İleri görevlerde devreye giren kara aracı.
- İkisi birlikte de kullanılabilecek (drone bul, rover müdahale et).

## Tasarım
- Yatay ekran, ikiye bölünmüş: Sol taraf kod yazma, sağ taraf simülasyon.
- Altta sürüklenebilir komut blokları (scan, scare, loop vb.) ve sembol satırı.
- Google Stitch / Material Design 3 estetiği, pastel renkler.
- Koyu ve açık tema desteği var.

## Teknoloji
- **Kotlin + Jetpack Compose** (Android native)
- **Chaquopy** (uygulama içinde Python kodu çalıştırma)
- **TensorFlow Lite** (düşük donanımda yapay zeka)
- **Lottie/Rive** (animasyonlar)

## Neden Bu Teknoloji?
- En düşük segment (2GB RAM) cihazlarda bile 60 FPS garanti.
- Chaquopy sadece native Android'de çalışıyor, Flutter/React Native'de çalışmıyor.
- Material Design 3 zaten Compose için yapılmış, ekstra efor yok.

## Gelir Modeli
- Ücretsiz: İlk 3 tarla hikayesi + temel Python konuları.
- Premium: AI laboratuvarı, sandbox mod, özel drone/rover görünümleri.

## Şu Anki Durum
- ✅ Vizyon ve plan hazır (v3.0)
- ✅ 3 adet UI mockup tasarlandı
- ✅ Teknoloji ve araç stratejisi onaylandı
- ✅ 8 fazlı geliştirme yol haritası oluşturuldu
- ⏳ Sırada: Android Studio'da proje iskeleti oluşturma (Faz 0)
