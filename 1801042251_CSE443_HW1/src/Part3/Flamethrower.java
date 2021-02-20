package Part3;

/**
 * Flamethrower extends Accessory because it is a decorator
 */
public class Flamethrower extends Accessory{
    //an instance variable to hold the suit we are wrapping
    Suit suit;

    /**
     * In constructor, we are going to pass the suit
     * we're wrapping to the decorator's constructor
     * @param suit is a suit that wrapping
     */
    public Flamethrower(Suit suit){
        this.suit = suit;
    }

    /**
     * First, it delegates to the object that decorating to get its description
     * then append Flamethrower to that description
     * @return description that includes suit and all decorators
     */
    public String getDescription(){
        return suit.getDescription() + ", Flamethrower";
    }

    /**
     * Returns cost of suit object with Flamethrower
     * @return Returns cost of suit object with Flamethrower
     */
    public int cost(){
        return 50 + suit.cost();
    }

    /**
     * Returns weight of suit object with Flamethrower
     * @return Returns weight of suit object with Flamethrower
     */
    public double weight(){
        return 2 + suit.weight();
    }
}
