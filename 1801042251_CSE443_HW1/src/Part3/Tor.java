package Part3;

/**
 * Tor extends Suit because it is a suit.
 */
public class Tor extends Suit{

    /**
     * Initializes description as Tor
     */
    public Tor(){
        description = "Tor";
    }

    /**
     * Returns cost of tor
     * @return Returns cost of tor
     */
    public int cost(){
        return 5000;
    }

    /**
     * Returns weight of tor
     * @return Returns weight of tor
     */
    public  double weight(){
        return 50;
    }
}
