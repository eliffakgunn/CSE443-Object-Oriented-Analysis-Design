import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Driver class for simulation of an epidemic
 */
public class Main extends Application {

    @Override
    public void start(Stage stage){
        ModelInterface model = new Model();
        ControllerInterface controller = new Controller(model, stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}