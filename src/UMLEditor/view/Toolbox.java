package UMLEditor.view;

import UMLEditor.Main;
import javafx.scene.control.Tooltip;
import UMLEditor.view.Images;
import UMLEditor.model.State;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;
//import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;


public class Toolbox {

    // static variables
    public static String title = "Toolbox";
    public static double width = 150;
    public static double btnWidth = Toolbox.width + 20;
    public static double height = 352;
    public static double widthPadding = 10;

    private final Main main;
    private double yPos;
    private double xPos;

    public Stage stage;
    public Scene scene;
    public VBox layout;
    private ToggleGroup stateToggle = new ToggleGroup();

    public Toolbox(Main main) {
        this.main = main;
        this.stage = new Stage();
        layout = createToolboxButtons();

        // set & show
        this.scene = new Scene(this.layout, Toolbox.width, Toolbox.height);
        this.stage.setScene(this.scene);
        this.stage.setResizable(false);
        this.setPosition();
        this.stage.show();
        
    }
    public void initEvents(){
        // set menu toggle on close
        Menu menu = this.main.menu;
        stage.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.runLater(() -> {
                    menu.toggleToolbox.setSelected(false);
                });
            }
        });
    }

    private VBox createToolboxButtons(){
        VBox vBox = new VBox();
        vBox.setStyle(Main.style.bgColor);
        Images img = new Images();

        ToggleButton tb1 = new ToggleButton("Select");
        tb1.setUserData(State.SELECT);
        tb1.setToggleGroup(stateToggle);
        tb1.setSelected(true);
        tb1.setMinWidth(Toolbox.btnWidth);

        // classbox
        ToggleButton tb2 = new ToggleButton();
        tb2.setUserData(State.CLASSBOX);
        tb2.setToggleGroup(stateToggle);
        ImageView tb2Img = new ImageView(img.getClassbox());
        tb2Img.setFitHeight(40.0);
        tb2Img.setPreserveRatio(true);
        tb2.setGraphic(tb2Img);
        tb2.setTooltip(new Tooltip("ClassBox"));
        tb2.setMinWidth(Toolbox.btnWidth);
        
        // assocation
        ToggleButton tb3 = new ToggleButton();
        tb3.setUserData(State.ASSOCIATION);
        tb3.setToggleGroup(stateToggle);
        ImageView tb3Img = new ImageView(img.getAssociation());
        tb3Img.setFitHeight(40.0);
        tb3Img.setPreserveRatio(true);
        tb3.setGraphic(tb3Img);
        tb3.setTooltip(new Tooltip("Association"));
        tb3.setMinWidth(Toolbox.btnWidth);
        
        // dependency
        ToggleButton tb4 = new ToggleButton();
        tb4.setUserData(State.DEPENDENCY);
        tb4.setToggleGroup(stateToggle);
        ImageView tb4Img = new ImageView(img.getDependency());
        tb4Img.setFitHeight(40.0);
        tb4Img.setPreserveRatio(true);
        tb4.setGraphic(tb4Img);
        tb4.setTooltip(new Tooltip("Dependency"));
        tb4.setMinWidth(Toolbox.btnWidth);
        
        // aggregation
        ToggleButton tb5 = new ToggleButton();
        tb5.setUserData(State.AGGREGATION);
        tb5.setToggleGroup(stateToggle);
        ImageView tb5Img = new ImageView(img.getAggregation());
        tb5Img.setFitHeight(40.0);
        tb5Img.setPreserveRatio(true);
        tb5.setGraphic(tb5Img);
        tb5.setTooltip(new Tooltip("Aggregation"));
        tb5.setMinWidth(Toolbox.btnWidth);
        
        // composition
        ToggleButton tb6 = new ToggleButton();
        tb6.setUserData(State.COMPOSITION);
        tb6.setToggleGroup(stateToggle);
        ImageView tb6Img = new ImageView(img.getComposition());
        tb6Img.setFitHeight(40.0);
        tb6Img.setPreserveRatio(true);
        tb6.setGraphic(tb6Img);
        tb6.setTooltip(new Tooltip("Composition"));
        tb6.setMinWidth(Toolbox.btnWidth);
        
        // generalization
        ToggleButton tb7 = new ToggleButton();
        tb7.setUserData(State.GENERALIZATION);
        tb7.setToggleGroup(stateToggle);
        ImageView tb7Img = new ImageView(img.getGeneralization());
        tb7Img.setFitHeight(40.0);
        tb7Img.setPreserveRatio(true);
        tb7.setGraphic(tb7Img);
        tb7.setTooltip(new Tooltip("Generalization"));
        tb7.setMinWidth(Toolbox.btnWidth);
        
        // implementation
        ToggleButton tb8 = new ToggleButton();
        tb8.setUserData(State.IMPLEMENTATION);
        tb8.setToggleGroup(stateToggle);
        ImageView tb8Img = new ImageView(img.getImplementation());
        tb8Img.setFitHeight(40.0);
        tb8Img.setPreserveRatio(true);
        tb8.setGraphic(tb8Img);
        tb8.setTooltip(new Tooltip("Implementation"));
        tb8.setMinWidth(Toolbox.btnWidth);

        vBox.getChildren().addAll(tb1, tb2, tb3, tb4, tb5, tb6, tb7, tb8);

        return vBox;
    }

    private void setPosition() {
        this.xPos = main.stage.getX() - Toolbox.width - Toolbox.widthPadding;
        this.yPos = main.stage.getY();
        this.stage.setX(this.xPos);
        this.stage.setY(this.yPos);
    }

    public ToggleGroup getStateToggle() {
        return stateToggle;
    }



}

