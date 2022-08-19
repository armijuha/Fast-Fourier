# Toteutusdokumentti

Ohjelmassa on luokat käyttöliittymälle, lukemiselle ja tulostukselle sekä FFT muunnoksen laskemiselle.

Käyttöliittymä kysyy käyttäjältä testitiedoston osoitteen sekä kuinka monta riviä otetaan mukaan muunnokseen (oltava luvun 2 potenssi).
Lisäksi kysytään tulostettavien taajuuskomponenttien määrää (eli kuinka monta perustaajuuden monikertaa halutaan mukaan tarkasteluun) sekä vielä tehdäänkö tuloksille skaalaus suhteessa perustaajuuteen (siis perustaajuuden amplitudi saa arvon 1 muut sitten suhteessa siihen).

Luku ja tulostus hoitaa tiedostojen lukemisen ja datan trimmaamisen sopivaksi FFT muunnokseen sekä myös käännöksen tulostuksen käyttäjän valintojen mukaisesti.

FFT muunnokselle on tällä hetkellä valmiita kirjastoja hyödyntävä malli joka näyttäisi toimivan halutusti sekä vielä työn alle oleva oma FFT toteutus.
Näiden nopeutta olisi mielenkiintoinen vertailla sikäli kun saan jossain vaiheessa oman toteutuksen toimimaan halutusti. 
