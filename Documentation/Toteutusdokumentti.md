# Toteutusdokumentti

Ohjelmassa on luokat käyttöliittymälle, lukemiselle ja tulostukselle sekä FFT:n (Fast Fourier Transform) muunnoksen laskemiselle.

Käyttöliittymä kysyy käyttäjältä testitiedoston osoitteen sekä kuinka monta riviä otetaan mukaan muunnokseen (oltava luvun 2 potenssi).
Lisäksi kysytään tulostettavien taajuuskomponenttien määrää (eli kuinka monta perustaajuuden monikertaa halutaan mukaan tarkasteluun) sekä vielä tehdäänkö tuloksille skaalaus suhteessa perustaajuuteen (siis perustaajuuden amplitudi saa arvon 1 muut sitten suhteessa siihen).

Luku ja tulostus hoitaa tiedostojen lukemisen ja datan trimmaamisen sopivaksi FFT muunnokseen sekä myös käännöksen tulostuksen käyttäjän valintojen mukaisesti. Käyttäjä saa valita kuinka monta taajuuskomponenttia tulostetaan sekä skaalataanko nämä tulokset perusaaallon suhteen jolloin perusaalto saa arvon 1 ja muut lasketaan suhteessa siihen.

FFT muunnokselle on sekä valmista kirjastoa hyödyntävä että oma toteutus joka perustuu Cooleyn-Tukeyn hajoita ja hallitse tyyppiseen algoritmiin. Valmis on manuaalisesti testaamalla todettu oikein toimivaksi ja sitä käytetään oman FFT:n testauksessa vertailuna jotta voidaan todeta oikea toiminta. Hyvin pienillä näytemäärillä ei käytetä FFT:tä vaan normaalia "hidasta" DFT:tä (Discreate Fourier Transform) joka toimii nopeasti kunhan näytteitä on vähän. Ohjelman käyttötarkoituksen vuoksi sekä luettava signaali että tulostettava muunnos ovat reaalisia eikä imaginääriosaa ole tarpeellinen (Tämä todennäköisesti nopeuttaa ohjelman suoritusta. Valitettavasti jouduin silti ainakin toistaiseksi käyttämään kompleksilukuja FFT:n sisäisessä toteutuksessa koska jostain syystä en saanut muuten oikeita tuloksia muunnoksesta.)

DFT muunnoksen aikavaativuus on O(N²), joten se soveltuu hyvin vain tilanteisiin joissa näytemäärä on pieni. Tässä ohjelmassa sitä käytetään jos näytteitä on korkeintaan 32 kappaletta.
FFT muunnoksen aikavaativuus on O(NlogN) eli se on todella paljon nopeampi kun näytemäärät ovat isoja. Miljoonatkaan näytteet eivät tuota ongelmaa käytettäessä FFT algoritmia.


Parannusehdotuksia:

Tiedoston syöttö pitää saada helpoksi. En ole vielä kokeillut miten se onnistuu eri ympäristöissä, esim. miten polku pitää kirjoittaa Windowsilla jolla ohjelmaa todennäköisimmin käytetään jatkossa.

Algoritmien oikea toiminta vaatii sekä näytteiden määrän olevan kakkosen potenssi että täsmälleen perusaallon tai sen monikerran mittaisen pätkän näytteitä. Oskillosskooppi täytyy siis olla oikein aseteltuna (näytteiden määrä perusaallon mittaisella jaksolla oltava kakkosen potenssi) ennen testejä jotta tämä ohjelma toimisi oikein. Olen oppinut että olemassa algoritmeja jolla nämä vaatimukset voidaan ohittaa, mutta ne ovat luultavasti melko haastavia toteuttaa.

Käännöksen tulokset voisi olla kätevää tulostaa suoraan tiedostoon (ainakin käyttäjän halutessa) josta mahdollinen jatkokäsittely onnistuisi helpoiten esim. Excelillä.
