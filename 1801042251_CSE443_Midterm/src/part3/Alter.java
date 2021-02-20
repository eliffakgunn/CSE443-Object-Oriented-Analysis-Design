package part3;

/**
 * Class for Alter table operation
 */
public class Alter extends Operation {
    /**
     * This method does Alter table operation
     */
    public void doOperation() {
        System.out.println("Alter operation is done in table " + name);
    }

    /**
     * This method discard Alter table operation
     */
    public void backOperation(){
        System.out.println("Alter operation is taken back in table " + name);
    }
}
