package UMLEditor;

import UMLEditor.controller.UmlController;
import UMLEditor.model.UmlModel;
import UMLEditor.view.UmlView;
import UMLEditor.view.Display;
import UMLEditor.view.Menu;
import UMLEditor.view.Toolbox;
//import editor.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//import UMLEditor.Controller.Controller;
import javafx.scene.layout.Pane;
import UMLEditor.view.Classbox;
import UMLEditor.view.Menu;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

/**
 * Created by beltre on 9/21/16.
 */
public class Main extends Application {

    // static variables
    public static String title = "UMLGibson Editor";
    public static int width = 1024;
    public static int height = 640;
    public static Style style = new Style();
    // MVC
    public UmlController controller;
    public UmlModel model;
    private UmlView view;
    // instance variables
    public Stage stage;
    public BorderPane layout;
    public Pane pane = new Pane();
    public Scene scene;
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
        layout = new BorderPane();
        pane.setStyle(style.bgColor);
        layout.setCenter(pane);

        // menu
        initMenu();

        // scene
        scene = new Scene(layout, this.width, this.height);

        // controller
        controller = new UmlController(this);

        // model
        //model = new UmlModel(this);

        // set & show
        stage.setScene(scene);
        stage.show();

    }
//    private void setLayout(){
//        layout = new BorderPane();
//        //pane = new Pane();
//        pane.setStyle(style.bgColor);
//        layout.setCenter(pane);
//    }

    public void updateBackground(String s){
        this.pane.setStyle(s);
    }

    /**
     * @return the pane where we are currently working
     */
    public Pane getEditPane(){
        return this.pane;
    }
    private void initMenu(){
        menu = new Menu(this);
    }
//    private void initToolbox(){
//        toolbox = new Toolbox(this);
//    }


}
