---
title: Sıfır Klavye Giriş Metodu
date: 2026-05-04
tags: [Neuracode AI, ux, ui, klavyesiz, erisilebilirlik]
status: aktif
---

# Sıfır Klavye Giriş Metodu (Zero-Keyboard Input)

Neuracode AI platformunun ana UI/UX kararıdır. Uygulama içerisinde klasik metin tabanlı (QWERTY) sanal klavye açılmaz.

## Neden Sıfır Klavye?
- Mobil cihazlarda klavyenin açılması ekranın en az yarısını kaplayarak simülasyon alanını (dünyayı) daraltır.
- Yazım hatalarını (syntax error) donanımsal/dokunmatik düzeyde önler.
- Kullanıcıların hızlıca mantık kurmaya odaklanmasını sağlar.

## Çalışma Prensibi
1. **Sürükle-Bırak (Drag-and-Drop):** Python kod blokları modüler parçalar halinde ekranda bulunur.
2. **Boşluk Doldurma:** Şablon halinde sunulan kodların (Örneğin `for i in range(__):`) içindeki boşluklara, ekranda çıkan seçenek çarkından veya listesinden değer seçilir.
3. **Anlık Tepki:** Kullanıcı dokunmatik olarak doğru bağlamı kurduğunda sistem anında görsel geri bildirim verir.
