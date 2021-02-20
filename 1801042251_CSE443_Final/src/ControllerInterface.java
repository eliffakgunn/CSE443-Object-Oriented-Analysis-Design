public interface ControllerInterface {
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
