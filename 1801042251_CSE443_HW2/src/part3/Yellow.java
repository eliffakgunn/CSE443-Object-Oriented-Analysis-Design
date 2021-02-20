package part3;

/**
 * Class for YELLOW state
 */
public class Yellow extends State {
    TrafficLight trafficLight;

    /**
     * Constructor to initialize TrafficLight object
     * @param trafficLight is a TrafficLight object to set state
     */
    public Yellow(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    /**
     * Switches state from YELLOW to RED
     */
    @Override
    public void switchRed() {
        System.out.println("Current state: YELLOW");
        System.out.println("Waiting 3 seconds...");
        System.out.println("Switching to Red\n");

        trafficLight.setState(trafficLight.getRed());
    }
}
