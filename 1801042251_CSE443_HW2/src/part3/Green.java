package part3;

/**
 * Class for GREEN state
 */
public class Green extends State {
    int timeout_X;
    TrafficLight trafficLight;

    /**
     * Constructor to initialize TrafficLight object
     * @param trafficLight is a TrafficLight object to set state
     */
    public Green(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    /**
     * Switches state from GREEN to YELLOW
     */
    @Override
    public void switchYellow() {
        System.out.println("Current state: GREEN");
        System.out.println("Waiting " + timeout_X + " seconds...");
        System.out.println("Switching to Yellow\n");

        trafficLight.setState(trafficLight.getYellow());
    }

    /**
     * Sets the timeout_X according to value coming from HiTech
     * @param timeout_X comes from HiTech
     */
    public void setTimeout_X(int timeout_X) {
        this.timeout_X = timeout_X;
    }
}
