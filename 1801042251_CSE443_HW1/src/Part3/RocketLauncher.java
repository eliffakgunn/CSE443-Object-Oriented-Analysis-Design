package Part3;

/**
 * RocketLauncher extends Accessory because it is a decorator
 */
public class RocketLauncher extends Accessory{
    //an instance variable to hold the suit we are wrapping
    Suit suit;

    /**
     * In constructor, we are going to pass the suit
     * we're wrapping to the decorator's constructor
     * @param suit is a suit that wrapping
     */
    public RocketLauncher(Suit suit){
        this.suit = suit;
    }

    /**
     * First, it delegates to the object that decorating to get its description
     * then append RocketLauncher to that description
     * @return description that includes suit and all decorators
     */
    public String getDescription(){
        return suit.getDescription() + ", RocketLauncher";
    }

    /**
     * Returns cost of suit object with RocketLauncher
     * @return Returns cost of suit object with RocketLauncher
     */
    public int cost(){
        return 150 + suit.cost();
    }

    /**
     * Returns weight of suit object with RocketLauncher
     * @return Returns weight of suit object with RocketLauncher
     */
    public double weight(){
        return 7.5 + suit.weight();
    }
}
