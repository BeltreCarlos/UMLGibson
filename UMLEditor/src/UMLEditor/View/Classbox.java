package UMLEditor.View;

import java.util.ArrayList;


import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by beltre on 9/21/16.
 */
public class Classbox extends VBox {

    private double orgX, orgY;
    private double height, width;
    private Point2D[] anchorPoints; // array of each anchorpoint in the box
    private Point2D dragAnchor; // new location of anchor after moved
    private TextArea className;
    private TextArea classMethods;
    private TextArea classFunctions;


    public Classbox() {
        super();

        width = 150.0;
        height = 200.0;
        anchorPoints = new Point2D[4];
        setAnchorPoints(100.0, 100.0);

        className = new TextArea();
        className.setPromptText("Name");
        className.setPrefRowCount(1);
        className.setPrefColumnCount(10);
        className.setWrapText(true);
        className.setEditable(false);
        className.setMouseTransparent(true);

        classMethods = new TextArea();
        classMethods.setPromptText("Methods");
        classMethods.setPrefRowCount(2);
        classMethods.setPrefColumnCount(10);
        classMethods.setWrapText(true);
        classMethods.setEditable(false);
        classMethods.setMouseTransparent(true);
        setVgrow(classMethods, Priority.ALWAYS);

        classFunctions = new TextArea();
        classFunctions.setPromptText("Functions");
        classFunctions.setPrefRowCount(3);
        classFunctions.setPrefColumnCount(10);
        classFunctions.setWrapText(true);
        classFunctions.setEditable(false);
        classFunctions.setMouseTransparent(true);
        setVgrow(classFunctions, Priority.ALWAYS);

        getChildren().addAll(className, classMethods, classFunctions);
        this.setMaxWidth(width);
        this.setMaxHeight(height);
        this.setStyle("-fx-border-style: solid;" + "-fx-border-width: 2;"
                + "-fx-border-color: black;");

    //Events
        this.setOnMousePressed(e -> {
            orgX = getTranslateX();
            orgY = getTranslateY();
            dragAnchor = new Point2D(e.getSceneX(), e.getSceneY());
            e.consume();
        });

        this.setOnMouseDragged(e -> {
            double dragX = e.getSceneX() - dragAnchor.getX();
            double dragY = e.getSceneY() - dragAnchor.getY();
            double newX = orgX + dragX;
            double newY = orgY + dragY;

        });



    }

    public void setAnchorPoints(double x, double y){
        anchorPoints[0] = new Point2D(x, y + (height/2)); //left
        anchorPoints[1] = new Point2D(x + (width/2), y); //top
        anchorPoints[2] = new Point2D(x + width, y + (height/2)); //right
        anchorPoints[3] = new Point2D(x + (width/2), y + height); //bottom
    }


}
