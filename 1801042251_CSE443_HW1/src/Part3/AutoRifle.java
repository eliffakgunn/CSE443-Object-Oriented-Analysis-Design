package Part3;

/**
 * AutoRifle extends Accessory because it is a decorator
 */
public class AutoRifle extends Accessory{
    //an instance variable to hold the suit we are wrapping
    Suit suit;

    /**
     * In constructor, we are going to pass the suit
     * we're wrapping to the decorator's constructor
     * @param suit is a suit that wrapping
     */
    public AutoRifle(Suit suit){
        this.suit = suit;
    }

    /**
     * First, it delegates to the object that decorating to get its description
     * then append AutoRifle to that description
     * @return description that includes suit and all decorators
     */
    public String getDescription(){
        return suit.getDescription() + ", AutoRifle";
    }

    /**
     * Returns cost of suit object with AutoRifle
     * @return Returns cost of suit object with AutoRifle
     */
    public int cost(){
        return 30 + suit.cost();
    }

    /**
     * Returns weight of suit object with AutoRifle
     * @return Returns weight of suit object with AutoRifle
     */
    public double weight(){
        return 1.5 + suit.weight();
    }
}
