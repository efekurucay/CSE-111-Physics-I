#  Akdeniz University CSE-111-Physics-I Final Exam Homework Part

Hello, I am Yahya Efe Kuruçay.

I am a computer engineering student at Akdeniz University.

This repo contains the programming assignments I have completed in my Akdeniz University physics lectures.

The assignments are written in Java.

For more information about the content of the assignments and the technologies I used, 
please see the README files (generally there are pdf's in the folders) for the respective assignments.

I share this repo to leave a digital footprint on the internet. I don't know why, I just like it.

If you have any questions, please feel free to contact me at <a href="https://www.efekurucay.com/" style="color: #00b006;">my website</a>.

Thank you.
2024.

# Fizik Hareket Simülatörü

Bu program temel fizik hareket denklemlerini hesaplayan basit bir simülatördür.

## Özellikler

- Düz hareket hesaplamaları
- Serbest düşme simülasyonu
- Düşey atış simülasyonu
- Hız, mesafe, zaman hesaplamaları

## Hesaplanan Değerler

- Anlık hız
- Alınan yol
- Maksimum yükseklik (düşey atış için)
- Yere düşme süresi

## Kullanım

Program çalıştırıldığında menüden istenen hareket tipi seçilir:

1. Düz Hareket: Sabit ivmeli hareket hesapları
2. Serbest Düşme: Belirli yükseklikten bırakılan cismin hareketi
3. Düşey Atış: Yukarı doğru fırlatılan cismin hareketi
4. Çıkış: Programı sonlandırır

## Formüller

- Hız: v = v0 + at
- Mesafe: x = v0t + (1/2)at²
- Maksimum yükseklik: h = v0²/2g
- Düşme süresi: t = 2v0/g

## Derleme ve Çalıştırma

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.physics.Main"
```

## Yazar

Yahya Efe Kuruçay
