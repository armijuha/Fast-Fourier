
package fft;

import java.util.Scanner;

/**
 *Luokka tarjoaa käyttöliittymän ohjelmalle.
 * 
 * @author armijuha
 */
public class Kayttoliittyma {
    
    private Scanner scanner;
    private int lukumaara;
    
    public Kayttoliittyma() {
        this.scanner = new Scanner(System.in);
        this.lukumaara = 0;   
    }
    /**
     * Metodi kysyy käyttäjältä syötteet ladattavalle tiedostolle
     * ja laskennassa käytettävien näytteiden lukumäärälle sekä tarkistaa,
     * että lukumäärä on luvun 2 potenssi.
     * 
     */
    public void start() {
        System.out.println("*************************************************************************");
        System.out.println("Fast-Fourier muuttaa aikatason näytteet nopeasti taajuustasoon");
        System.out.println("*************************************************************************");
        
        System.out.println("Anna tiedoston sijainti ja nimi (esim: /home/armijuha/Tiralabra/tuhat):");
        String tiedostopolku = scanner.nextLine();
        
        while (lukumaara <= 1) {
            System.out.println("Kuinka monta näytettä luetaan? Määrän tulee olle kakkosen potenssi kuten esim. 32, 1024 tai 1048576: ");
        
            if (tarkistaSyote()) {
                lukumaara = Integer.parseInt(scanner.nextLine());
                if ((lukumaara & (lukumaara - 1)) != 0) {
                    lukumaara = 0;
                    System.out.println("Virheellinen syöte, luku ei ole kakkosen potenssi");
                }
            }
        }
        
        LukuJaTulostus ljt = new LukuJaTulostus(tiedostopolku, lukumaara);
        ljt.lueTiedosto();
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

