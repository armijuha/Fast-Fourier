# Määrittelydokumentti

Ohjelmointikielenä Java, koska sitä olen käyttänyt peruskursseilla ja siten uskon parhaiten osaavani. Muista kielistä olen käyttänyt Pythonia jollakin kurssilla ja C++:aa joskus kauan sitten. (Lähes 2 vuoteen en ole tosin ohjelmoinut mitään, joten minkä tahansa tekeminen vaatii paljon kertausta).

Työ liittyy signaalinkäsittelyyn ja tavoitteena on saada jopa useita miljoonia näytteitä sisältävä aikatason testidata käännettyä taajuustason esitykseksi nopeasti ja helposti. Tällaiselle ohjelmalle olisi nimittäin henkilökohtaista tarvetta.

Ohjelma saa syötteenä aikatason testidataa, esim. jostakin sähkölaitteesta mitattua sinimuotoista jännitettä tai virtaa joka sisältää yliaaltokomponentteja. Näytteitä on tyypillisesti useita miljoonia joten suuri määrä vaikeuttaa käsittelyä.

Diskreetin Fourier muunnoksen aikavaativuus on O(N²), mutta käytettäessä FFT (Fast Fourier Transform) algoritmeja päästään aikavaativuuteen O(NlogN). Alustavasti käytetään tunnetuinta niistä eli Cooleyn-Tukeyn algoritmia, koska oletettavasti siitä löytyy parhaiten tietoa. Ajan salliessa voidaan tehdä nopeusvertailua myös muiden algoritmien kanssa.

Kuulun opinto-ohjelmaan tietojenkäsittelyn kandidaatti (TKT) ja dokumentaatiossa käytetään suomen kieltä.

## Lähteitä

https://www.princeton.edu/~cuff/ele201/kulkarni_text/frequency.pdf

https://en.wikipedia.org/wiki/Fast_Fourier_transform 

https://en.wikipedia.org/wiki/Cooley%E2%80%93Tukey_FFT_algorithm 

https://towardsdatascience.com/fast-fourier-transform-937926e591cb 

http://qucs.sourceforge.net/tech/node101.html
