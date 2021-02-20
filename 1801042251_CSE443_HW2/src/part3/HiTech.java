package part3;

import java.util.ArrayList;

/**
 * Class to provided by the software library of the camera
 */
public class HiTech implements Subject {
    private final ArrayList<Observer> observers;
    private int timeout_X;

    /**
     * No parameter constructor creates new Arraylist for observers
     */
    public HiTech(){
        observers = new ArrayList<>();
    }

    /**
     * Registers an observer
     * Adds new observer to list
     * @param o new observer
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Removes an observer
     * Removes the observer from the list
     * @param o removed observer
     */
    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * It invoked when new update is available
     */
    @Override
    public void notifyObservers() {
        for (Object o : observers) {
            Observer observer = (Observer) o;
            observer.update(timeout_X);
        }
    }

    /**
     * whenever the camera detects a change of traffic, this method called
     * if flag is true, then timeout_X is increased from 60 to 90 seconds
     * @param flag indicates traffic situation
     */
    public void changeDetected(boolean flag){
        if(flag){
            System.out.println("It detected a lot of traffic. timeout_X is 90 now.");
            timeout_X = 90;
        }
        else {
            System.out.println("Traffic is normal. timeout_X is 60.");
            timeout_X = 60;
        }
        notifyObservers();
    }
}
