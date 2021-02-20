package part4;

public class DiscreteCosineTransform extends Transform {
    /**
     * Transforms numbers with Discrete Cosine Transform
     */
    @Override
    void transform() {
        double real, angle;
        int N = numbers.size();

        imagPart = null;

        for(int k=0; k<N; ++k){
            real = 0.0;

            for(int n=0; n<N; ++n){
                angle = Math.PI/N*(n+ 0.5)*k;
                real += numbers.get(n)*Math.cos(angle);
            }
            realPart.add(real);
        }
    }

    /**
     * only in the case of DFT, sometimes the user wants additionally the time of execution printed on screen;
     * so this method does nothing
     */
    @Override
    void printTime() {}
}
