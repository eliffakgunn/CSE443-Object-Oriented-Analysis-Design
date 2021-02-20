package part3;

/**
 * Class for Update table operation
 */
public class Update extends Operation {
    /**
     * This method does Update table operation
     */
    public void doOperation() {
        System.out.println("Update operation is done in table " + name);
    }

    /**
     * This method discard Update table operation
     */
    public void backOperation(){
        System.out.println("Update operation is taken back in table " + name);
    }
}
