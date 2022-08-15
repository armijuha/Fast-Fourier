/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fft;

import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;

/**
 * Luokka laskee FFT:n testidatasta käyttäen omatekemää koodia, joka perustuu
 * Cooley-Tukeyn algoritmiin (jonain päivänä toivottavasti, 
 * nyt vielä keskeneräinen).
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

    public void muunna() {
        int k = 0;
        int N = data.length;
        
        while (k < N) {
            
            for (int i = 0; i < data.length; i++) {
                double nayte = data[i];
                this.reaali[k] += nayte * Math.cos(2 * Math.PI / N * i * k);
                this.imaginaari[k] -= nayte * Math.sin(2 * Math.PI / N * i * k);
            }
            
            k++;
        }
     
        System.out.println("Reaali: ");
        System.out.println(Arrays.toString(reaali));
        System.out.print("Imaginääri: ");
        System.out.println(Arrays.toString(imaginaari));
    }

}
