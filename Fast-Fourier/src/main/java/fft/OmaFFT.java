package fft;

import org.apache.commons.math3.complex.Complex;

/**
 * Luokka laskee FFT:n testidatasta käyttäen Cooley-Tukeyn algoritmiin
 * perustuvaa koodia. Pienillä näytemäärillä käytetään raa'an voiman
 * digitaalista fourier muunnosta DFT:tä.
 *
 */
public class OmaFFT {

    private double[] data;
    private double[] reaali;
    private double kokonaissaro;
    private int lukumaara;

    public OmaFFT(double[] data, int lukumaara) {
        this.data = data;
        this.lukumaara = lukumaara;
        this.reaali = new double[lukumaara];
        this.kokonaissaro = 0;

    }

    /**
     * Metodi valitsee käytettävän algoritmin näytteiden lukumäärän perusteella.
     * Jos näytteitä on enemmän kuin 32 käytetään kompleksilukuja käyttävää FFT
     * algoritmia, jota varten double -näytteet muutetaan Complex muotoon ja
     * käännöksen jälkeen tulokset jälleen doubleksi.
     *
     */
    public double[] muunna() {
        if (this.lukumaara <= 32) {
            return muunnaDFT();
        } else {
            Complex[] kompleksi = new Complex[data.length];
            for (int i = 0; i < data.length; i++) {
                double real = data[i];
                double imag = 0;
                Complex j = new Complex(real, imag);
                kompleksi[i] = j;

            }
            double[] real = new double[data.length];
            Complex[] kaannos = muunnaFFT(kompleksi);
            for (int i = 0; i < kaannos.length; ++i) {
                real[i] = kaannos[i].getReal();
            }
            this.reaali = real;
            return reaali;
        }
    }

    /**
     * Metodi laskee nopean fourier muunnoksen FFT:n, joka soveltuu suurille
     * näytemääriille
     *
     * @return Fourier käännetty data kompleksilukutaulukossa
     */
    public static Complex[] muunnaFFT(Complex[] data) {
        int datanPituus = data.length;
        if (datanPituus == 1) {
            return new Complex[]{data[0]};
        }

        Complex[] parilliset = new Complex[datanPituus / 2];
        for (int i = 0; i < datanPituus / 2; i++) {
            parilliset[i] = data[2 * i];
        }
        Complex[] parillinenMuunnos = muunnaFFT(parilliset);

        Complex[] parittomat = new Complex[datanPituus / 2];
        for (int j = 0; j < datanPituus / 2; j++) {
            parittomat[j] = data[2 * j + 1];
        }
        Complex[] paritonMuunnos = muunnaFFT(parittomat);

        Complex[] kaannos = new Complex[datanPituus];
        for (int k = 0; k < datanPituus / 2; k++) {
            Complex kerroin = new Complex(Math.cos(2 * k * Math.PI / datanPituus), Math.sin(2 * k * Math.PI / datanPituus));
            kaannos[k] = parillinenMuunnos[k].add(kerroin.multiply(paritonMuunnos[k]));
            kaannos[k + datanPituus / 2] = parillinenMuunnos[k].subtract(kerroin.multiply(paritonMuunnos[k]));
        }
        return kaannos;
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
