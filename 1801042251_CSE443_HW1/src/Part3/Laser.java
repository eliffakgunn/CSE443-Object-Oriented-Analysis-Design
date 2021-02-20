package Part3;

/**
 * Laser extends Accessory because it is a decorator
 */
public class Laser extends Accessory{
    //an instance variable to hold the suit we are wrapping
    Suit suit;

    /**
     * In constructor, we are going to pass the suit
     * we're wrapping to the decorator's constructor
     * @param suit is a suit that wrapping
     */
    public Laser(Suit suit){
        this.suit = suit;
    }

    /**
     * First, it delegates to the object that decorating to get its description
     * then append Laser to that description
     * @return description that includes suit and all decorators
     */
    public String getDescription(){
        return suit.getDescription() + ", Laser";
    }

    /**
     * Returns cost of suit object with Laser
     * @return Returns cost of suit object with Laser
     */
    public int cost(){
        return 200 + suit.cost();
    }

    /**
     * Returns weight of suit object with Laser
     * @return Returns weight of suit object with Laser
     */
    public double weight(){
        return 5.5 + suit.weight();
    }
}
