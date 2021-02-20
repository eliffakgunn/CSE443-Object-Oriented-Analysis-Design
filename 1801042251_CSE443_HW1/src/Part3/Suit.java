package Part3;

/**
 * Suit is an abstract class with two methods.
 */
public abstract class Suit {
    String description = "Unknown";

    /**
     * Returns description of suit
     * @return Returns description of suit
     */
    public String getDescription(){
        return description;
    }

    /**
     * Returns cost of suit
     * @return Returns cost of suit
     */
    public abstract int cost();

    /**
     * Returns weight of suit
     * @return Returns weight of suit
     */
    public abstract double weight();
}
