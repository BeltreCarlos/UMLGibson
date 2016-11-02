package UMLEditor.view;

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
    private int anchorCount;
    private Point2D[] anchorPoints; // array of each anchorpoint in the box
    private Point2D dragAnchor; // new location of anchor after moved
    private TextArea className;
    private TextArea classMethods;
    private TextArea classFunctions;

    public Classbox() {
        super();

        width = 150.0;
        height = 200.0;
        anchorCount = 4;
        anchorPoints = new Point2D[anchorCount];
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
//        this.setStyle("-fx-border-style: solid;" + "-fx-border-width: 1;"
//                + "-fx-border-color: red;");

        //Events
        this.setOnMousePressed(e -> {
            orgX = getTranslateX();
            orgY = getTranslateY();
            dragAnchor = new Point2D(e.getSceneX(), e.getSceneY());
            e.consume();
        });

        // Drag/drop functionality
        this.setOnMouseDragged(e -> {
            double dragX = e.getSceneX() - dragAnchor.getX();
            double dragY = e.getSceneY() - dragAnchor.getY();
            double newX = orgX + dragX;
            double newY = orgY + dragY;
            width = widthProperty().getValue();
            height = heightProperty().getValue();
            if((newX >= this.sceneProperty().get().getX()) &&
                    (newX <= this.sceneProperty().get().getWidth()
                            - (this.sceneProperty().get().getX() + widthProperty().getValue()
                    ))) {

                setTranslateX(newX);
                updateXAnchors(newX);
            } else if(newX >= this.sceneProperty().get().getX()) {
                setTranslateX(this.sceneProperty().get().getWidth()
                        - widthProperty().getValue());
            } else {
                setTranslateX(0);
                updateXAnchors(0);
            }

            if ((newY >= this.sceneProperty().get().getY())
                    && (newY <= this.sceneProperty().get().getHeight()
                    - (this.sceneProperty().get().getY() + heightProperty()
                    .getValue()))) {
                setTranslateY(newY);
                updateYAnchors(newY);

            } else if (newY >= this.sceneProperty().get().getY()) {
                setTranslateY(this.sceneProperty().get().getHeight()
                        - heightProperty().getValue());
                updateYAnchors(this.sceneProperty().get().getHeight()
                        - heightProperty().getValue());
            } else {
                setTranslateY(0);
                updateYAnchors(0);
            }
            e.consume();
        });

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
