package UMLEditor.view;

import UMLEditor.Main;
import javafx.scene.control.Tooltip;
import UMLEditor.view.Images;
import UMLEditor.model.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;


public class Toolbox {

    // static variables
    public static String title = "Toolbox";
    public static double width = 100;
    public static double height = 350;
    public static double widthPadding = 10;
    private double yPos;
    private double xPos;
    //Objects
    private Main main;
    public Stage stage;
    public Scene scene;
    public VBox layout;
    private ToggleGroup stateToggle;

    public Toolbox(Main main) {
        stateToggle = new ToggleGroup();
        this.main = main;
        this.stage = new Stage();
        layout = createToolboxButtons();

        // set & show
        this.scene = new Scene(this.layout, this.width, this.height);
        this.stage.setScene(this.scene);
        this.stage.setResizable(false);
        this.stage.show();

        setPosition();

    }

    //sets up all the buttons on the toolbox
    private VBox createToolboxButtons(){
        VBox vBox = new VBox();
        vBox.setStyle(Main.style.bgColor);
        Images img = new Images();

        ToggleButton tb1 = new ToggleButton("Select");
        tb1.setUserData(State.SELECT);
        tb1.setToggleGroup(stateToggle);
        tb1.setSelected(true);
        tb1.setMaxWidth(Double.MAX_VALUE);
        tb1.setMaxHeight(Double.MAX_VALUE);
        vBox.setVgrow(tb1, Priority.ALWAYS);

        ToggleButton tb2 = new ToggleButton();
        tb2.setUserData(State.CLASSBOX);
        tb2.setToggleGroup(stateToggle);
        ImageView tb2Img = new ImageView(img.getClassbox());
        tb2Img.setFitHeight(30.0);
        tb2Img.setPreserveRatio(true);
        tb2.setGraphic(tb2Img);
        tb2.setTooltip(new Tooltip("ClassBox"));
        tb2.setMaxWidth(Double.MAX_VALUE);
        tb2.setMaxHeight(Double.MAX_VALUE);
        vBox.setVgrow(tb2, Priority.ALWAYS);

        ToggleButton tb3 = new ToggleButton();
        tb3.setUserData(State.ASSOCIATION);
        tb3.setToggleGroup(stateToggle);
        ImageView tb3Img = new ImageView(img.getAssociation());
        tb3Img.setFitHeight(30.0);
        tb3Img.setPreserveRatio(true);
        tb3.setGraphic(tb3Img);
        tb3.setTooltip(new Tooltip("Association"));
        tb3.setMaxWidth(Double.MAX_VALUE);
        tb3.setMaxHeight(Double.MAX_VALUE);
        vBox.setVgrow(tb3, Priority.ALWAYS);

        ToggleButton tb4 = new ToggleButton();
        tb4.setUserData(State.AGGREGATION);
        tb4.setToggleGroup(stateToggle);
        ImageView tb4Img = new ImageView(img.getAggregation());
        tb4Img.setFitHeight(30.0);
        tb4Img.setPreserveRatio(true);
        tb4.setGraphic(tb4Img);
        tb4.setTooltip(new Tooltip("Aggregation"));
        tb4.setMaxWidth(Double.MAX_VALUE);
        tb4.setMaxHeight(Double.MAX_VALUE);
        vBox.setVgrow(tb4, Priority.ALWAYS);

        ToggleButton tb5 = new ToggleButton();
        tb5.setUserData(State.COMPOSITION);
        tb5.setToggleGroup(stateToggle);
        ImageView tb5Img = new ImageView(img.getComposition());
        tb5Img.setFitHeight(30.0);
        tb5Img.setPreserveRatio(true);
        tb5.setGraphic(tb5Img);
        tb5.setTooltip(new Tooltip("Composition"));
        tb5.setMaxWidth(Double.MAX_VALUE);
        tb5.setMaxHeight(Double.MAX_VALUE);
        vBox.setVgrow(tb5, Priority.ALWAYS);

        ToggleButton tb6 = new ToggleButton();
        tb6.setUserData(State.DEPENDENCY);
        tb6.setToggleGroup(stateToggle);
        ImageView tb6Img = new ImageView(img.getDependency());
        tb6Img.setFitHeight(30.0);
        tb6Img.setPreserveRatio(true);
        tb6.setGraphic(tb6Img);
        tb6.setTooltip(new Tooltip("Dependency"));
        tb6.setMaxWidth(Double.MAX_VALUE);
        tb6.setMaxHeight(Double.MAX_VALUE);
        vBox.setVgrow(tb6, Priority.ALWAYS);

        ToggleButton tb7 = new ToggleButton();
        tb7.setUserData(State.GENERALIZATION);
        tb7.setToggleGroup(stateToggle);
        ImageView tb7Img = new ImageView(img.getGeneralization());
        tb7Img.setFitHeight(30.0);
        tb7Img.setPreserveRatio(true);
        tb7.setGraphic(tb7Img);
        tb7.setTooltip(new Tooltip("Generalization"));
        tb7.setMaxWidth(Double.MAX_VALUE);
        tb7.setMaxHeight(Double.MAX_VALUE);
        vBox.setVgrow(tb7, Priority.ALWAYS);

        ToggleButton tb8 = new ToggleButton();
        tb8.setUserData(State.IMPLEMENTS);
        tb8.setToggleGroup(stateToggle);
        ImageView tb8Img = new ImageView(img.getImplementation());
        tb8Img.setFitHeight(30.0);
        tb8Img.setPreserveRatio(true);
        tb8.setGraphic(tb8Img);
        tb8.setTooltip(new Tooltip("Implements"));
        tb8.setMaxWidth(Double.MAX_VALUE);
        tb8.setMaxHeight(Double.MAX_VALUE);
        vBox.setVgrow(tb8, Priority.ALWAYS);

        vBox.getChildren().addAll(tb1, tb2, tb3, tb4, tb5, tb6, tb7, tb8);

        return vBox;
    }

    public void setPosition() {

        this.xPos = 10.0;
        //System.out.println(x);
        this.yPos = 10.0;
        //System.out.println(this.yPos);
        this.stage.setX(this.xPos);
        this.stage.setY(this.yPos);
    }

    public ToggleGroup getStateToggle() {
        return stateToggle;
    }



}

