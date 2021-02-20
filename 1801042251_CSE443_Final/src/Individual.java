import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;
import java.util.Random;

/**
 * Class for individuals
 */
public class Individual implements Runnable {
    private final double M; //mask
    private final double S; //speed
    private final double C; //spend time
    private final double D; //social distance
    private double P; //infecting prob
    private double B; //ventilators
    private int I; //0 or 1
    private final int ID; //individual ID
    private double xNew; //new x coordinate
    private double yNew; //new y coordinate
    private double xLast; //last x coordinate
    private double yLast; //last y coordinate
    private double collTime = 0; //collision time
    private double distance; //distance between two point

    private Model model;
    private Random rand = new Random();

    /**
     * Constructor to initialize some data fields
     * @param ID Individual's ID number
     * @param model Model class's object to call its methods
     */
    public Individual(int ID, Model model){
        this.ID = ID;
        xNew = 995*rand.nextDouble();
        yNew = 595*rand.nextDouble();
        if((int)xNew % 2 == 0){
            M = 0.2;
        }
        else {
            M = 1.0;
        }
        this.D = 9*rand.nextDouble();
        this.S = 1 + 4*rand.nextDouble();
        this.C = 1 + 4*rand.nextDouble();
        this.model = model;
    }

    /**
     * runner method for threads
     */
    public void run(){
        model.notifyObservers_draw(ID);

        try{
            Thread.sleep((long) (1000.0/S));
        }catch (InterruptedException e) {
            System.out.println(e);
        }

        while(true){
            xLast = xNew;
            yLast = yNew;

            Platform.runLater(() -> {
                xNew = 995*rand.nextDouble();
                yNew = 595*rand.nextDouble();

                distance = Math.sqrt(Math.pow((yNew - yLast), 2) + Math.pow((xNew - xLast), 2));

                model.notifyObservers_clear(ID);
                model.notifyObservers_draw(ID);

                Timeline time = new Timeline(
                    new KeyFrame(Duration.seconds(1),
                            event -> model.notifyObservers_counter()));
                time.setCycleCount(Timeline.INDEFINITE);
                time.play();
            });

            try{
                Thread.sleep((long) (1000/S+collTime));
                collTime = 0;
            }catch (InterruptedException e) {
                System.out.println(e);
            }


        }
    }

    /**
     * Getter method for xLast
     * @return Returns xLast
     */
    public double getXLast() {return xLast;}
    /**
     * Getter method for yLast
     * @return Returns yLast
     */
    public double getYLast() {return yLast;}
    /**
     * Getter method for xNew
     * @return Returns xNew
     */
    public double getXNew() {return xNew;}
    /**
     * Getter method for yNew
     * @return Returns yNew
     */
    public double getYNew() {return yNew;}
    /**
     * Getter method for C
     * @return Returns C
     */
    public double getC() {return C;}
    /**
     * Getter method for D
     * @return Returns D
     */
    public double getD() {return D;}
    /**
     * Getter method for M
     * @return Returns M
     */
    public double getM() {return M;}
    /**
     * Getter method for ID
     * @return Returns ID
     */
    public int getID() { return ID;}
    /**
     * Getter method for I
     * @return Returns I
     */
    public int getI() { return I;}
    /**
     * Setter method for collTime
    */
    public void setCollTime(double collTime){
        this.collTime = collTime;
    }
    /**
     * Setter method for P
    */    public void setP(double P){
        this.P = P;
    }
    /**
     * Setter method for I
    */    public void setI(int I){
        this.I = I;
    }
    /**
     * Setter method for B
    */    public void setB(double B){
        this.B = B;
    }
}
