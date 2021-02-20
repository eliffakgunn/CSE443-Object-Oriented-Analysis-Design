package part4;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
            System.out.println("\n--------Discrete Fourier Transform--------");
            Transform dft = new DiscreteFourierTransform();
            dft.procedure(args[0], "output_dft.txt");

            System.out.println("\n--------Discrete Cosine Transform--------");
            Transform dct = new DiscreteCosineTransform();
            dct.procedure(args[0], "output_dct.txt");
    }
}