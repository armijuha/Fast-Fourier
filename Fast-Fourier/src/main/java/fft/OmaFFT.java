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

    public double[] muunna() {
        if (this.lukumaara > 16) {
            return muunnaFFT(this.data);
        } else {
            return muunnaDFT();
        }
    }

    public double[] muunnaFFT(double[] data) {
        int datanPituus = data.length;
        if (datanPituus
                == 1) {
            return new double[]{data[0]};
        }

        double[] parilliset = new double[datanPituus / 2];
        for (int i = 0;
                i < (datanPituus
                / 2); i++) {
            parilliset[i] = data[2 * i];
        }
        double[] parillinenMuunnos = muunnaFFT(parilliset);

        double[] parittomat = new double[datanPituus / 2];
        for (int j = 0;
                j < (datanPituus
                / 2); j++) {
            parittomat[j] = data[2 * j + 1];
        }
        double[] paritonMuunnos = muunnaFFT(parittomat);

        int k = 0;
        while (k < datanPituus / 2) {
            double kerroin = Math.cos(2 * k * Math.PI / datanPituus);
            System.out.println("kerroin: " + kerroin + "   k: " + k + "   datanPituus: " + datanPituus);
            reaali[k] += parillinenMuunnos[k] + kerroin * paritonMuunnos[k];
            System.out.println("parillinen: " + reaali[k]);
            reaali[k + datanPituus / 2] += parillinenMuunnos[k] - kerroin * paritonMuunnos[k];
            System.out.println("pariton: " + reaali[k + datanPituus / 2]);
            k++;
            System.out.println("K loopin lopussa: " + k);
        }
        return reaali;
    }

    /**
     * Metodi laskee digitaalisen fourier käännöksen raa'alla voimalla, joka
     * soveltuu pieniin näytemääriin
     *
     * @return Fourier käännetty data double taulukossa
     */
    public double[] muunnaDFT() {
        int k = 0;

        while (k < lukumaara) {

            for (int i = 0; i < lukumaara; i++) {
                double nayte = data[i];
                this.reaali[k] += nayte * Math.cos(2 * Math.PI / lukumaara * i * k);
                //this.imaginaari[k] -= nayte * Math.sin(2 * Math.PI / lukumaara * i * k);
            }

            k++;
        }
        return reaali;

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
        for (int i = 2; i <= taajuusmaara; i++) {
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
