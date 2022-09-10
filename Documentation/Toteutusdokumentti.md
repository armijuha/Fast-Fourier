# Toteutusdokumentti

Ohjelmassa on luokat käyttöliittymälle, lukemiselle ja tulostukselle sekä FFT:n (Fast Fourier Transform) muunnoksen laskemiselle.

Käyttöliittymä kysyy käyttäjältä testitiedoston osoitteen sekä kuinka monta riviä otetaan mukaan muunnokseen (oltava luvun 2 potenssi).
Lisäksi kysytään tulostettavien taajuuskomponenttien määrää (eli kuinka monta perustaajuuden monikertaa halutaan mukaan tarkasteluun) sekä vielä tehdäänkö tuloksille skaalaus suhteessa perustaajuuteen (siis perustaajuuden amplitudi saa arvon 1 muut sitten suhteessa siihen).

Luku ja tulostus hoitaa tiedostojen lukemisen ja datan trimmaamisen sopivaksi FFT muunnokseen sekä myös käännöksen tulostuksen käyttäjän valintojen mukaisesti.

FFT muunnokselle on sekä valmista kirjastoa hyödyntävä että oma toteutus. Valmis on manuaalisesti testaamalla todettu oikein toimivaksi ja sitä käytetään oman FFT:n testauksessa vertailuna jotta voidaan todeta oikea toiminta. Hyvin pienillä näytemäärillä ei käytetä FFT:tä vaan normaalia "hidasta" DFT:tä (Discreate Fourier Transform) joka toimii nopeasti kunhan näytteitä on vähän. Ohjelman käyttötarkoituksen vuoksi sekä luettava signaali että tulostettava muunnos ovat reaalisia eikä imaginääriosaa ole tarpeellinen (Tämä todennäköisesti nopeuttaa ohjelman suoritusta. Valitettavasti jouduin silti ainakin toistaiseksi käyttämään kompleksilukuja FFT:n sisäisessä toteutuksessa koska jostain syystä en saanut muuten oikeita tuloksia muunnoksesta.)
