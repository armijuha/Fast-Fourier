# Käyttöohje

Ohjelmaa on suunniteltu käytännön hyödyksi oikean virta- tai jännitemittauksen purkamiseen taajuuskomponenteiksi, joten 
myös syötettävän datan muoto on otettu suoraan eräästä käytössä olevasta oskilloskoopin ulosannista. Jos käytetään jotakin muuta oskilloskooppi, ohjelma on melko helposti muokattavissa sille toimivaksi syötteen trimmauksia muokkaamalla.
Alla oleva kuva esittää minkänäköiselle syötettävälle datalle ohjelma on suunniteltu. Ensimmäisessä sarakkeessa juoksee aika ja toisessa mitattavan suureen amplitudi siis esim. virta tai jännite.

![](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/Testin%C3%A4ytekuva.png)

Muutama testauksessa käytetty testidata löytyy: Fast-Fourier/src/test/resources alta.
Ensimmäisen sarakkeen aikadataa ei ainakaan toistaiseksi hyödynnetä mihinkään. Sen sijaan toisessa sarakkeessa oleva
mittaussuureen amplitudi on se jota tarvitaan.

Esim. testidata "nollataajuus8" sisältää (1,0,0,0,0,0,0,0) ja sen käännös (sekä skaalauksella että ilman) tulisi olla tasaista DC:tä eli taajuuden
 nollakomponenttia (1,1,1,1,1,1,1,1).
Toinen testidata "perustaajuus8" (0,1,0,0,0,0,0,0) tulisi kääntyä perustaajuiseksi sinikäyräksi, käännöksen (ilman skaalausta) tulisi
olla sinikäyrältä tasavälein poimittuja pisteitä yhden jakson ajalta, suurinpiirtein (1, 0.707, 0, -0,707, -1...).
Testidata "testi1024" sisältää 1024 näytettä eräästä oikeasta mittauksesta jotka muodostavan suunnilleen yhden
 sinikäyrän jakson ja joka sisältää jonkin verran muita rippelitaajuuksia. Oikeasta käännöksestä ei olisi muuten varmuutta
 mutta testiluokka vertaa sitä ValmisFFT luokan (valmiita kirjastoja hyödyntävä FFT joka on manuaalisin testein havaittu oikein toimivaksi) antamaan käännökseen. 

### Ohjelman käytön vaiheet käytännössä:

1. Ohjelma kysyy käyttäjältä nimen ja tiedostopolun luettavaan tiedostoon
2. Ohjelma kysyy luettavien näytteiden määrän
3. Ohjelma kysyy kuinka monta näytettä luetaan
4. Ohjelma kysyy halutaanko tulokset skaalata suhteessa perusaaltoon vai ei
5. Ohjelma tulostaa halutun määrän Fourier käännöksen tuloksena saatuja taajuuskomponentteja sekä näiden kokonaissärön

Alla esimerkki käännöksen tulostuksesta: 

![](https://github.com/armijuha/Fast-Fourier/blob/main/Documentation/esimerkkitulostus.png)
 
