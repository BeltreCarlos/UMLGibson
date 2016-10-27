package UMLEditor.view;

import UMLEditor.Main;
import UMLEditor.model.State;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class Toolbox {
    // static variables
    public static double width = 200;
    public static double height = 230;
    public static double widthPadding = 10;
    private ToggleGroup stateToggle = new ToggleGroup();
    
    // parent instance
    private final Main main;
    
    // position
    private double yPos;
    private double xPos;
    
    // layout
    private Stage stage;
    private Scene scene;
    private VBox layout;
    public int spacing = 0;
    
    public Toolbox(Main main){
        this.main = main;
        this.stage = new Stage();
        
        // layout
        this.setLayout();
        this.setButtons();
        
        // set & show
        this.scene = new Scene(this.layout, Toolbox.width, Toolbox.height);
        this.stage.setScene(this.scene);
        this.stage.setResizable(false);
        this.stage.setTitle("Toolbox");
        this.setPosition();
        this.stage.show();
    }

    private void setLayout(){
        this.layout = new VBox();
        this.layout.setStyle(Main.style.bgColor);
    }

    private void setButtons(){
        Toolbox_Button classButton = new Toolbox_Button("Classbox");
        classButton.setUserData(State.CLASSBOX);
        classButton.setToggleGroup(stateToggle);

        Toolbox_Button genButton = new Toolbox_Button("Generalization");
        genButton.setUserData(State.GENERALIZATION);
        classButton.setToggleGroup(stateToggle);

        Toolbox_Button impButton = new Toolbox_Button("Implements");
        genButton.setUserData(State.IMPLEMENTS);
        classButton.setToggleGroup(stateToggle);

        Toolbox_Button assocButton = new Toolbox_Button("Association");
        genButton.setUserData(State.ASSOCIATION);
        classButton.setToggleGroup(stateToggle);

        Toolbox_Button aggrButton = new Toolbox_Button("Aggregation");
        genButton.setUserData(State.AGGREGATION);
        classButton.setToggleGroup(stateToggle);

        Toolbox_Button compButton = new Toolbox_Button("Composition");
        genButton.setUserData(State.COMPOSITION);
        classButton.setToggleGroup(stateToggle);

        Toolbox_Button dependButton = new Toolbox_Button("Dependency");
        genButton.setUserData(State.DEPENDENCY);
        classButton.setToggleGroup(stateToggle);

        this.layout.getChildren().addAll(classButton, genButton, impButton, assocButton,
                aggrButton, compButton, dependButton);
    }

    private void setPosition(){
        this.xPos = main.stage.getX() - Toolbox.width - Toolbox.widthPadding;
        this.yPos = main.stage.getY();
        this.stage.setX(this.xPos);
        this.stage.setY(this.yPos);
    }

    public class Toolbox_Button extends ToggleButton{

        public Toolbox_Button(String label){
            super(label);
            this.setMinWidth(Toolbox.width);
            this.setMinHeight(30);
            this.setId("toolButtons");
            this.getStylesheets().add("UMLEditor/resources/styles.css");
        }
    }
    

}
