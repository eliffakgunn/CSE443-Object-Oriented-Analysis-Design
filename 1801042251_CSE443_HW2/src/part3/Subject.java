package part3;

/**
 * Interface for subject
 */
public interface Subject {
    /**
     * Registers an observer
     * Adds new observer to list
     * @param o new observer
     */
    void registerObserver(Observer o);
    /**
     * Removes an observer
     * Removes the observer from the list
     * @param o removed observer
     */
    void removeObserver(Observer o);
    /**
     * It called when new update is available
     */
    void notifyObservers();
}
