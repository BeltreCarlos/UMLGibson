package editor;

// default application
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// menus
import javafx.application.Platform;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Editor extends Application {
    // static variables
    public static String title = "UML Editor";
    public static int sceneWidth = 1024;
    public static int sceneHeight = 640;
   
    // main window
    public Stage stage;
    public BorderPane root;
    public Scene scene;
    public MenuBar menuBar;
    
    // tool window
    public static String toolTitle = "Toolbar";
    public static int toolWidth = 320;
    public static int toolHeight = 500;
    public Stage toolStage;
    public Scene toolScene;
    public Classbox toolBox;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.root = new BorderPane();
        this.scene = new Scene(this.root, Editor.sceneWidth, Editor.sceneHeight);
        
        // title & menu
        this.stage.setTitle(Editor.title);
        this.setMenuBar();
        
        // canvas
        
        // tool window
        this.setToolWindow();
        
        // set & show
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    // set tool window
    private void setToolWindow(){
        this.toolStage = new Stage();
        this.toolStage.setTitle(Editor.title + ": " + Editor.toolTitle);
        
        BorderPane bp = new BorderPane();
        this.toolBox = new Classbox();
        bp.getChildren().add(this.toolBox);
        this.toolScene = new Scene(bp, Editor.toolWidth, Editor.toolHeight);
        
        this.toolStage.setScene(this.toolScene);
        this.toolStage.setX(this.toolScene.getX());
        this.toolStage.setY(this.toolScene.getY());
        this.toolStage.setResizable(false);
        this.toolStage.show();
    }
    
    // set menu bar
    private void setMenuBar(){
        this.menuBar = new MenuBar();
        this.menuBar.prefWidthProperty().bind(this.stage.widthProperty());
        this.root.setTop(this.menuBar);

        // File menu - new, save, exit
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        //exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        
        Menu toolMenu = new Menu("Tools");
        MenuItem toggleTools = new MenuItem("Toggle toolbox");
        //exitMenuItem.setOnAction(actionEvent -> Platfo

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
            new SeparatorMenuItem(), exitMenuItem);
        toolMenu.getItems().add(toggleTools);
        this.menuBar.getMenus().addAll(fileMenu, toolMenu);
    }
    
}