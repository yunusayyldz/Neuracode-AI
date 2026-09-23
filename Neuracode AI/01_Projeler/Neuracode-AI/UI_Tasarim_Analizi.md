---
title: Neuracode AI UI Tasarım Analizi
version: v1.0
date: 2026-05-04
tags: [Neuracode AI, ui, ux, tasarim, mockup]
status: aktif
related: [[Neuracode AI_Ana_Plan]]
---

# Neuracode AI UI Tasarım Analizi

Bu not, Neuracode AI uygulamasının görsel tasarım mockup'larının detaylı analizini içerir.

---

## Ekran 1 & 2: Kod Laboratuvarı (CODE LAB) — Yatay Mod

![[01_Kod_Lab_Koyu_Tema.png]]
![[02_Kod_Lab_Acik_Tema.png]]

İki farklı renk paleti (Koyu Tema / Açık Tema) ile sunulan ana öğrenme ekranı. **Yatay (landscape) modda** çalışır.

### Ekran Yapısı (İkili Bölme)
| Bölge | İçerik |
|-------|--------|
| **Sol — CODE LAB** | Satır numaralı Python kodu, boşluk doldurma alanları (`_____`), ilerleme çubuğu, faz numarası (Phase 2.1) |
| **Sağ — SIMULATION PREVIEW** | Drone/araç animasyonu, hedef tespiti (Target: Mole), durum bilgisi (Status: Detected), sorun işaretleri (problem) |

### Üst Çubuk (Header)
- Hamburger menü (☰)
- Kullanıcı avatarı ve yıldız seviye göstergesi (★★★☆)
- **"Neuracode AI"** başlığı (ortada)
- **Scores** rozeti: Yeşil (4), Kırmızı (1), Turuncu (0)
- **Achievements** butonu (🏆)

### Alt Bölge — [[Sıfır Klavye Giriş Metodu]]
- **Komut Blokları (Sürükle-Bırak):** `scan`, `scare`, `continue`, `wait`, `loop` — her biri ikonlu, renkli butonlar.
- **Sembol Satırı:** `! @ # $ % ^ & ( ) * < > / 0` — gerektiğinde kod içine eklenmek üzere tek dokunuşla seçilebilir karakterler.
- **"Drop block here"** alanı: Blokların sürüklenip bırakılacağı hedef kutu.

### Renk Paleti Karşılaştırması
| Özellik | Koyu Tema (Resim 1) | Açık Tema (Resim 2) |
|---------|---------------------|---------------------|
| Arka plan | Koyu mavi/lacivert tonları | Açık mavi/turkuaz/yeşil tonları |
| Kod blokları | Beyaz üzerine koyu metin | Beyaz üzerine koyu metin |
| Komut butonları | Gri/pastel | Renkli (mavi, yeşil, sarı, turuncu) |
| Simülasyon zemini | Grimsi harita | Yeşil harita, hareket okları gösterilmiş |
| Achievements | Beyaz metin | Altın/turuncu arka plan vurgusu |

### Tespit Edilen Tasarım Kararları
1. **"Sıfır Klavye" tam olarak uygulanmış.** Klasik QWERTY klavye yok; alt kısımda sadece komut blokları ve semboller var.
2. **Anlık geri bildirim aktif.** Sağ paneldeki simülasyonda drone hareket ediyor, "Status: Detected" gibi durum mesajları gösteriliyor.
3. **Boşluk doldurma:** `drone._____("mole_detected")` şeklinde, kullanıcının alt blok paletinden doğru komutu sürükleyip bırakması bekleniyor.
4. **Gamification:** Yıldızlar, Scores rozeti ve Achievements butonu ile oyunlaştırma mekanizması entegre edilmiş.

---

## Ekran 3: Ana Menü / Karşılama Ekranı

![[03_Ana_Menu_Ekrani.png]]

### Ekran Yapısı
| Öğe | Açıklama |
|-----|----------|
| **Başlık** | "AGRI-CODE" (üst orta, koyu yeşil) |
| **Alt Başlık** | "HARVEST LOGIC" (büyük, bold tipografi) |
| **Ana Buton** | Ortada büyük dairesel "PLAY NOW" butonu, içinde [[Tech-Trax Rover]] (traktör) ikonu |
| **Alt Menü** | 3 buton: "Continue Previous Farm" (devam et), "Lessons" (dersler), "Settings" (ayarlar) |
| **Arka Plan** | Geometrik, pastel renkli (pembe, yeşil, bej) üçgen/çokgen deseni — "Google Stitch" / Material Design 3 estetiği |

### Tespit Edilen Tasarım Kararları
1. **Minimalist ve sade.** Çocuk dostu ama çocuksu değil — genç kullanıcılar için de uygun.
2. **Pastel renk paleti** Master Plan'daki "Google Stitch" tasarım diline uygun.
3. **Traktör ikonu = [[Tech-Trax Rover]]** — karakter doğrudan ana ekranda temsil ediliyor.
4. **3 net eylem:** Oyna, Devam Et, Dersler. Kullanıcıyı kararsız bırakmayan basit bir yönlendirme.

---

## Genel Mimari Çıkarımlar

Bu mockup'lardan çıkan teknik ve tasarım kararları:

1. **Tam yatay (Landscape) mod:** Ana oyun/öğrenme ekranı mutlaka yatay modda çalışacak.
2. **İkili bölme (Split View):** Sol = Kod, Sağ = Simülasyon. Bu sabit kalacak.
3. **Blok paleti + Sembol satırı:** QWERTY klavye yerine iki katmanlı bir alt menü.
4. **Faz/Bölüm sistemi:** "Phase 2.1 - Mole Guard" gibi numaralı görevler.
5. **Çift tema desteği:** Koyu ve açık tema alternatifleri mevcut.
6. **Drone da var!** Master Plan'da sadece "Tech-Trax Rover" (traktör) geçiyor ancak mockup'larda bir drone (İHA) da görünüyor. Bu, aracın sadece kara aracı değil hava aracı da olabileceğini veya görev bazlı farklı araçların kullanılacağını gösteriyor.
