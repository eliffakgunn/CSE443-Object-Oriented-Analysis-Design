package part3;

/**
 * Class for traffic lights
 */
public class TrafficLight implements Observer {
    State red;
    State green;
    State yellow;
    State state;

    Subject hiTech;

    /**
     * Constructor to initialize states
     * Initial state is RED
     * @param hiTech to subscribe HiTech
     */
    public TrafficLight(Subject hiTech){
        this.hiTech = hiTech;
        hiTech.registerObserver(this);

        red = new Red(this);
        green = new Green(this);
        yellow = new Yellow(this);

        state = red;
    }

    /**
     * Switches state from RED to GREEN
     */
    public void switchRed(){
        state.switchRed();
    }

    /**
     * Switches state from GREEN to YELLOW
     */
    public void switchGreen(){
        state.switchGreen();
    }

    /**
     * Switches state from YELLOW to RED
     */
    public void switchYellow(){
        state.switchYellow();
    }

    /**
     * Sets the state
     * @param state is State object
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Gets GREEN state
     * @return Returns GREEN state's object
     */
    public State getGreen() {
        return green;
    }

    /**
     * Gets RED state
     * @return Returns RED state's object
     */
    public State getRed() {
        return red;
    }

    /**
     * Gets YELLOW state
     * @return Returns YELLOW state's object
     */
    public State getYellow() {
        return yellow;
    }

    /**
     * updates timeout_X value
     * @param timeout_X chances according to traffic situation
     */
    @Override
    public void update(int timeout_X) {
        ((Green) green).setTimeout_X(timeout_X);
    }
}
