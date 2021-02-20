package part3;

/**
 * Class for table operations
 */
public abstract class Operation {
    /**
     * name of table
     */
    String name;

    /**
     * This method does proper operation
     */
    public abstract void doOperation();

    /**
     * This method discard proper operation
     */
    public abstract void backOperation();

    /**
     * Sets the name of table
     * @param name the name of table
     */
    public void setName(String name){
        this.name = name;
    }
}
