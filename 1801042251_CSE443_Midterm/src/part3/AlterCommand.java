package part3;

/**
 * Class for alter command
 */
public class AlterCommand implements Command{
    /**
     * To delegate operation to Alter class
     */
    Alter alter;

    /**
     * Initializes Alter class object
     * @param alter Alter class object
     */
    public AlterCommand(Alter alter){
        this.alter = alter;
    }

    /**
     * Execute operation with proper doOperation
     */
    @Override
    public void execute() {
        alter.doOperation();
    }

    /**
     * Undo operation with proper backOperation
     */
    @Override
    public void undo() {
        alter.backOperation();
    }
}
