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

    public LukuJaTulostus(String tiedostopolku, int luettavatRivit) {
        this.tiedostopolku = tiedostopolku;
        this.luettavatRivit = luettavatRivit;
        this.luetutRivit = 0;
        this.ajat = new ArrayList();
        this.naytteet = new double[luettavatRivit];
    }

    /**
     * Metodi lukee tiedoston nopeasti rivi riviltä.Aika ja testinäytteet
     * erotellaan omiin listoihinsa ja ylimääräiset välilyönnit poistetaan.
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
                naytteet[luetutRivit-1] = nayte;
                System.out.println("luetut rivit: " + luetutRivit);
                System.out.println("luettu nayte: " + nayte);

            }
            System.out.println("Tiedoston lukeminen valmis, " + luetutRivit + " riviä luettu.");
            return naytteet;

        } catch (Exception e) {
            System.out.println("Jokin tiedoston lukemisessa meni pieleen.");
        }
        return null;
    }

    @Override
    public String toString() {
        return "" + this.luetutRivit + " riviä luettu, 1. aika: " + ajat.get(0) +
                " ja 1. näyte: " + naytteet[0];
    }

}
