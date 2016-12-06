package UMLEditor.view;

import java.util.ArrayList;

import UMLEditor.model.LineType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
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
public class Classbox extends VBox implements Anchors, NodeEditMenu {

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
    private Images img = new Images();

    public Classbox(double x, double y) {
        super();

        width = 150.0;
        height = 200.0;
        anchorCount = 4;
        anchorPoints = new Point2D[anchorCount];
        setAnchorPoints(x, y);
        pointTypes = new ArrayList<LineType>();
        lines = new ArrayList<UmlLine>();
        setCursor(Cursor.OPEN_HAND);
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

        this.setMaxWidth(width);
        this.setMaxHeight(height);

        getChildren().addAll(className, classMethods, classFunctions);

        /*
         * Movement Handling/Mouse Events Creation of ClassBox on Mouse Press
         * Mouse Drag determined by getting the current value of the classBox
         * after creation (it is initialized to 0.0 by default)
         */
        this.setOnMousePressed((event) -> {
            // when mouse is pressed, store initial position
            orgX = getTranslateX();
            orgY = getTranslateY();
            dragAnchor = new Point2D(event.getSceneX(), event.getSceneY());
            event.consume();
        });

        // Drag/drop functionality
        setOnMouseDragged(e -> {
            double dragX = e.getSceneX() - dragAnchor.getX();
            double dragY = e.getSceneY() - dragAnchor.getY();
            double newX = orgX + dragX;
            double newY = orgY + dragY;
            width = widthProperty().getValue();
            height = heightProperty().getValue();
            if((newX >= this.sceneProperty().get().getX()) && (newX <= this.sceneProperty().get().getWidth()
                            - (this.sceneProperty().get().getX() + widthProperty().getValue())))
            {
                setTranslateX(newX);
                updateXAnchors(newX);

            } else if(newX >= this.sceneProperty().get().getX()) {
                setTranslateX(this.sceneProperty().get().getWidth() - widthProperty().getValue());
                updateXAnchors(this.sceneProperty().get().getWidth() - widthProperty().getValue());

            } else {
                setTranslateX(0);
                updateXAnchors(0);
            }

            for(int i = 0; i < lines.size(); ++i)
            {
                lines.get(i).updateAnchorPoints();
                if(pointTypes.get(i).equals(LineType.START))
                {
                    lines.get(i).setStartX(anchorPoints[lines.get(i).getAnchorPoint1Int()].getX());
                }
                if(pointTypes.get(i).equals(LineType.END))
                {
                    lines.get(i).setEndX(anchorPoints[lines.get(i).getAnchorPoint2Int()].getX());
                }
            }

            if ((newY >= this.sceneProperty().get().getY()) && (newY <= this.sceneProperty().get().getHeight()
                    - (this.sceneProperty().get().getY() + heightProperty().getValue())))
            {
                setTranslateY(newY);
                updateYAnchors(newY);

            } else if (newY >= this.sceneProperty().get().getY()) {
                setTranslateY(this.sceneProperty().get().getHeight() - heightProperty().getValue());
                updateYAnchors(this.sceneProperty().get().getHeight() - heightProperty().getValue());

            } else {
                setTranslateY(0);
                updateYAnchors(0);
            }
            for(int i = 0; i < lines.size(); ++i)
            {
                lines.get(i).updateAnchorPoints();
                if(pointTypes.get(i).equals(LineType.START))
                {
                    lines.get(i).setStartY(anchorPoints[lines.get(i).getAnchorPoint1Int()].getY());
                }
                if(pointTypes.get(i).equals(LineType.END))
                {
                    lines.get(i).setEndY(anchorPoints[lines.get(i).getAnchorPoint2Int()].getY());
                }
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
        anchorPoints[0] = new Point2D(x + (width / 2), y); // top
        anchorPoints[1] = new Point2D(x, y + (height / 2)); // left
        anchorPoints[2] = new Point2D(x + width, y + (height / 2)); // right
        anchorPoints[3] = new Point2D(x + (width / 2), y + height); // bottom
    }

    /**
     * @param x The x position that will be used to update the x position of
     */
    public void updateXAnchors(double x){
        anchorPoints[0] = new Point2D(x + (width / 2), anchorPoints[0].getY());
        anchorPoints[1] = new Point2D(x, anchorPoints[1].getY());
        anchorPoints[2] = new Point2D(x + width, anchorPoints[2].getY());
        anchorPoints[3] = new Point2D(x + (width / 2), anchorPoints[3].getY());
    }

    /**
     * @param y The y position to be used to calculate the y position of the
     */
    public void updateYAnchors(double y){
        anchorPoints[0] = new Point2D(anchorPoints[0].getX(), y);
        anchorPoints[1] = new Point2D(anchorPoints[1].getX(), y + (height / 2));
        anchorPoints[2] = new Point2D(anchorPoints[2].getX(), y + (height / 2));
        anchorPoints[3] = new Point2D(anchorPoints[3].getX(), y + height);
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


    public void applyActions(TextArea text)
    {
        text.requestFocus();
        text.setEditable(true);
        text.setMouseTransparent(false);
        text.setStyle("-fx-background-color: red");
    }

    public void revertActions(TextArea text)
    {
        if(text == className)
        {
            classMethods.setEditable(false);
            classMethods.setMouseTransparent(true);
            classMethods.setStyle("-fx-background-color: white");
            classFunctions.setEditable(false);
            classFunctions.setMouseTransparent(true);
            classFunctions.setStyle("-fx-background-color: white");
        } else if(text == classMethods){
            className.setEditable(false);
            className.setMouseTransparent(true);
            className.setStyle("-fx-background-color: white");
            classFunctions.setEditable(false);
            classFunctions.setMouseTransparent(true);
            classFunctions.setStyle("-fx-background-color: white");
        } else {
            className.setEditable(false);
            className.setMouseTransparent(true);
            className.setStyle("-fx-background-color: white");
            classMethods.setEditable(false);
            classMethods.setMouseTransparent(true);
            classMethods.setStyle("-fx-background-color: white");
        }
    }

    public void removeActions()
    {
        revertActions(className);
        revertActions(classMethods);
        revertActions(classFunctions);

    }

    //**********
    @Override
    public void generatePanel(VBox v)
    {
        v.getChildren().clear();
        DropShadow dropShadow = new DropShadow();
        dropShadow.setHeight(40.0);
        dropShadow.setWidth(40.0);
        //dropShadow.setColor(Color.RED);

        Button editName = new Button();
        editName.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(editName, Priority.ALWAYS);
        ImageView editNameImg = new ImageView(img.getEditBox1());
        editNameImg.setFitHeight(60.0);
        editNameImg.setPreserveRatio(true);
        editName.setGraphic(editNameImg);
        editName.setTooltip(new Tooltip("Edit Name"));
        editName.setOnAction((ActionEvent e) ->
        {
            TextArea textArea = className;
            applyActions(textArea);
            revertActions(textArea);
        });
        editName.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) { editName.setEffect(dropShadow); }
        });
        editName.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e) { editName.setEffect(null); }
        });

        Button editOps = new Button();
        editName.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(editOps, Priority.ALWAYS);
        ImageView editOpsImg = new ImageView(img.getEditBox2());
        editOpsImg.setFitHeight(60.0);
        editOpsImg.setPreserveRatio(true);
        editOps.setGraphic(editOpsImg);
        editOps.setTooltip(new Tooltip("Edit Operations"));
        editOps.setOnAction((ActionEvent e) ->
        {
            TextArea textArea = classMethods;
            applyActions(textArea);
            revertActions(textArea);
        });
        editOps.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) { editOps.setEffect(dropShadow); }
        });
        editOps.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e) { editOps.setEffect(null); }
        });

        Button editFuncs = new Button();
        editFuncs.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(editFuncs, Priority.ALWAYS);
        ImageView editFuncsImg = new ImageView(img.getEditBox3());
        editFuncsImg.setFitHeight(60.0);
        editFuncsImg.setPreserveRatio(true);
        editFuncs.setGraphic(editFuncsImg);
        editFuncs.setTooltip(new Tooltip("Edit Functions"));
        editFuncs.setOnAction((ActionEvent e) ->
        {
            TextArea textArea = classFunctions;
            applyActions(textArea);
            revertActions(textArea);
        });
        editFuncs.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) { editFuncs.setEffect(dropShadow); }
        });
        editFuncs.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e) { editFuncs.setEffect(null); }
        });


        v.getChildren().addAll(editName, editOps, editFuncs);

    }
    //**********


}
