/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fft;

import org.apache.commons.math3.complex.Complex;

/**
 * Luokka laskee FFT:n testidatasta käyttäen omatekemää koodia, joka perustuu
 * Cooley-Tukeyn algoritmiin.
 *
 * @author armijuha
 */
public class OmaFFT {

    private final double[] data;
    private double[] reaali;
    private double[] imaginaari;

    public OmaFFT(double[] data, int n) {
        this.data = data;
        this.reaali = new double[n];
        this.imaginaari = new double[n];

    }

    public void muunna() {
        int k = 0;
        int n = data.length;
        while (k < n) {
            for (int i = 0; i < data.length; i++) {
                double nayte = data[i];
                this.reaali[i] += nayte * Math.cos(2 * Math.PI * i / n) * k;
                this.imaginaari[i] += nayte * Math.sin(2 * Math.PI * i / n) * k;

            }
            k++;
        }
     
        System.out.println(reaali);
        System.out.println(imaginaari);
    }

}
