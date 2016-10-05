package editor;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by beltre on 9/21/16, edited by llondon on 10/5/16.
 */
public class Classbox extends VBox {

    private double orgX, orgY;
    private double height, width;
    private int anchorCount;
    private Point2D[] anchorPoints; // array of each anchorpoint in the box
    private Point2D dragAnchor; // new location of anchor after moved
    private TextArea className;
    private TextArea classMethods;
    private TextArea classFunctions;
    private Button buttonClass;
    private Button buttonInterface;
    private Button buttonAssociation;

    public Classbox() {
        super();

        buttonClass = new Button();
        buttonClass.setText("New Class");
        
        buttonInterface = new Button();
        buttonInterface.setText("New Interface");
        
        buttonAssociation = new Button();
        buttonAssociation.setText("New Association");
        //width = 150.0;
        //height = 200.0;
        width = Editor.toolWidth;
        height = Editor.toolHeight;
        setPrefWidth(width);
        setPrefHeight(height);
        
        //anchorCount = 4;
        //anchorPoints = new Point2D[anchorCount];
        //setAnchorPoints(100.0, 100.0);

        getChildren().addAll(buttonClass, buttonInterface, buttonAssociation);
        //this.setMaxWidth(width);
        //this.setMaxHeight(height);
        this.setStyle("-fx-border-style: solid;" + "-fx-border-width: 1;"
                + "-fx-border-color: black;");

    }

    public void setAnchorPoints(double x, double y){
        anchorPoints[0] = new Point2D(x, y + (height/2)); //left
        anchorPoints[1] = new Point2D(x + (width/2), y); //top
        anchorPoints[2] = new Point2D(x + width, y + (height/2)); //right
        anchorPoints[3] = new Point2D(x + (width/2), y + height); //bottom
    }

    public void updateXAnchors(double x){
        anchorPoints[0] = new Point2D(x, anchorPoints[0].getY()); //left
        anchorPoints[1] = new Point2D(x + (width/2), anchorPoints[1].getY()); //top
        anchorPoints[2] = new Point2D(x + width, anchorPoints[2].getY()); //right
        anchorPoints[3] = new Point2D(x + (width/2), anchorPoints[3].getY()); //bottom
    }

    public void updateYAnchors(double y){
        anchorPoints[0] = new Point2D(anchorPoints[0].getX(), y + (height/2)); //left
        anchorPoints[1] = new Point2D(anchorPoints[1].getX(), y); //top
        anchorPoints[2] = new Point2D(anchorPoints[2].getX(), y + (height/2)); //right
        anchorPoints[3] = new Point2D(anchorPoints[3].getX(), y + height); //bottom
    }

    public Point2D getAnchorPoint(int i){
        if(i <= anchorPoints.length){
            return anchorPoints[i];
        }else{
            return null;
        }
    }


}