package fft;

import java.util.Arrays;

/**
 * Luokka laskee FFT:n testidatasta käyttäen omatekemää koodia, joka perustuu
 * Cooley-Tukeyn algoritmiin (jonain päivänä toivottavasti, nyt vielä
 * keskeneräinen).
 *
 * @author armijuha
 */
public class OmaFFT {

    private double[] data;
    private double[] reaali;
    private double kokonaissaro;
    private int lukumaara;
    //private double[] imaginaari;

    public OmaFFT(double[] data, int lukumaara) {
        this.data = data;
        this.lukumaara = lukumaara;
        this.reaali = new double[lukumaara];
        this.kokonaissaro = 0;
        //this.imaginaari = new double[N];

    }

    /**
     * Metodi laskee digitaalisen fourier käännöksen raa'alla voimalla, joka
     * soveltuu pieniin näytemääriin
     *
     * @return Fourier käännetty data double taulukossa
     */
    public double[] muunnaDDF() {
        int k = 0;
        System.out.println("lukum: " +  lukumaara);
        System.out.println("datal: " + data.length);

        while (k < lukumaara) {

            for (int i = 0; i < lukumaara; i++) {
                double nayte = data[i];
                this.reaali[k] += nayte * Math.cos(2 * Math.PI / lukumaara * i * k);
                //this.imaginaari[k] -= nayte * Math.sin(2 * Math.PI / lukumaara * i * k);
            }

            k++;
        }
        return reaali;

        //System.out.println("Reaali: ");
        //System.out.println(Arrays.toString(reaali));
        //System.out.println("Imaginääri: ");
        //System.out.println(Arrays.toString(imaginaari));
    }

    /**
     * Metodi laskee kokonaissärön (Total Harmonic Distorsion) Fourier
     * käännöksen perusteella
     *
     * @param muunnos
     * @param taajuusmaara
     * @return taajuuskomponenteista laskettu kokonaissärö
     */
    public double laskeSaro(double muunnos[], int taajuusmaara) {
        double neliosumma = 0;
        for (int i = 2; i < taajuusmaara; i++) {
            neliosumma += muunnos[i] * muunnos[i];
        }
        this.kokonaissaro = Math.sqrt(neliosumma) / Math.abs(muunnos[1]); //laskee kokonaissäron
        kokonaissaro = Math.round(kokonaissaro * 10000d) / 10000d;
        return kokonaissaro;
    }

    @Override
    public String toString() {
        return "" + this.data.length + " näytettä käännetty, kokonaissärö: " + this.kokonaissaro;
    }
}
