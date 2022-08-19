package TestFft;

import fft.LukuJaTulostus;
import fft.OmaFFT;
import java.io.IOException;
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
public class OmaFFTTest {

    private LukuJaTulostus ljt;
    private int luettavatRivit;
    private OmaFFT offt;

    public OmaFFTTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        luettavatRivit = 1024;
        ljt = new LukuJaTulostus("/home/armijuha/Tiralabra/testi1024", luettavatRivit);
        double naytteet[] = ljt.lueTiedosto();
        offt = new OmaFFT(naytteet, luettavatRivit);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void käännöstesti() throws IOException {
        double[] muunnos = offt.muunnaDDF();
        offt.laskeSaro(muunnos, 200);
        
        String vastaus = offt.toString();
        assertEquals("1024 näytettä käännetty, kokonaissärö: 0.0264", vastaus);
    }
}
