package fft;

import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

/**
 * Luokka laskee FFT:n testidatasta hyödyntäen valmiita kirjastoja
 * 
 */
public class ValmisFFT {

    private final double[] data;
    private final int n;
    private double[] tulosdata;

    public ValmisFFT(double[] data, int n) {
        this.data = data;
        this.n = n;
        this.tulosdata = new double[n];

    }

    public void muunna() {
        FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
        Complex[] complex = transformer.transform(data, TransformType.FORWARD);

        double[] real = new double[complex.length];
        double[] imag = new double[complex.length];

        for (int i = 0; i < real.length; ++i) {
            real[i] = complex[i].getReal();
            imag[i] = complex[i].getImaginary();
        }
        System.out.print("Reaali: ");
        System.out.println(Arrays.toString(real));
        System.out.print("Imaginääri: ");
        System.out.println(Arrays.toString(imag));
    }

}
