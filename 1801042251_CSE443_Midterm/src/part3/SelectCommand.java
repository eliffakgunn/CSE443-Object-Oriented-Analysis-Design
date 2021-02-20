package part3;

/**
 * Class for select command
 */
public class SelectCommand implements Command {
    /**
     * To delegate operation to Select class
     */
    Select select;

    /**
     * Initializes Select class object
     * @param select Select class object
     */
    public SelectCommand(Select select){
        this.select = select;
    }

    /**
     * Execute operation with proper doOperation
     */
    @Override
    public void execute() {
        select.doOperation();
    }

    /**
     * Undo operation with proper backOperation
     */
    @Override
    public void undo() {
        select.backOperation();
    }
}
