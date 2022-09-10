# Fast-Fourier
Fast Fourier muuttaa nopeasti ja helposti suuren määrän aikatason testinäytteitä taajuustason esitykseksi.

[Viikkoraportti 1](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Viikkoraportti%201.md)

[Viikkoraportti 2](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Viikkoraportti%202.md)

[Viikkoraportti 3](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Viikkoraportti3.md)

[Viikkoraportti 4](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Viikkoraportti4.md)

[Viikkoraportti 5](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Viikkoraportti5.md)

[Viikkoraportti 6](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Viikkoraportti6.md)

[Testausdokumentti](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Testausdokumentti.md)

[Toteutusdokumentti](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Toteutusdokumentti.md)

[Käyttöohje](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Kayttoohje.md)


### Komentorivitoiminnot

#### Ohjelman suoritus terminaalista

Projektin koodin pystyy suorittamaan komennolla 
> mvn compile exec:java -Dexec.mainClass=fft.Main

Jar-tiedoston voi luoda komennolla
> mvn package

jolloin saadun tiedoston voi edelleen suorittaa komennolla
> java -jar Fast-Fourier-1.0-SNAPSHOT.jar

#### Testaus

Testit suoritetaan komennolla

> mvn test

Testikattavuusraportti luodaan komennolla

> mvn jacoco:report

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html

#### Checkstyle

Checkstyle tarkastelun voi suorittaa komennolla
> mvn jxr:jxr checkstyle:checkstyle


