package Part3;

/**
 * We need to be interchangeable with a Suit
 * so we extend the Suit class
 */
public abstract class Accessory extends Suit{
    /**
     * It is required that the accessories all reimplement the getDescription()
     * @return description of suit
     */
    public abstract String getDescription();
}
