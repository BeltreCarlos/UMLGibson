package UMLEditor.view;

import UMLEditor.Main;
import UMLEditor.view.Images;
import UMLEditor.model.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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

    // parent instance
    private final Main main;

    // position
    private double yPos;
    private double xPos;

    // layout
    public Stage stage;
    public Scene scene;
    public VBox layout;
    public int spacing = 0;

    // buttons
    private Toolbox_Button classBtn = new Toolbox_Button();
//    private Toolbox_Button genBtn = new Toolbox_Button("Generalization");
//    private Toolbox_Button impBtn = new Toolbox_Button("Implements");
//    private Toolbox_Button asscBtn = new Toolbox_Button("Association");
//    private Toolbox_Button aggrBtn = new Toolbox_Button("Aggregation");
//    private Toolbox_Button compBtn = new Toolbox_Button("Composition");
//    private Toolbox_Button dependBtn = new Toolbox_Button("Dependency");

    public Toolbox(Main main) {
        this.main = main;
        this.stage = new Stage();
        this.stage.setTitle(Main.title + ": " + Toolbox.title);

        // layout
        this.setLayout();
        this.setButtons();

        // set & show
        this.scene = new Scene(this.layout, Toolbox.width, Toolbox.height);
        this.stage.setScene(this.scene);
        this.stage.setResizable(false);
        this.setPosition();
        this.stage.show();
    }

    private void setLayout() {
        this.layout = new VBox();
        this.layout.setStyle(Main.style.bgColor);
    }

    private void setButtons() {
        Main main = this.main; // aliased

        // class button
        Images test = new Images();
        ImageView img = new ImageView(test.aggregation());
        img.setFitHeight(40.0);
        img.setPreserveRatio(true);
        classBtn.setGraphic(img);

        this.classBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                main.controller.setDraw("class");
                //System.out.println("Hello World!");
            }
        });

        this.layout.getChildren().addAll(classBtn);
    }

    public void createToolbox(){

    }

    private void setPosition() {
        this.xPos = main.stage.getX() - Toolbox.width - Toolbox.widthPadding;
        this.yPos = main.stage.getY();
        this.stage.setX(this.xPos);
        this.stage.setY(this.yPos);
    }

    public class Toolbox_Button extends Button {

        public Toolbox_Button() {
            super();
            this.setMinWidth(Toolbox.width);
            this.setMinHeight(30);
            this.setId("toolButtons");
            this.getStylesheets().add("UMLEditor/resources/styles.css");
        }
    }

}

