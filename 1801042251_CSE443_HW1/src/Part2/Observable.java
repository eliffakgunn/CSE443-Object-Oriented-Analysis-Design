package Part2;

public interface Observable {
    void notifyObservers();
    void addObserver(Observer o);
    void removeObserver(Observer o);
}
