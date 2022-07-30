
package fft;

import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 *Luokka tarjoaa metodit tiedostojen lukemiseen ja tulostamiseen
 * 
 * @author armijuha
 */
public class io {
    private String tiedostopolku;
    private int luettavatRivit;
    private ArrayList <String> ajat;
    private ArrayList <String> naytteet;
    
    public io (String tiedostopolku, int luettavatRivit){
        this.tiedostopolku = tiedostopolku;
        this.luettavatRivit = luettavatRivit;
        this.ajat = new ArrayList();
        this.naytteet = new ArrayList();
    }    
    
    /**
     * Metodi lukee tiedoston nopeasti rivi riviltä.
     * Aika ja testinäytteet erotellaan omiin listoihinsa
     * ja ylimääräiset välilyönnit poistetaan.
     */
    public void lueTiedosto() {  
        try {
            File f = new File(tiedostopolku);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String rivi = br.readLine(); //lukee dataa edeltävän otsikkorivin pois
            int luetutRivit = 0;
            
            while((luetutRivit < luettavatRivit)) {
            rivi = br.readLine();
            luetutRivit++;
          
            
            String palat[] = rivi.split("       ");
            String aika = palat[1].trim(); 
            ajat.add(aika);
            String nayte = palat[2].trim();
            naytteet.add(nayte);
          
            }
            System.out.println("Valmis");
            
            
            
        } catch (Exception e) {
        System.out.println("Jokin tiedoston lukemisessa meni pieleen.");
    }
    }
    
    
    
}
