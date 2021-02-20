package part3;

/**
 * Class for update command
 */
public class UpdateCommand implements Command {
    /**
     * To delegate operation to Update class
     */
    Update update;

    /**
     * Initializes Update class object
     * @param update Update class object
     */
    public UpdateCommand(Update update){
        this.update = update;
    }

    /**
     * Execute operation with proper doOperation
     */
    @Override
    public void execute() {
        update.doOperation();
    }

    /**
     * Undo operation with proper backOperation
     */
    @Override
    public void undo() {
        update.backOperation();
    }
}
