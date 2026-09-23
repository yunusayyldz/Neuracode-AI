---
title: Neuracode AI Master Plan
version: v3.0
date: 2026-05-04
tags: [Neuracode AI, v3.0, python, android, ai]
status: aktif
related: []
---

# Neuracode AI: Python & AI Öğrenme Ekosistemi (Master Plan v3.0)

Bu belge, çocuklar ve gençler için hazırlanan, düşük sistem gereksinimli ve oyunlaştırılmış Android tabanlı Python öğrenme platformunun teknik, tasarım ve eğitim dökümantasyonudur.

---

## 1. Vizyon ve Tasarım Felsefesi

* **Tema:** Gelecek nesil dijital tarım (Smart Farming).
* **Ana Karakter:** Başlangıçta **Agri-Drone** (tarım dronu). İlerleyen görevlerde **[[Tech-Trax Rover]]** (kara aracı) devreye girecek; bazı görevlerde ikisi birlikte kullanılabilecek.
* **Tasarım Dili:** "Google Stitch" (Material Design 3) tabanlı; sade, pastel tonlara sahip, yumuşak köşeli ve minimalist arayüz.
* **Erişilebilirlik:** En düşük segment Android cihazlarda bile akıcı (60 FPS) çalışma garantisi.
* **Onaylanan Teknoloji:** Kotlin + Jetpack Compose, TensorFlow Lite, Chaquopy.

---

## 2. Arayüz ve Kullanıcı Deneyimi (UX/UI)

### A. Oryantasyon ve Yerleşim
* **Yatay (Landscape) Öncelikli:** Ekran yatay modda ikiye bölünür.
    * **Sol Bölme (Kod Alanı):** Kullanıcının mantığı kurduğu "IDE" alanı.
    * **Sağ Bölme (Dünya):** Tech-Trax'ın hareket ettiği 3D/2D simülasyon alanı.
* **Dikey (Portrait) Desteği:** Ekran üst-alt (Simülasyon-Kod) şeklinde uyarlanır.

### B. "[[Sıfır Klavye Giriş Metodu|Sıfır Klavye]]" Giriş Metodu
* **Klavye Erişimi:** Uygulama içinde klasik klavye açılmaz. Tüm etkileşim dokunmatik tabanlıdır.
* **Sürükle-Bırak (Drag-and-Drop):** Python kod yapıları bloklar halinde sunulur. Kullanıcı doğru mantık sırasına göre blokları yerleştirir.
* **Boşluk Doldurma:** Hazır kod satırındaki kritik değişkenler veya fonksiyon isimleri, sunulan seçenekler arasından seçilerek yerleştirilir.
* **Görsel Geri Bildirim:** Bir blok yerleştirildiği an, sağdaki simülasyon alanında Tech-Trax anlık tepki verir (Örn: Işıkları yanar, motoru çalışır).

---

## 3. Oyunlaştırılmış Eğitim Müfredatı

Eğitim süreci bir hikaye akışına (Story-arc) bağlıdır: **"Kendi Akıllı Çiftliğini Kur ve Koru"**

### A. Öğrenme Döngüsü
1.  **Animasyonlu Giriş:** Yeni bir kavrama geçildiğinde (Örn: For döngüsü), Tech-Trax'ın o görevi neden yapması gerektiğini anlatan kısa, sade ve eğlenceli bir animasyon gösterilir.
2.  **Örnek Uygulama:** Kavramın kod üzerindeki karşılığı "dolaylı" olarak gösterilir.
3.  **Görev (Challenge):** Kullanıcı boşlukları doldurarak veya blokları dizerek sorunu çözer.

### B. Bölüm Senaryoları (Örnekler)
* **Değişkenler:** Farklı tohum türlerini (string), miktarını (int) ve nem oranını (float) belirleyerek ekime başlama.
* **Döngüler:** Tarladaki 10 farklı sırayı tek bir komutla sulama.
* **Koşullu İfadeler (If-Else):** "Eğer toprak kuruysa sula, ıslaksa bekle."
* **AI ve Görüntü İşleme:** Köstebekleri tespit eden bir model kurma ve Tech-Trax'ı onları korkutup kaçırması için yönlendirme.

---

## 4. Teknik Mimari ve Optimizasyon

### A. Düşük Sistem Gereksinimi (Universal Access)
* **[[TinyML ve AI Optimizasyonu|TinyML]]:** Ağır AI kütüphaneleri yerine, Android cihazlarda en az RAM tüketecek şekilde optimize edilmiş **TensorFlow Lite (INT8 Quantized)** modelleri kullanılır.
* **Dinamik Render:** Cihazın GPU gücüne göre simülasyonun görsel kalitesi (Low-Poly/Standard) otomatik ayarlar.
* **Chaquopy:** Python kodlarının Android içinde sıfır gecikmeyle koşturulmasını sağlayan köprü sistemi.

### B. Uygulama Boyutu
* **On-Demand Resources:** Uygulamanın temel dosyaları küçük tutulur; yeni hikayeler ve AI modelleri kullanıcı ilerledikçe arka planda indirilir.

---

## 5. Gelir Modeli ve Yayın Stratejisi

* **Ücretsiz (Free):** Temel Python (Değişkenler, Döngüler, Koşullar) ve ilk 3 tarla hikayesi tamamen ücretsizdir.
* **Tam Plan (Premium):** * Yapay Zeka Laboratuvarı (Görüntü işleme, tahminleme).
    * Gelişmiş "Kendi Tarlanı Tasarla" (Sandbox) modu.
    * Özel Tech-Trax görünümleri (Skins).
* **Satın Alma:** Tek seferlik ödeme veya aile paketi seçeneği.

---

## 6. Gelecek Gelişim Protokolü

* [ ] **Cihaz Uyumluluk Testi:** Giriş seviyesi (2GB RAM) cihazlar için performans analizi.
* [ ] **Animasyon Kütüphanesi:** Lottie veya Rive kullanılarak yüksek kaliteli ama düşük boyutlu animasyonların hazırlanması.
* [ ] **Eğitim Tasarımı:** 8-15 yaş pedagojisine uygun metin ve görevlerin netleştirilmesi.

---
*Bu belge, Yunus Ayyıldız'ın vizyonu doğrultusunda projenin tüm teknik ve yaratıcı detaylarını kümülatif olarak içermektedir.*
