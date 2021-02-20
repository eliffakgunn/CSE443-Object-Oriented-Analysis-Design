package part3;

/**
 * Interface for Observer
 */
public interface Observer {
    /**
     * updates timeout_X value
     * @param timeout_X chances according to traffic situation
     */
    void update(int timeout_X);
}
