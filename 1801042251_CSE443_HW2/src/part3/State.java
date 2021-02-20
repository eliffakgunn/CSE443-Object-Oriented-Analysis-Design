package part3;

/**
 * Class for states
 */
public abstract class State {
    /**
     * Switches state from RED to GREEN
     * prints error message defaultly.
     */
    void switchGreen(){
        System.out.println("It is not possible to switch RED.");
    }
    /**
     * Switches state from GREEN to YELLOW
     * prints error message defaultly.
     */
    void switchYellow(){
        System.out.println("It is not possible to switch GREEN.");
    }
    /**
     * Switches state YELLOW to RED
     * prints error message defaultly.
     */
    void switchRed(){
        System.out.println("It is not possible to switch YELLOW.");
    }
}
