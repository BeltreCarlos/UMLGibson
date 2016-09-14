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
   
    // instance variables
    public Stage stage;
    public BorderPane root;
    public Scene scene;
    public MenuBar menuBar;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.root = new BorderPane();
        this.scene = new Scene(this.root, this.sceneWidth, this.sceneHeight);
        
        // title & menu
        this.stage.setTitle(this.title);
        this.setMenuBar();
        
        // set & show
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    // set window
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

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
            new SeparatorMenuItem(), exitMenuItem);

        Menu webMenu = new Menu("Web");
        CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
        htmlMenuItem.setSelected(true);
        webMenu.getItems().add(htmlMenuItem);

        CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
        cssMenuItem.setSelected(true);
        webMenu.getItems().add(cssMenuItem);

        Menu sqlMenu = new Menu("SQL");
        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem mysqlItem = new RadioMenuItem("MySQL");
        mysqlItem.setToggleGroup(tGroup);

        RadioMenuItem oracleItem = new RadioMenuItem("Oracle");
        oracleItem.setToggleGroup(tGroup);
        oracleItem.setSelected(true);

        sqlMenu.getItems().addAll(mysqlItem, oracleItem,
            new SeparatorMenuItem());

        Menu tutorialManeu = new Menu("Tutorial");
        tutorialManeu.getItems().addAll(
            new CheckMenuItem("Java"),
            new CheckMenuItem("JavaFX"),
            new CheckMenuItem("Swing"));

        sqlMenu.getItems().add(tutorialManeu);

        this.menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu);
    }
    
}
