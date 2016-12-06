package UMLEditor.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

import javax.xml.soap.Node;

/**
 * Created by beltre on 12/4/16.
 */
public class Generalization extends UmlLine implements NodeEditMenu {

    private Rotate rotate = new Rotate();
    private Polygon polygon = new Polygon();
    private Images img = new Images();

    public Generalization(Anchors a1, Anchors a2){
        super(a1, a2);

        //coordinates to make a triangle
        polygon.getPoints().addAll(new Double[]{0.0, 0.0,
                -12.0, -7.0,
                -12.0, 7.0}
        );
        polygon.setFill(Color.WHITE);
        polygon.setStrokeWidth(1);
        polygon.setStroke(Color.BLACK);

        double deltaX = this.getStartY() - this.getEndY();
        double deltaY = this.getEndX() - this.getStartX();
        double slopeInDegrees = Math.toDegrees(Math.atan2(deltaX, deltaY));

        polygon.getTransforms().add(rotate);
        rotate.setAngle(-slopeInDegrees);
        polygon.setTranslateX(this.getEndX());
        polygon.setTranslateY(this.getEndY());

    }

    @Override
    public void updateAnchorPoints()
    {
        double min = 999999999;
        point1Int = 0;
        point2Int = 0;
        for (int i = 0; i < anchorPoint1.getAnchorCount(); ++i)
        {
            startingAnchor = new Point2D(anchorPoint1.getAnchorPoint(i).getX(),
                    anchorPoint1.getAnchorPoint(i).getY());
            for (int j = 0; j < anchorPoint2.getAnchorCount(); ++j)
            {
                endingAnchor = new Point2D(anchorPoint2.getAnchorPoint(j).getX(),
                        anchorPoint2.getAnchorPoint(j).getY());
                if (startingAnchor.distance(endingAnchor) < min)
                {
                    min = startingAnchor.distance(endingAnchor);
                    point1Int = i;
                    point2Int = j;
                }
            }
        }
        this.setStartX(anchorPoint1.getAnchorPoint(point1Int).getX());
        this.setStartY(anchorPoint1.getAnchorPoint(point1Int).getY());
        this.setEndX(anchorPoint2.getAnchorPoint(point2Int).getX());
        this.setEndY(anchorPoint2.getAnchorPoint(point2Int).getY());

        double deltaX = this.getStartY() - this.getEndY();
        double deltaY = this.getEndX() - this.getStartX();
        //gets you the degress of the x axis(on the left) of the second clicked node
        double slopeInDegrees = Math.toDegrees(Math.atan2(deltaX,deltaY));

        if (polygon != null)
        {
            polygon.setTranslateX(this.getEndX());
            polygon.setTranslateY(this.getEndY());
            rotate.setAngle(-slopeInDegrees);

        }
    }

    public Polygon filledArrow(){ return polygon; }

    @Override
    public void deleteSelf()
    {
        Pane pane = (Pane)this.getParent();
        pane.getChildren().remove(polygon);
        anchorPoint1.deleteLine(id);
        anchorPoint2.deleteLine(id);
    }

    @Override
    public void generatePanel(VBox v)
    {
        v.getChildren().clear();
        DropShadow dropShadow = new DropShadow();
        dropShadow.setHeight(40.0);
        dropShadow.setWidth(40.0);
        //dropShadow.setColor(Color.RED);

        Button deleteB = new Button();
        deleteB.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(deleteB, Priority.ALWAYS);
        ImageView deleteBImg = new ImageView(img.getDelete());
        deleteBImg.setFitHeight(45.0);
        deleteBImg.setFitWidth(Double.MAX_VALUE);
        deleteBImg.setPreserveRatio(true);
        deleteB.setGraphic(deleteBImg);
        deleteB.setTooltip(new Tooltip("Delete Class"));
        deleteB.setOnAction((ActionEvent e) -> {
            deleteSelf();
            v.getChildren().clear();
        });
        deleteB.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        deleteB.setEffect(dropShadow);
                    }
                });
        deleteB.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        deleteB.setEffect(null);
                    }
                });

        v.getChildren().addAll(deleteB);

    }

}
