package UMLEditor;

import UMLEditor.controller.UmlController;
import UMLEditor.model.UmlModel;
import UMLEditor.view.UmlView;
import UMLEditor.view.Display;
import UMLEditor.view.Menu;
import UMLEditor.view.Toolbox;
//import editor.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//import UMLEditor.Controller.Controller;
import javafx.scene.layout.Pane;
import UMLEditor.view.Classbox;
import UMLEditor.view.Menu;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

/**
 * Created by beltre on 9/21/16.
 */
public class Main extends Application {

    // static variables
    public static String title = "UML Editor";
    public static int width = 1024;
    public static int height = 640;
    //public static Display display = new Display();
    public static Style style = new Style();

    // controller
    public UmlController controller;
    public UmlModel model;
    private UmlView view;

    // instance variables
    public Stage stage;
    public BorderPane layout;
    public Pane pane;
    public Scene scene;

    // visual classes
    public Menu menu;
    public Toolbox toolbox;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle(UMLEditor.Main.title);

        // layout
        setLayout();
        // menu
        initMenu();

        // scene
        scene = new Scene(layout, UMLEditor.Main.width, UMLEditor.Main.height);

        // controller
        controller = new UmlController(this);
        controller.initEvents();

        // model
        //model = new UmlModel(this);

        // set & show
        stage.setScene(scene);
        stage.show();

        // toolbox
        initToolbox(); // must do after showing main stage

    }
    private void setLayout(){
        layout = new BorderPane();
        pane = new Pane();
        pane.setStyle(style.bgColor);
        layout.setCenter(pane);
    }
    private void initMenu(){
        menu = new Menu(this);
    }
    private void initToolbox(){
        toolbox = new Toolbox(this);
    }

}
