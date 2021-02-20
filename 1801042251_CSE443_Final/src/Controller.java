import javafx.stage.Stage;

/**
 * The controller class of MVC pattern
 */
public class Controller implements ControllerInterface{
    private final ModelInterface model;
    private final View view;

    /**
     * Constructor to initialize some data fields
     * @param model ModelInterface object to call Model class's methods
     * @param stage Stage object
     */
    public Controller(ModelInterface model, Stage stage){
        this.model = (Model) model;
        view = new View(this, (Model) model);
        view.createView(stage);
    }

    /**
     * When the start button is clicked, view called this method
     * It calls the Model class's start method
     * @param num number of individual
     */
    @Override
    public void start(int num){
        model.start(num);
    }

    /**
     * When the pause button is clicked, view called this method
     * It calls the Model class's pause method
     */
    @Override
    public void pause(){
        model.pause();
    }

    /**
     * When the continue button is clicked, view called this method
     * It calls the Model class's continue method
     */
    @Override
    public void continue_(){
        model.continue_();
    }

    /**
     * When the addPerson button is clicked, view called this method
     * It calls the Model class's addPerson method
     */
    @Override
    public void addPerson(){model.addPerson();}

}