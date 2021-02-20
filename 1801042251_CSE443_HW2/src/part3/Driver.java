package part3;

import java.util.Random;

/**
 * Driver class for part3
 */
public class Driver {
    public static void main(String[] args) {
        HiTech hiTech = new HiTech();
        TrafficLight trafficLight = new TrafficLight(hiTech);
        Random random = new Random();
        int rand;

        for(int i=0; i<2; ++i){
            rand = random.nextInt(1000);

            // to simulate traffic situation
            hiTech.changeDetected((rand % 2) == 1);

            trafficLight.switchGreen();
            trafficLight.switchYellow();
            trafficLight.switchRed();
        }
    }
}
