package part3;

/**
 * Class for Select table operation
 */
public class Select extends Operation {
    /**
     * This method does Select table operation
     */
    public void doOperation() {
        System.out.println("Select operation is done in table " + name);
    }

    /**
     * This method discard Select table operation
     */
    public void backOperation(){
        System.out.println("Select operation is taken back in table " + name);
    }
}
