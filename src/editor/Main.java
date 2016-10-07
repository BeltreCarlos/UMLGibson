//package editor;
//
//import UMLEditor.view.Display;
//import UMLEditor.view.Menu;
//import UMLEditor.view.Toolbox;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
////import UMLEditor.Controller.Controller;
//import javafx.scene.layout.Pane;
//import UMLEditor.view.Classbox;
//import UMLEditor.Test;
//import javafx.scene.layout.BorderPane;
//
//public class Main extends Application {
//    // static variables
//    public static String title = "UML Editor";
//    public static int width = 1024;
//    public static int height = 640;
//    public static Display display = new Display();
//    public static Style style = new Style();
//
//    // instance variables
//    public Stage stage;
//    public BorderPane layout;
//    public Pane pane;
//    public Scene scene;
//
//    // visual classes
//    public Menu menu;
//    public Toolbox toolbox;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//    @Override
//    public void start(Stage primaryStage) {
//        this.stage = primaryStage;
//        this.stage.setTitle(Main.title);
//
//        // layout
//        this.setLayout();
//        // menu
//        this.initMenu();
//
//        // classboxes
//        Classbox box = new Classbox();
//        Classbox box2 = new Classbox();
//        Test buttons = new Test();
//        this.pane.getChildren().addAll(box, box2, buttons.createEditButton(), buttons.createSelectButton());
//
//        // set & show
//        this.scene = new Scene(this.layout, Main.width, Main.height);
//        this.stage.setScene(this.scene);
//        this.stage.show();
//
//        // toolbox
//        this.initToolbox(); // must do after showing main stage
//    }
//    private void setLayout(){
//        this.layout = new BorderPane();
//        this.pane = new Pane();
//        this.pane.setStyle(style.bgColor);
//        this.layout.setCenter(this.pane);
//    }
//    private void initMenu(){
//        this.menu = new Menu(this);
//    }
//    private void initToolbox(){
//        this.toolbox = new Toolbox(this);
//    }
//
//}
