# Testausdokumentti

Käyttöliittymää, io:ta ja FFT luokkaa on testattu manuaalisesti paljon sekä oikeanlaisilla kokonaisluvuilla, että vääränlaisilla kokonaisluvuilla sekä muilla epämääräisillä syötteillä. Kaikkiaan varmasti useita satoja testiajoja sekä ominaisuuksien toiminnan tarkistamiseksi että myös FFT muunnoksen ominaisuuksien ihmettelyn vuoksi.

Luku ja kirjoitusluokan toiminnalle on yksikkötestit, jonka mahdollistamiseksi varsinaista luokkaa on muokattu ja tehty pari pientä metodia testien avuksi. Samoin omalle FFT luokalle on yksinkertainen mutta kattava yksikkötesti joka osittain perustuu vertailuun toimivaksi tiedetyn valmiin FFT:n kanssa. Käyttöliittymää ja valmiisiin kirjastoihin perustuvaa FFT-luokkaa (joka sinällään on tehtykin suurelta osin vain vertailutestejä varten) on testattu vain manuaalisesti, mutta melko paljon.
 
Testikattavuus: ![](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Testikattavuus%202022-09-09%2023-25-05.png)
