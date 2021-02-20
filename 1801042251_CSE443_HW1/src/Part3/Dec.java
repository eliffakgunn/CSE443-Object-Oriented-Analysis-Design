package Part3;

/**
 * Dec extends Suit because it is a suit.
 */
public class Dec extends Suit{
    /**
     * Initializes description as Dec
     */
    public Dec(){
        description = "Dec";
    }

    /**
     * Returns cost of dec
     * @return Returns cost of dec
     */
    public int cost(){
        return 500;
    }

    /**
     * Returns weight of dec
     * @return Returns weight of dec
     */
    public  double weight(){
        return 25;
    }
}
