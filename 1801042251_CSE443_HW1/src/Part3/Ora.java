package Part3;

/**
 * Ora extends Suit because it is a suit.
 */
public class Ora extends Suit{

    /**
     * Initializes description as Ora
     */
    public Ora(){
        description = "Ora";
    }

    /**
     * Returns cost of ora
     * @return Returns cost of ora
     */
    public int cost(){
        return 1500;
    }

    /**
     * Returns weight of ora
     * @return Returns weight of ora
     */
    public  double weight(){
        return 30;
    }
}
