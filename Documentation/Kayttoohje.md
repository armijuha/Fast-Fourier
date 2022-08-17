# Käyttöohje

Ohjelmaa on suunniteltu käytännön hyödyksi oikean virta- tai jännitemittauksen purkamiseen taajuuskomponenteiksi, joten 
myös syötettävän datan muoto on otettu suoraan eräästä käytössä olevasta oskilloskoopin ulosannista.

Muutama testauksessa käytetty testidata löytyy: Fast-Fourier/src/test/resources alta.
Ensimmäisen sarakkeen aikadataa ei ainakaan toistaiseksi hyödynnetä mihinkään. Sen sijaan toisessa sarakkeessa oleva
mittaussuureen amplitudi on se jota tarvitaan.

Esim. testidata "nollataajuus8" sisältää (1,0,0,0,0,0,0,0) ja sen käännös tulisi olla tasaista DC:tä eli taajuuden
 nollakomponenttia (1,1,1,1,1,1,1,1).
Toinen testidata "perustaajuus8" (0,1,0,0,0,0,0,0) tulisi kääntyä perustaajuiseksi sinikäyräksi, käännöksen tulisi
olla sinikäyrältä tasavälein poimittuja pisteitä yhden jakson ajalta, suurinpiirtein (1, 0.707, 0, -0,707, -1...).
Testidata "testi1024" sisältää 1024 näytettä eräästä oikeasta mittauksesta jotka muodostavan suunnilleen yhden
 sinikäyrän jakson ja joka sisältää jonkin verran muita rippelitaajuuksia. oikeasta käännksestä ei ole muuten varmuutta mutta sitä voi verrata esim. ValmisFFT luokan (valmiita kirjastoja hyödyntävä FFT) antamaan käännökseen.


 
