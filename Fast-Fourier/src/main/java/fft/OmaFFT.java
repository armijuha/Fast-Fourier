package fft;

import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;

/**
 * Luokka laskee FFT:n testidatasta käyttäen omatekemää koodia, joka perustuu
 * Cooley-Tukeyn algoritmiin (jonain päivänä toivottavasti, nyt vielä
 * keskeneräinen).
 *
 * @author armijuha
 */
public class OmaFFT {

    private final double[] data;
    private double[] reaali;
    private double[] imaginaari;

    public OmaFFT(double[] data, int N) {
        this.data = data;
        this.reaali = new double[N];
        this.imaginaari = new double[N];

    }

    /**
     * Metodi laskee digitaalisen fourier käännöksen raa'alla voimalla, joka
     * soveltuu pieniin näytemääriin
     *
     * @return Fourier käännetty data double taulukossa
     */
    public double[] muunnaDDF() {
        int k = 0;
        int N = data.length;

        while (k < N) {

            for (int i = 0; i < data.length; i++) {
                double nayte = data[i];
                this.reaali[k] += nayte * Math.cos(2 * Math.PI / N * i * k);
                //this.imaginaari[k] -= nayte * Math.sin(2 * Math.PI / N * i * k);
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
     */
    public double THD(double muunnos[], int taajuusmaara) {
        double neliosumma = 0;
        for (int i = 2; i < taajuusmaara; i++) {
            neliosumma += muunnos[i] * muunnos[i];
        }
        return Math.sqrt(neliosumma) / Math.abs(muunnos[1]); //laskee ja palauttaa kokonaissäron
    }
}
