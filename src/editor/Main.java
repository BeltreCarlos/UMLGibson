package editor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import UMLEditor.Controller.Controller;
import javafx.scene.layout.Pane;
import UMLEditor.View.Classbox;
import UMLEditor.Test;
import java.awt.*;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
    // static variables
    public static String title = "UML Editor";
    public static int sceneWidth = 1024;
    public static int sceneHeight = 640;
   
    // instance variables
    public Stage stage;
    public BorderPane bp;
    public Pane pane;
    public Scene scene;
    public javafx.scene.control.MenuBar menuBar;
    
    public Toolbox toolbox;
    
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        
        // title
        this.stage.setTitle(Main.title);
        
        // classboxes
        Classbox box = new Classbox();
        Classbox box2 = new Classbox();
        Test buttons = new Test();

        // border pane & pane
        this.bp = new BorderPane();
        this.pane = new Pane();
        this.bp.setCenter(this.pane);
        this.pane.getChildren().addAll(box, box2, buttons.createEditButton(), buttons.createSelectButton());

        // scene
        this.scene = new Scene(this.bp, Main.sceneWidth, Main.sceneHeight);

        // menu
        this.initMenu();
        
        // toolbox
        this.initToolbox();
        
        // set & show
        stage.setScene(scene);
        stage.show();

    }
    // toolbox
    private void initToolbox(){
        this.toolbox = new Toolbox();
    }
    // set menu bar
    private void initMenu(){
        this.menuBar = new javafx.scene.control.MenuBar();
        this.menuBar.prefWidthProperty().bind(this.stage.widthProperty());
        this.bp.setTop(this.menuBar);

        // File menu - new, save, exit
        javafx.scene.control.Menu fileMenu = new javafx.scene.control.Menu("File");
        javafx.scene.control.MenuItem newMenuItem = new javafx.scene.control.MenuItem("New");
        javafx.scene.control.MenuItem saveMenuItem = new javafx.scene.control.MenuItem("Save");
        javafx.scene.control.MenuItem exitMenuItem = new javafx.scene.control.MenuItem("Exit");
        //exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        
        javafx.scene.control.Menu toolMenu = new javafx.scene.control.Menu("Tools");
        javafx.scene.control.MenuItem toggleTools = new javafx.scene.control.MenuItem("Toggle toolbox");
        //exitMenuItem.setOnAction(actionEvent -> Platfo

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
        new SeparatorMenuItem(), exitMenuItem);
        toolMenu.getItems().add(toggleTools);
        this.menuBar.getMenus().addAll(fileMenu, toolMenu);
    }

}
