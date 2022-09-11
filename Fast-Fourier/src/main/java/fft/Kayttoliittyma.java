package fft;

import java.util.Scanner;

/**
 * Luokka tarjoaa käyttöliittymän ohjelmalle.
 *
 * @author armijuha
 */
public class Kayttoliittyma {

    private Scanner scanner;
    private int lukumaara;
    private int taajuusmaara;
    private boolean skaalaus;

    public Kayttoliittyma() {
        this.scanner = new Scanner(System.in);
        this.lukumaara = 0;
        this.taajuusmaara = 0;
        this.skaalaus = true;
    }

    /**
     * Metodi kysyy käyttäjältä syötteet ladattavalle tiedostolle ja laskennassa
     * käytettävien näytteiden lukumäärälle sekä tarkistaa, että lukumäärä on
     * luvun 2 potenssi. Lisäksi kysytään käännöksen jälkeen haluttu
     * tulostettavien taajuuskomponenttien määrä ja tarkistetaan sen sopivuus.
     *
     */
    public void aloita() {
        System.out.println("");
        System.out.println("*************************************************************************");
        System.out.println("Fast-Fourier muuttaa reaaliset aikatason näytteet nopeasti taajuustasoon");
        System.out.println("*************************************************************************");
        System.out.println("");

        System.out.println("Anna tiedoston sijainti ja nimi (esim: /home/armijuha/Tiralabra/perustaajuus8):");
        String tiedostopolku = scanner.nextLine();

        while (lukumaara <= 1) {
            System.out.println("Kuinka monta näytettä luetaan? Määrän tulee olle kakkosen potenssi kuten esim. 32, 1024 tai 1048576: ");

            if (tarkistaSyote()) {
                lukumaara = Integer.parseInt(scanner.nextLine());
                if ((lukumaara & (lukumaara - 1)) != 0) { //tarkistaa onko kakkosen potenssi
                    lukumaara = 0;
                    System.out.println("Virheellinen syöte, luku ei ole kakkosen potenssi");
                }
            }
        }

        LukuJaTulostus ljt = new LukuJaTulostus(tiedostopolku, lukumaara);
        double naytteet[] = ljt.lueTiedosto();

        OmaFFT offt = new OmaFFT(naytteet, lukumaara);
        double muunnos[] = offt.muunna();

        System.out.println("Kuinka monenteen taajuuteen asti tulostetaan? (valitse väliltä 1-200, mutta kuitenkin vähemmän kuin luettujen näytteiden määrä)");
        while (taajuusmaara < 1) {
            if (tarkistaSyote()) {
                taajuusmaara = Integer.parseInt(scanner.nextLine());
                if (taajuusmaara < 1 || taajuusmaara > 200 || taajuusmaara >= lukumaara) {
                    taajuusmaara = 0;
                    System.out.println("Virheellinen syöte, luku ei ole sopiva");
                }
            }
        }

        System.out.println("Jos et halua tulosten skaalausta perusaaltoon nähden, paina e. Jos haluat skaalata, paina jotain muuta nappia");
        String vastaus = scanner.nextLine();
        if (vastaus.equals("e")) {
            skaalaus = false;
        }

        ljt.tulosta(muunnos, taajuusmaara, skaalaus);
        double saro = offt.laskeSaro(muunnos, taajuusmaara);
        ljt.tulostaSaro(saro);

        System.out.println("Kiitos käännöksestä, tervetuloa uudelleen!");
    }

    /**
     * Tarkistaa että syöte on kokonaisluku.
     *
     * @return totuusarvo tarkistetun syötteen oikeellisuudelle
     */
    public boolean tarkistaSyote() {
        if (scanner.hasNextInt()) {
            return true;
        } else {
            System.out.println("Virheellinen syote, ei ole kokonaisluku");
        }
        String putsaaRivi = scanner.nextLine();
        return false;
    }

}
