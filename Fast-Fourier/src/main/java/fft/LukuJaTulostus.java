package fft;

import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Luokka tarjoaa metodit tiedostojen lukemiseen ja tulostamiseen
 *
 * @author armijuha
 */
public class LukuJaTulostus {

    private String tiedostopolku;
    private int luettavatRivit;
    private int luetutRivit;
    private ArrayList<String> ajat;
    private double[] naytteet;
    private String testirivi;

    public LukuJaTulostus(String tiedostopolku, int luettavatRivit) {
        this.tiedostopolku = tiedostopolku;
        this.luettavatRivit = luettavatRivit;
        this.luetutRivit = 0;
        this.ajat = new ArrayList<>();
        this.naytteet = new double[luettavatRivit];
    }

    /**
     * Metodi lukee tiedoston nopeasti rivi riviltä.Aika ja testinäytteet
     * erotellaan omiin listoihinsa ja ylimääräiset välilyönnit poistetaan.
     *
     * @return testidatan näytteet double-taulukossa
     */
    public double[] lueTiedosto() {
        try {
            File f = new File(tiedostopolku);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String rivi = br.readLine(); //lukee datarivejä edeltävän otsikkorivin pois

            while ((luetutRivit < luettavatRivit)) {
                rivi = br.readLine();
                this.luetutRivit++;
                String palat[] = rivi.split("       ");
                String aika = palat[1].trim();
                this.ajat.add(aika);
                String tekstinayte = palat[2].trim(); //tyhjät pois
                tekstinayte = tekstinayte.replace(",", "."); //pilkun vaihto pisteeseen
                double nayte = (Double.parseDouble(tekstinayte));
                naytteet[luetutRivit - 1] = nayte;

            }
            System.out.println("Tiedoston lukeminen valmis, " + luetutRivit + " riviä luettu.");
            return naytteet;

        } catch (Exception e) {
            System.out.println("Jokin tiedoston lukemisessa meni pieleen.");
        }
        return null;
    }

    public void tulosta(double muunnos[], int taajuusmaara, boolean skaalaus) {
        System.out.println("");
        System.out.println("Käännöksestä saatiin seuraavat amplitudit taajuuskomponenteille:");
        System.out.println("");
        double skaalauskerroin = 1.0;
        if (skaalaus) {
            skaalauskerroin = muunnos[1];
        }
        this.testirivi = "0 : " + Math.round(Math.abs(muunnos[0] / skaalauskerroin) * 10000d) / 10000d; //tulosteen testausta varten
        for (int i = 0; i <= taajuusmaara; i++) {
            System.out.println(" " + i + " : " + Math.round(Math.abs(muunnos[i] / skaalauskerroin) * 10000d) / 10000d);

        }
        System.out.println("");
    }

    public void tulostaSaro(double saro) {
        System.out.println("Kokonaissärö valittuun taajuuskomponenttiin asti ja suhteessa perusaaltoon: " + saro * 100 + " %.");
        System.out.println("");
    }

    @Override
    public String toString() {
        return "" + this.luetutRivit + " riviä luettu, 1. aika: " + ajat.get(0)
                + " ja 1. näyte: " + naytteet[0];
    }

    public String otaTestirivi() {
        return this.testirivi;
    }

}
