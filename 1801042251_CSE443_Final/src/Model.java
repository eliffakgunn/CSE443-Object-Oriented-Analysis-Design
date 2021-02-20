import java.util.ArrayList;
import java.util.Random;

/**
 * The model class of MVC pattern
 */
public class Model implements ModelInterface{
    private final ArrayList<View> observers;
    private final ArrayList<Individual> individuals;
    private final ArrayList<Thread> threads;

    private static int ID = 0;
    private static int healthy = 0;
    private static int infected = 0;

    Random rand = new Random();
    private final double R;
    private final double Z;

    public Model(){
        observers = new ArrayList<>();
        individuals = new ArrayList<>();
        threads = new ArrayList<>();
        R = 0.5 + (0.5*rand.nextDouble());
        Z = 0.1 + (0.8*rand.nextDouble());
    }

    /**
     * When the start button is clicked, controller called this function
     * It starts the individual threads
     * @param num number of individual
     */
    public void start(int num){
        int r = rand.nextInt(num);

        for(int i=0; i<num; ++i){
            Individual ind = new Individual(ID++,this);
            synchronized(individuals) {
                individuals.add(ind);
            }
            if(r == i){
                ind.setI(1);
                ++infected;
            }
            else{
                ind.setI(0);
                ++healthy;
            }

            Thread thread = new Thread(ind);
            threads.add(thread);
            thread.start();
        }
    }

    /**
     * When the pause button is clicked, controller called this function
     * It suspends the threads
     */
    public void pause(){
        for(Thread thread : threads)
            thread.suspend();
    }

    /**
     * When the continue button is clicked, controller called this function
     * It resumes the threads
     */
    public void continue_(){
        for(Thread thread : threads)
            thread.resume();
    }

    /**
     * When the add person button is clicked, controller called this function
     * It adds a person to the society
     */
    public void addPerson(){
        int r = rand.nextInt(1000);
        Individual ind = new Individual(ID++,this);
            synchronized(individuals) {
                individuals.add(ind);
            }
            if(r%2 == 0){
                ind.setI(1);
                ++infected;
            }
            else {
                ind.setI(0);
                ++healthy;
            }

            Thread thread = new Thread(ind);
            threads.add(thread);
            thread.start();
    }

    /**
     * Notifies observers to draw individual's pixels
     * Then it checks whether there is a collision
     * If there is a collision, it calculate collision time,
     * infecting probability.. according to individuals
     * @param ID id of the individual
     */
    @Override
    public synchronized void notifyObservers_draw(int ID){
        boolean flag = true;
        for (View view : observers) {
            ((Observer) view).update_draw(ID);
        }
        synchronized (individuals) {
            for (Individual i : individuals) {
                if (i.getID() != ID && isCollision(i, individuals.get(ID))) {
                    if (flag) {
                        flag = false;
                        double collTime = Math.max(i.getC(), individuals.get(ID).getC());
                        i.setCollTime(collTime);
                        individuals.get(ID).setCollTime(collTime);
                        if (i.getI() == 1) {
                            double prob = infectingProb(i, individuals.get(ID));
                            individuals.get(ID).setP(prob);
                            individuals.get(ID).setB(individuals.size() / 100);
                            individuals.get(ID).setI(1);
                            if(healthy != 0)
                                --healthy;
                            if(infected != threads.size())
                                ++infected;
                        } else if (individuals.get(ID).getI() == 1) {
                            double prob = infectingProb(individuals.get(ID), i);
                            i.setP(prob);
                            i.setB(individuals.size() / 100);
                            i.setI(1);
                            if(healthy != 0)
                                --healthy;
                            if(infected != threads.size())
                                ++infected;
                        }
                    }
                }
            }
        }
    }
    /**
     * Notifies observers to delete individual's pixels
     * @param ID id of the individual
     */
    @Override
    public synchronized void notifyObservers_clear(int ID) {
        for (View view : observers) {
            ((Observer) view).update_clear(ID);
        }
    }
    /**
     * Notifies observers to update counter
     */
    @Override
    public synchronized void notifyObservers_counter(){
        for (View view : observers) {
            ((Observer) view).update_counter(healthy, infected);
        }
    }
    /**
     * Adds the observer to observer list
     * @param o observer
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add((View) o);
    }
    /**
     * Removes the observer to observer list
     * @param o observer
     */
    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * Getter function for individual list
     * @param index index of the individual
     * @return Returns the individual in the specified index
     */
    public Individual getIndividual(int index){
        return individuals.get(index);
    }

    /**
     * Checks whether there is a collision
     * @param i1 Individual 1
     * @param i2 Individual 2
     * @return Returns true if there is a collision, otherwise returns false
     */
    public boolean isCollision (Individual i1, Individual i2) {
        return i1.getXNew() < i2.getXNew() + 5 && i1.getXNew() + 5 > i2.getXNew() && i1.getYNew() < i2.getYNew() + 5 && i1.getYNew() + 5 > i2.getYNew();
    }

    /**
     * It calculates infecting probability between two individuals
     * @param I1 Individual 1
     * @param I2 Individual 2
     * @return Returns infecting probability
     */
    double infectingProb(Individual I1, Individual I2){
        double C = Math.max(I1.getC(), I2.getC());
        double D = Math.min(I1.getD(), I2.getD());

        return Math.min((R * (1 + C/10.0) * I1.getM() * I2.getM() * (1 - D/10.0)),1);
    }

}