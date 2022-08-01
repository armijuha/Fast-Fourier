/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fft;
        

/**
 *Pääluokka joka tekee uuden käyttöliittymän ja kutsuu sitä
 * 
 * @author armijuha
 */
public class Main {
    public static void main(String[] args) {
        Kayttoliittyma kl = new Kayttoliittyma();
        kl.start();
    }
}
