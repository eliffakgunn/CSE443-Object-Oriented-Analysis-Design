package part3;

/**
 * Class for RED state
 */
public class Red extends State {
    TrafficLight trafficLight;

    /**
     * Constructor to initialize TrafficLight object
     * @param trafficLight is a TrafficLight object to set state
     */
    public Red(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    /**
     * Switches state from RED to GREEN
     */
    @Override
    public void switchGreen() {
        System.out.println("Current state: RED");
        System.out.println("Waiting 15 seconds...");
        System.out.println("Switching to Green\n");

        trafficLight.setState(trafficLight.getGreen());
    }
}
