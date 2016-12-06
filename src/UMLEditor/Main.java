package UMLEditor;

import UMLEditor.controller.UmlController;
import UMLEditor.model.UmlModel;
import UMLEditor.view.UmlView;
import UMLEditor.view.Menu;
import UMLEditor.view.Toolbox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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
    private VBox nodeEditPanel;

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
        nodeEditPanel = createNodeEditPanel();

        layout.setCenter(pane);
        layout.setLeft(nodeEditPanel);

        layout.setStyle("-fx-background-color: transparent;");

        initMenu();
        controller = new UmlController(this);

        scene = new Scene(layout, this.width, this.height);


        // set & show
        stage.setScene(scene);
        stage.show();

    }

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

    private VBox createNodeEditPanel()
    {
        VBox vBox = new VBox();
        vBox.setPrefWidth(60.0);
        vBox.setPrefHeight(Double.MAX_VALUE);
        vBox.setStyle(style.bgColor);

        return vBox;
    }

    public VBox getCurrentlySelectedPanel() {
        return nodeEditPanel;
    }


}
