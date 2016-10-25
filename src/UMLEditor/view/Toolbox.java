package UMLEditor.view;

import UMLEditor.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class Toolbox {
    // static variables
    public static String title = "Toolbox";
    public static double width = 200;
    public static double height = 250;
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
    
    public Toolbox(Main main){
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
    private void setLayout(){
        this.layout = new VBox();
        this.layout.setStyle(Main.style.bgColor);
    }
    Toolbox_Button classButton = new Toolbox_Button("Classbox");
    Toolbox_Button genButton = new Toolbox_Button("Generalization");
    Toolbox_Button impButton = new Toolbox_Button("Implements");
    Toolbox_Button assocButton = new Toolbox_Button("Association");
    Toolbox_Button aggrButton = new Toolbox_Button("Aggregation");
    Toolbox_Button compButton = new Toolbox_Button("Composition");
    Toolbox_Button dependButton = new Toolbox_Button("Dependency");

    private void setButtons(){
        this.layout.getChildren().addAll(classButton, genButton, impButton, assocButton,
                aggrButton, compButton, dependButton);
    }
    private void setPosition(){
        this.xPos = main.stage.getX() - Toolbox.width - Toolbox.widthPadding;
        this.yPos = main.stage.getY();
        this.stage.setX(this.xPos);
        this.stage.setY(this.yPos);
    }
    public class Toolbox_Button extends Button{
        public String label;
        
        public Toolbox_Button(String label){
            super(label);
            this.label = label;
            this.setSize();
            this.setId("toolButtons");
            this.getStylesheets().add("UMLEditor/resources/styles.css");
        }
        private void setSize(){
            this.setMaxWidth(Toolbox.width);
            this.setMinHeight(30);
        }
    }
    

}
