package UMLEditor.view;

import UMLEditor.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Toolbox { 
    // static variables
    public static String title = "Toolbox";
    public static double width = 320;
    public static double height = 500;
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
    private void setButtons(){
        this.layout.getChildren().addAll(
            new Toolbox_Button("Class"), 
            new Toolbox_Button("Generalization"), 
            new Toolbox_Button("Implements"),
            new Toolbox_Button("Association"),
            new Toolbox_Button("Aggregation"),
            new Toolbox_Button("Composition"),
            new Toolbox_Button("Dependency")
        );
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
        }
        private void setSize(){
            this.setMaxWidth(Toolbox.width/3);
            this.setMaxHeight(Toolbox.width/3);
        }
    }
    

}
