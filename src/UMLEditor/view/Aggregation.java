package UMLEditor.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;


/**
 * Created by beltre on 11/21/16.
 */
public class Aggregation extends UmlLine {

    Rotate rotate = new Rotate();
    Polygon polygon = new Polygon();
    Boolean filled = false;

    public Aggregation(Anchors a1, Anchors a2)
    {
        super(a1, a2);
        polygon.getPoints().addAll(new Double[]{
            0.0, 0.0,
                -12.0, -7.0,
                -24.0, 0.0,
                -12.0, 7.0
        });

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
        for(int i = 0; i < anchorPoint1.getAnchorCount(); ++i)
        {
            startingAnchor = new Point2D(anchorPoint1.getAnchorPoint(i).getX(),
                    anchorPoint1.getAnchorPoint(i).getY());
            for(int j = 0; j < anchorPoint2.getAnchorCount(); ++j)
            {
                endingAnchor = new Point2D(anchorPoint2.getAnchorPoint(j).getX(),
                        anchorPoint2.getAnchorPoint(j).getY());
                if(startingAnchor.distance(endingAnchor) < min)
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

        if(polygon != null)
        {
            polygon.setTranslateX(this.getEndX());
            polygon.setTranslateY(this.getEndY());
            rotate.setAngle(-slopeInDegrees);
        }
    }

    public Polygon diamond(){ return polygon; }

    @Override
    public void deleteSelf()
    {
        Pane pane = (Pane)this.getParent();
        pane.getChildren().remove(polygon);
        anchorPoint1.deleteLine(id);
        anchorPoint2.deleteLine(id);
    }

    private void setFillWhite()
    {
        if(polygon != null)
        {
            filled = false;
            polygon.setFill(Color.WHITE);
        }
    }

    private void setFillBlack()
    {
        if(polygon != null)
        {
            filled = true;
            polygon.setFill(Color.BLACK);
        }
    }

}
