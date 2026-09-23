---
title: Neuracode AI Genel Bakış
date: 2026-05-04
tags: [Neuracode AI, overview, moc]
status: aktif
---

# Neuracode AI: Proje Genel Bakış (MOC)

Bu dosya Neuracode AI projesinin ana kontrol panelidir. Projenin genel durumunu ve sürümlerini buradan takip edebilirsin.

## Proje Hakkında
**Neuracode AI**, çocuklar ve gençler için hazırlanmış, "Smart Farming" temalı, Android tabanlı bir Python ve Yapay Zeka öğrenme platformudur. En düşük donanımlı cihazlarda bile yüksek performansla çalışmayı, klasik klavye girişini tamamen ortadan kaldırarak dokunmatik mantık kurmayı (Sürükle-bırak) ve eğitimde oyunlaştırmayı hedefler.

## Onaylanan Teknoloji
**Kotlin + Jetpack Compose** | TensorFlow Lite | Chaquopy

## Araç Stratejisi
🚁 Başlangıç: **[[Agri-Drone]]** (tarım dronu) → 🚜 Orta seviye: **[[Tech-Trax Rover]]** → 🚁+🚜 İleri seviye: İkisi birlikte

## Proje Dosyaları
| Dosya | İçerik |
|-------|--------|
| [[Neuracode AI_Ana_Plan]] | Ana plan ve vizyon belgesi (v3.0) |
| [[UI_Tasarim_Analizi]] | Mockup ekranlarının detaylı analizi |
| [[Teknik_Iskelet]] | Projenin teknik dosya yapısı ve mimarisi |
| [[Teknik_Yol_Haritasi]] | Geliştirme fazları ve mimari diyagram |

## Sürüm Geçmişi
- [[Neuracode AI_Ana_Plan]] (Mevcut Sürüm: v3.0)

*(Not: Yeni bir sürüm eklendiğinde, sürüm dosyaları `Önceki sürüm: [[vX]]` şeklinde birbirine bağlanacaktır.)*

## Çıkarılan Temel Kaynaklar (Zettelkasten)
- [[Agri-Drone]] — Başlangıç aracı, tarla tarama ve hedef tespiti
- [[Tech-Trax Rover]] — Kara aracı, ileri seviye görevler
- [[Sıfır Klavye Giriş Metodu]] — Dokunmatik sürükle-bırak blok sistemi
- [[TinyML ve AI Optimizasyonu]] — Düşük donanım AI mimarisi

## Güncel Durum ve Açık Konular
**Tamamlanan:**
- ✅ Proje ismi **Neuracode AI** olarak güncellendi.
- ✅ Android proje iskeleti oluşturuldu ve yapılandırıldı.
- ✅ Tasarım felsefesi ve araç stratejisi belirlendi (Drone → Rover → İkisi birlikte)
- ✅ UI mockup'ları hazırlandı ve analiz edildi (3 ekran)
- ✅ Teknoloji yığını onaylandı (Kotlin + Jetpack Compose)
- ✅ "Sıfır Klavye" UI/UX kararı alındı
- ✅ TinyML (TensorFlow Lite) altyapısı onaylandı
- ✅ Teknik yol haritası ve geliştirme fazları oluşturuldu
- ✅ Teknik iskelet dökümantasyonu hazırlandı.
- ✅ **Splash Screen** oluşturuldu (Compose animasyonları: pulse + fade-in).
- ✅ **CodeLab etkileşimi** kuruldu (ViewModel + blok tıklama ile boşluk doldurma).
- ✅ **Navigasyon akışı** tamamlandı (Splash → Home → CodeLab).
- ✅ **Uygulama ikonları** oluşturuldu (Adaptive Icon, pastel yeşil tema).
- ✅ **Android Studio** kurulumu ve Gradle Sync başarılı.

**Çözüm Bekleyen (Açık) Konular:**
- [ ] Uygulamanın emülatör/gerçek cihazda ilk kez çalıştırılması ve test edilmesi.
- [ ] Simülasyon motoru: CodeLab sağ paneline drone + tarla Canvas çizimi.
- [ ] Giriş seviyesi cihazlar için 60 FPS performans/uyumluluk testleri.
- [ ] Dersler (Lessons) ekranının tasarımı ve pedagojik içerik yapısı.
- [ ] 8-15 yaş hedef kitlesi için eğitim görevlerinin yazılması.
