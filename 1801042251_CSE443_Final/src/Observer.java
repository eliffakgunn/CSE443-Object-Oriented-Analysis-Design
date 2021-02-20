/**
 * Observer interface for observers
 */
public interface Observer {
    /**
     * Updates view according to specified ID number of individuals
     * Draws new pixels to canvas
     * @param id ID number of the individual
     */
    void update_draw(int id);
    /**
     * Updates view according to specified ID number of individuals
     * Deletes specified individual from canvas
     * @param id ID number of the individual
     */
    void update_clear(int id);

    /**
     * Updates the number of healthy and infected individual
     * @param healthy number of healthy individual
     * @param infected number of infected individual
     */
    void update_counter(int healthy, int infected);
}
