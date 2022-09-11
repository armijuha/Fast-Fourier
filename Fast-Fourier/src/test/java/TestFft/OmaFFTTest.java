package TestFft;

import fft.LukuJaTulostus;
import fft.OmaFFT;
import fft.ValmisFFT;
import java.io.IOException;
import java.util.Arrays;
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
    private ValmisFFT vfft;

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
        vfft = new ValmisFFT(naytteet, luettavatRivit);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kaannostesti() throws IOException {
        double[] muunnos = offt.muunnaDFT();
        offt.laskeSaro(muunnos, 200);

        String vastaus = offt.toString();
        assertEquals("1024 näytettä käännetty, kokonaissärö: 0.0264", vastaus);
    }

    @Test
    public void vertailutesti() throws IOException {
        double[] omamuunnos = offt.muunna();
        double omasaro = offt.laskeSaro(omamuunnos, 500);
        double[] valmismuunnos = vfft.muunna();
        double valmissaro = vfft.laskeSaro(valmismuunnos, 500);

        assertEquals(omasaro, valmissaro, 0.001);
    }
}
