package editor;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Toolbox {
    // static variables
    public static String title = "Toolbox";
    public static int width = 320;
    public static int height = 500;
    
    // instance variables
    public Stage stage;
    public Scene scene;
    public BorderPane bp;
    public Pane pane;
    
    public Toolbox(){
        this.stage = new Stage();
        this.stage.setTitle(Main.title + ": " + Toolbox.title);
        
        BorderPane bp = new BorderPane();
        //this.toolBox = new Classbox();
        //bp.getChildren().add(this.toolBox);
        this.scene = new Scene(bp, Toolbox.width, Toolbox.height);
        
        this.stage.setScene(this.scene);
        //this.toolStage.setX(this.toolScene.getX());
        //this.toolStage.setY(this.toolScene.getY());
        this.stage.setResizable(false);
        this.stage.show();
    }
}
