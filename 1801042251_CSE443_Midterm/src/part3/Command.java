package part3;

/**
 * Interface for execute and undo methods
 */
public interface Command {
    /**
     * Execute operation with proper doOperation
     */
    void execute();

    /**
     * Undo operation with proper backOperation
     */
    void undo();
}
