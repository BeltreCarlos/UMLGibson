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
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;


public class Toolbox {

    // static variables
    public static String title = "Toolbox";
    public static double width = 100;
    public static double height = 230;
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

    private VBox createToolboxButtons(){
        VBox vBox = new VBox();
        vBox.setStyle(Main.style.bgColor);
        Images img = new Images();

        ToggleButton tb1 = new ToggleButton("Select");
        tb1.setUserData(State.SELECT);
        tb1.setToggleGroup(stateToggle);
        tb1.setSelected(true);
        tb1.setMinWidth(Toolbox.width);

        ToggleButton tb2 = new ToggleButton();
        tb2.setUserData(State.CLASSBOX);
        tb2.setToggleGroup(stateToggle);
        ImageView tb2Img = new ImageView(img.getClassbox());
        tb2Img.setFitHeight(40.0);
        tb2Img.setPreserveRatio(true);
        tb2.setGraphic(tb2Img);
        tb2.setTooltip(new Tooltip("ClassBox"));
        tb2.setMinWidth(Toolbox.width);

        vBox.getChildren().addAll(tb1, tb2);

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

