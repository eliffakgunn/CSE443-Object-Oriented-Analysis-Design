package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiscreteFourierTransform extends Transform {
    /**
     * Start time of process
     */
    private long startTime;

    public DiscreteFourierTransform(){
        startTime = System.currentTimeMillis();
    }

    /**
     * Transforms numbers with Discrete Fourier Transform
     */
    @Override
    void transform() {
        double real, imag, angle;
        int N = numbers.size();

        for(int k=0; k<N; ++k){
            real = imag = 0.0;

            for(int n=0; n<N; ++n){
                angle = 2*Math.PI/N*k*n;
                real += numbers.get(n)*Math.cos(angle);
                imag -= numbers.get(n)*Math.sin(angle);
            }

            realPart.add(real);
            imagPart.add(imag);
        }
    }

    /**
     * if user wants to print execution time on screen, this method runs and writes the time
     */
    @Override
    void printTime() {
        long finishTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (Double.parseDouble(String.valueOf(finishTime - startTime))/1000) + "sec");
    }

    /**
     * if user wants to print execution time on screen, returns true
     * @return Returns true if user wants to print execution time on screen
     */
    boolean printScreen(){
        String answer = getUserInput();
        return answer.toLowerCase().startsWith("y");
    }

    /**
     * Gets user input from console as y or no.
     * @return Returns the answer
     */
    private String getUserInput() {
        String answer = null;
        System.out.print("Do you want print the time of execution on screen (y/n)? ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error trying to read your answer");
        }
        if (answer == null) {
            return "no";
        }

        return answer;
    }
}
