package UMLEditor.view;

import java.util.ArrayList;

import UMLEditor.model.LineType;
import javafx.scene.Cursor;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by beltre on 9/21/16.
 */
public class Classbox extends VBox implements Anchors {

    private double orgX, orgY;
    private double height, width;
    private int anchorCount;
    private Point2D[] anchorPoints; // array of each anchorpoint in the box
    private Point2D dragAnchor; // new location of anchor after moved
    private TextArea className;
    private TextArea classMethods;
    private TextArea classFunctions;
    private ArrayList<UmlLine> lines;
    private ArrayList<LineType> pointTypes;

    public Classbox(double x, double y) {
        super();

        width = 150.0;
        height = 200.0;
        anchorCount = 4;
        anchorPoints = new Point2D[anchorCount];
        setCursor(Cursor.OPEN_HAND);
        //setCursor(Cursor.CROSSHAIR);
        setAnchorPoints(x, y);
        setTranslateX(x);
        setTranslateY(y);

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

        /*
         * Movement Handling/Mouse Events Creation of ClassBox on Mouse Press
         * Mouse Drag determined by getting the current value of the classBox
         * after creation (it is initialized to 0.0 by default)
         */
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

    /**
     * @param x The x position to be used to calculate the x position of the
     *          anchor points.
     * @param y The y position to be used to calculate the y position of the
     */
    public void setAnchorPoints(double x, double y){
        anchorPoints[0] = new Point2D(x, y + (height/2)); //left
        anchorPoints[1] = new Point2D(x + (width/2), y); //top
        anchorPoints[2] = new Point2D(x + width, y + (height/2)); //right
        anchorPoints[3] = new Point2D(x + (width/2), y + height); //bottom
    }

    /**
     * @param x The x position that will be used to update the x position of
     */
    public void updateXAnchors(double x){
        anchorPoints[0] = new Point2D(x, anchorPoints[0].getY()); //left
        anchorPoints[1] = new Point2D(x + (width/2), anchorPoints[1].getY()); //top
        anchorPoints[2] = new Point2D(x + width, anchorPoints[2].getY()); //right
        anchorPoints[3] = new Point2D(x + (width/2), anchorPoints[3].getY()); //bottom
    }

    /**
     * @param y The y position to be used to calculate the y position of the
     */
    public void updateYAnchors(double y){
        anchorPoints[0] = new Point2D(anchorPoints[0].getX(), y + (height/2)); //left
        anchorPoints[1] = new Point2D(anchorPoints[1].getX(), y); //top
        anchorPoints[2] = new Point2D(anchorPoints[2].getX(), y + (height/2)); //right
        anchorPoints[3] = new Point2D(anchorPoints[3].getX(), y + height); //bottom
    }

    /**
     * @param i The index of the anchor point
     * @return
     */
    public Point2D getAnchorPoint(int i){
        if(i <= anchorPoints.length){
            return anchorPoints[i];
        }else{
            return null;
        }
    }

    @Override
    public int getAnchorCount(){return anchorCount;}

    @Override
    public void deleteLine(int id)
    {
        Pane pane = (Pane) this.getParent();
        int t = lines.size();
        for(int i = 0; i < lines.size(); ++i)
        {
            if(lines.get(i).getIntId() == id)
            {
                if(pane !=  null)
                {
                    if(pointTypes.get(i).equals(LineType.END))
                    {
                        pane.getChildren().remove(lines.get(i));
                    }
                    pointTypes.remove(pointTypes.get(i));
                    lines.remove(lines.get(i));
                    break;
                }
            }
        }
    }

    @Override
    public void addLine(UmlLine line){ lines.add(line);}

    @Override
    public void addLineType(LineType str){ pointTypes.add(str);}



}
