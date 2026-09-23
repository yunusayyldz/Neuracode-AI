package com.neuracode.ai.data

import com.neuracode.ai.ui.viewmodel.CodeLineData
import com.neuracode.ai.ui.viewmodel.Lesson

object LessonRepository {
    val lessons = mapOf(
        // ==========================================
        // BÖLÜM 1: TEMEL KAVRAMLAR
        // ==========================================
        "bolum1_giris" to Lesson(
            id = "bolum1_giris",
            title = "1. İlk Komut - Drone'a Söz Vermek",
            story = "Bir köpek sahibi köpeğine 'otur' der. Köpek bu komutu duyar ve oturur. Drone da aynı şekilde çalışır. Ona 'kalk' dersen kalkar, 'in' dersen iner.",
            initialCodeLines = listOf(
                CodeLineData(1, "# Drone'a ilk komutumuz"),
                CodeLineData(2, "drone.", "()", isInteractive = true, expectedValue = "kalk")
            ),
            commandBlocks = listOf("kalk", "in", "bekle", "ileri")
        ),
        "bolum1_bronz" to Lesson(
            id = "bolum1_bronz",
            title = "Bölüm 1: Görev 1 (Bronz)",
            story = "Görev: Drone kalkacak, sonra inecek. Başarı: Drone yere inerse tamamdır!",
            initialCodeLines = listOf(
                CodeLineData(1, "drone.", "()", isInteractive = true, expectedValue = "kalk"),
                CodeLineData(2, "drone.", "()", isInteractive = true, expectedValue = "in")
            ),
            commandBlocks = listOf("kalk", "in")
        ),

        // ==========================================
        // BÖLÜM 2: Yön Bulma - İleri, Geri, Sağa, Sola
        // ==========================================
        "bolum2_giris" to Lesson(
            id = "bolum2_giris",
            title = "2. Yön Bulma",
            story = "Evden okula yürümek gibi: 5 adım ileri, sağa dön, 10 adım ileri... Drone'umuzu da böyle yönlendirebiliriz.",
            initialCodeLines = listOf(
                CodeLineData(1, "drone.kalk()"),
                CodeLineData(2, "drone.ileri(", ")", isInteractive = true, expectedValue = "2"),
                CodeLineData(3, "drone.in()")
            ),
            commandBlocks = listOf("1", "2", "3", "5")
        ),
        "bolum2_bronz" to Lesson(
            id = "bolum2_bronz",
            title = "Bölüm 2: Görev 1 (Bronz)",
            story = "İleri git, geri gel, başlangıç noktasına dön.",
            initialCodeLines = listOf(
                CodeLineData(1, "drone.kalk()"),
                CodeLineData(2, "drone.ileri(", ")", isInteractive = true, expectedValue = "2"),
                CodeLineData(3, "drone.", "(2)", isInteractive = true, expectedValue = "geri"),
                CodeLineData(4, "drone.in()")
            ),
            commandBlocks = listOf("2", "geri", "sola", "saga")
        ),

        // ==========================================
        // BÖLÜM 3: Dönme - Saga_don, Sola_don
        // ==========================================
        "bolum3_giris" to Lesson(
            id = "bolum3_giris",
            title = "3. Dönme Açısı",
            story = "Saat ibreleri 12'den 3'e giderse 90 derece döner. Dönme dolap tam tur atarsa 360 derece döner.",
            initialCodeLines = listOf(
                CodeLineData(1, "drone.kalk()"),
                CodeLineData(2, "drone.saga_don(", ")", isInteractive = true, expectedValue = "90"),
                CodeLineData(3, "drone.in()")
            ),
            commandBlocks = listOf("90", "180", "360")
        ),

        // ==========================================
        // BÖLÜM 4: Tekrar - For Döngüsü
        // ==========================================
        "bolum4_giris" to Lesson(
            id = "bolum4_giris",
            title = "4. For Döngüsü",
            story = "Merdiven çıkarken hep aynı hareketi yaparız. 20 basamak için 20 kez aynı şey! Kodlamada bunun adı döngüdür.",
            initialCodeLines = listOf(
                CodeLineData(1, "drone.kalk()"),
                CodeLineData(2, "for i in range(", "):", isInteractive = true, expectedValue = "3"),
                CodeLineData(3, "    drone.yukari(1)"),
                CodeLineData(4, "drone.in()")
            ),
            commandBlocks = listOf("3", "5", "10")
        ),
        
        // ==========================================
        // BÖLÜM 5: Karar Verme - If/Else
        // ==========================================
        "bolum5_giris" to Lesson(
            id = "bolum5_giris",
            title = "5. If/Else Kararları",
            story = "EĞER hava yağmurluysa şemsiye al, DEĞİLSE alma. Drone da piline göre karar verebilir.",
            initialCodeLines = listOf(
                CodeLineData(1, "pil = 80"),
                CodeLineData(2, "if pil > 50:"),
                CodeLineData(3, "    drone.ileri(", ")", isInteractive = true, expectedValue = "5"),
                CodeLineData(4, "else:"),
                CodeLineData(5, "    drone.ileri(1)")
            ),
            commandBlocks = listOf("5", "1", "10")
        ),

        // ==========================================
        // BÖLÜM 6: Değişkenler - Bilgi Saklama
        // ==========================================
        "bolum6_giris" to Lesson(
            id = "bolum6_giris",
            title = "6. Değişkenler",
            story = "Kumbara bir değişkendir, içindeki para değişir ama kumbara hep ordadır.",
            initialCodeLines = listOf(
                CodeLineData(1, "toplam_mesafe = ", "", isInteractive = true, expectedValue = "0"),
                CodeLineData(2, "drone.kalk()"),
                CodeLineData(3, "toplam_mesafe = toplam_mesafe + 2"),
                CodeLineData(4, "drone.ileri(2)")
            ),
            commandBlocks = listOf("0", "1", "mesafe")
        ),

        // ==========================================
        // BÖLÜM 7: While Döngüsü (ORTA SEVİYE)
        // ==========================================
        "bolum7_giris" to Lesson(
            id = "bolum7_giris",
            title = "7. While Döngüsü",
            story = "Kova dolana kadar suyu açık bırakmak gibidir. Bir koşul sağlanana kadar işlem devam eder.",
            initialCodeLines = listOf(
                CodeLineData(1, "yukseklik = 0"),
                CodeLineData(2, "while yukseklik < ", ":", isInteractive = true, expectedValue = "5"),
                CodeLineData(3, "    drone.yukari(1)"),
                CodeLineData(4, "    yukseklik = yukseklik + 1")
            ),
            commandBlocks = listOf("5", "10", "100")
        ),

        // ==========================================
        // BÖLÜM 8: Fonksiyonlar
        // ==========================================
        "bolum8_giris" to Lesson(
            id = "bolum8_giris",
            title = "8. Kendi Komutunu Yarat",
            story = "Bulaşık makinesinin 'Yıka' tuşu gibi, birçok adımı tek bir isim altında toplarız.",
            initialCodeLines = listOf(
                CodeLineData(1, "def ", "():", isInteractive = true, expectedValue = "kare_ciz"),
                CodeLineData(2, "    for i in range(4):"),
                CodeLineData(3, "        drone.ileri(2)"),
                CodeLineData(4, "        drone.saga_don(90)")
            ),
            commandBlocks = listOf("kare_ciz", "dans_et", "ucgen_ciz")
        ),

        // ==========================================
        // BÖLÜM 9: Parametreli Fonksiyonlar
        // ==========================================
        "bolum9_giris" to Lesson(
            id = "bolum9_giris",
            title = "9. Parametreli Fonksiyonlar",
            story = "Akıllı fırına '180 derece, 30 dakika' diyebilmek gibidir. Komutlara özel ayarlar gönderebiliriz.",
            initialCodeLines = listOf(
                CodeLineData(1, "def kare_ciz(kenar_uzunlugu):"),
                CodeLineData(2, "    for i in range(4):"),
                CodeLineData(3, "        drone.ileri(", ")", isInteractive = true, expectedValue = "kenar_uzunlugu")
            ),
            commandBlocks = listOf("kenar_uzunlugu", "aci", "mesafe")
        ),

        // ==========================================
        // BÖLÜM 10: Listeler
        // ==========================================
        "bolum10_giris" to Lesson(
            id = "bolum10_giris",
            title = "10. Listeler",
            story = "Alışveriş listesi gibi, birçok değeri tek bir değişkende sırayla tutmamızı sağlar.",
            initialCodeLines = listOf(
                CodeLineData(1, "hedefler = [", "]", isInteractive = true, expectedValue = "2, 4, 1, 3"),
                CodeLineData(2, "for mesafe in hedefler:"),
                CodeLineData(3, "    drone.ileri(mesafe)")
            ),
            commandBlocks = listOf("2, 4, 1, 3", "1, 2", "0")
        ),

        // ==========================================
        // BÖLÜM 11: İç İçe Döngüler (İLERİ SEVİYE)
        // ==========================================
        "bolum11_giris" to Lesson(
            id = "bolum11_giris",
            title = "11. İç İçe Döngüler",
            story = "Tarlayı süren traktör gibi. Dış döngü satırları, iç döngü her satırdaki ilerlemeyi belirler.",
            initialCodeLines = listOf(
                CodeLineData(1, "for satir in range(3):"),
                CodeLineData(2, "    for sutun in range(", "):", isInteractive = true, expectedValue = "3"),
                CodeLineData(3, "        drone.ileri(1)")
            ),
            commandBlocks = listOf("3", "5", "1")
        ),

        // ==========================================
        // BÖLÜM 12: Gerçek Sensör Kullanımı
        // ==========================================
        "bolum12_giris" to Lesson(
            id = "bolum12_giris",
            title = "12. Gerçek Sensör Kullanımı",
            story = "Drone sensörleri, drone'un gözleridir. Engel var mı? Çok mu yükseldik? Sensörlerle öğreniriz.",
            initialCodeLines = listOf(
                CodeLineData(1, "mesafe = drone.sensor_on.", "()", isInteractive = true, expectedValue = "mesafe_olc"),
                CodeLineData(2, "if mesafe < 1:"),
                CodeLineData(3, "    print(\"Engel çok yakın! Duruyorum\")")
            ),
            commandBlocks = listOf("mesafe_olc", "kalk", "in")
        ),

        // ==========================================
        // BÖLÜM 13: Görev Planlama
        // ==========================================
        "bolum13_giris" to Lesson(
            id = "bolum13_giris",
            title = "13. Görev Planlama",
            story = "Yemek tarifi gibi. Önce su kaynat, sonra makarna at. Sıra çok önemlidir!",
            initialCodeLines = listOf(
                CodeLineData(1, "for gorev in ", ":", isInteractive = true, expectedValue = "gorevler"),
                CodeLineData(2, "    print(gorev[\"ad\"])"),
                CodeLineData(3, "    drone.git(gorev[\"x\"], gorev[\"y\"], 2)")
            ),
            commandBlocks = listOf("gorevler", "listeler", "fonksiyonlar")
        )
    )
}
