package TestFft;

import fft.LukuJaTulostus;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author armijuha
 */
public class LukuJaTulostusTest {

    private LukuJaTulostus ljt;
    private int luettavatRivit;
    //private BufferedReader sisaan = null;

    public LukuJaTulostusTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        //sisaan = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/testidata")));
        luettavatRivit = 4;
        ljt = new LukuJaTulostus("/home/armijuha/Tiralabra/testi1024", luettavatRivit);
        //URL url = this.getClass().getResource("/testidata");
        //File testidata = new File(url.getFile());
        //ljt = new LukuJaTulostus(testidata, luettavatRivit);
    }

    @After
    public void tearDown() throws IOException {

    }

    @Test
    public void lukutesti() throws IOException {
        ljt.lueTiedosto();
        String vastaus = ljt.toString();
        assertEquals("4 riviä luettu, 1. aika: 0,0 ja 1. näyte: -4009.75", vastaus);
    }

}
