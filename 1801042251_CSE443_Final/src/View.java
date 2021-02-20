import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * The view class of MVC pattern
 */
public class View implements Observer {
    private final ControllerInterface controller;
    private final ModelInterface model;
    private GraphicsContext gc;
    private final Label label1;
    private final Label label2;

    /**
     * Constructor to initialize some data fields
     * @param controller Controller object
     * @param model Model object
     */
    public View(ControllerInterface controller, ModelInterface model){
        this.controller = controller;
        this.model = model;
        label1 = new Label("Number of Healthy Individual: 0");
        label2 = new Label("Number of Infected Individual: 0");
        model.registerObserver(this);
    }

    /**
     * Creates pane, buttons, textfiled etc.
     * @param stage Stage object
     */
    public void createView(Stage stage){
        GridPane root = new GridPane();
        Canvas canvas = new Canvas(1000,600);
        gc = canvas.getGraphicsContext2D();

        TextField textField = new TextField();
        Label label = new Label("Please enter the individual number.");

        Button startButton = createStartButton(textField);
        Button pauseButton = createPauseButton();
        Button contButton = createContButton();
        Button addButton = createAddButton();

        GridPane gridPane = new GridPane();
        GridPane gridPane2 = new GridPane();
        GridPane gridPane3 = new GridPane();

        gridPane3.add(label1, 0,0);
        gridPane3.add(label2, 0,1);
        gridPane3.setAlignment(Pos.TOP_CENTER);

        gridPane2.add(pauseButton, 0, 0);
        gridPane2.add(contButton, 1, 0);
        gridPane2.add(addButton, 2, 0);
        gridPane2.setHgap(10);
        gridPane2.setVgap(10);

        gridPane.add(gridPane3,0,0);
        gridPane.add(label,0,1);
        gridPane.add(textField,0,2);
        gridPane.add(startButton, 1, 2);
        gridPane.add(gridPane2,0,3);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.setAlignment(Pos.CENTER);

        root.add(canvas,0,0);
        root.add(gridPane,1,0);

        stage.setScene(new Scene(root));
        stage.setTitle("Simulation of an Epidemic Within a Human Society");

        stage.setMaxHeight(600);
        stage.setMinHeight(600);
        stage.setMaxWidth(1350);
        stage.setMinWidth(1350);
        root.setMaxHeight(600);
        root.setMinHeight(600);
        root.setMaxWidth(1350);
        root.setMinWidth(1350);

        stage.show();
    }

    /**
     * Creates start button
     * @param textField TextField object to read individual number
     * @return Returns start button
     */
    private Button createStartButton(TextField textField){
        Button button = new Button("Start");
        AtomicInteger num = new AtomicInteger();
        button.setOnAction(e -> {
            if(textField.getText().length() != 0) {
                try {
                    num.set(Integer.parseInt(textField.getText()));
                }catch (Exception exception){
                    System.out.println(exception);
                }
                controller.start(num.get());
            }
        });

        return button;
    }

    /**
     * Creates pause button
     * @return Returns pause button
     */
    private Button createPauseButton(){
        Button button = new Button("Pause");
        button.setOnAction(e -> controller.pause());
        return button;
    }

    /**
     * Creates continue button
     * @return Returns conrinue button
     */
    private Button createContButton(){
        Button button = new Button("Continue");
        button.setOnAction(e -> controller.continue_());
        return button;
    }

    /**
     * Creates add button
     * @return Returns add button
     */
    private Button createAddButton(){
        Button button = new Button("Add Person");
        button.setOnAction(e -> controller.addPerson());
        return button;
    }
    /**
     * Updates view according to specified ID number of individuals
     * Draws new pixels to canvas
     * @param ID ID number of the individual
     */
    @Override
    public void update_draw(int ID) {
        System.out.println("(" + model.getIndividual(ID).getXNew() + "," + model.getIndividual(ID).getYNew() + ") drawn.");
        gc.setFill(Color.rgb(255, 0, 0));
        gc.fillRect(model.getIndividual(ID).getXNew(), model.getIndividual(ID).getYNew(), 5, 5);
    }
    /**
     * Updates view according to specified ID number of individuals
     * Deletes specified individual from canvas
     * @param ID ID number of the individual
     */
    @Override
    public void update_clear(int ID) {
        System.out.println("("+model.getIndividual(ID).getXLast()+","+model.getIndividual(ID).getYLast()+") deleted.");
        gc.clearRect(model.getIndividual(ID).getXLast(),model.getIndividual(ID).getYLast(),5,5);
    }
    /**
     * Updates the number of healthy and infected individual
     * @param healthy number of healthy individual
     * @param infected number of infected individual
     */
    @Override
    public void update_counter(int healthy, int infected){
        label1.setText("Number of Healthy Individual: " + healthy);
        label2.setText("Number of Infected Individual: " + infected);
    }
}
