/**
 * This class represents both MVC pattern and Mediator pattern
 */
public interface ModelInterface {
    /**
     * Adds the observer to observer list
     * @param o observer
     */
    void registerObserver(Observer o);
    /**
     * Removes the observer to observer list
     * @param o observer
     */
    void removeObserver(Observer o);
    /**
     * Notifies observers to draw individual's pixels
     * @param ID id of the individual
     */
    void notifyObservers_draw(int ID) throws InterruptedException;
    /**
     * Notifies observers to delete individual's pixels
     * @param ID id of the individual
     */
    void notifyObservers_clear(int ID);
    /**
     * Notifies observers to update counter
     */
    void notifyObservers_counter();
    /**
     * Getter function for individual list
     * @param index index of the individual
     * @return Returns the individual in the specified index
     */
    Individual getIndividual(int index);
        /**
     * When the start button is clicked, view called this method
     * It calls the Model class's start method
     * @param num number of individual
     */
    void start(int num);
    /**
     * When the pause button is clicked, view called this method
     * It calls the Model class's pause method
     */
    void pause();
    /**
     * When the continue button is clicked, view called this method
     * It calls the Model class's continue method
     */
    void continue_();
    /**
     * When the addPerson button is clicked, view called this method
     * It calls the Model class's addPerson method
     */
    void addPerson();
}


