package UMLEditor.view;

import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Line;

/**
 * Created by beltre on 11/21/16.
 */
public class UmlLine extends Line {

    protected Point2D startingAnchor;
    protected Point2D endingAnchor;
    protected int point1Int;
    protected int point2Int;
    private Point2D dragAnchor1;
    private Point2D dragAnchor2;
    protected Anchors anchorPoint1;
    protected Anchors anchorPoint2;
    private static int lineCount;
    protected int id;
    protected boolean dashed = false;


    /**
     *
     * @param a1 The AnchorPoint that the starting point of the line is attached
     * to.
     * @param a2 The AnchorPoint that the ending point of the line is attached
     * to.
     */
    public UmlLine(Anchors a1, Anchors a2)
    {
        super(a1.getAnchorPoint(0).getX(), a1.getAnchorPoint(0).getY(),
                a2.getAnchorPoint(0).getX(), a2.getAnchorPoint(0).getY());
        id = lineCount;
        ++lineCount;

        anchorPoint1 = a1;
        anchorPoint2 = a2;

        updateAnchorPoints();

        setCursor(Cursor.OPEN_HAND);
        setStrokeWidth(2.0);

        /**
         * playing around with ContextMenu for possible future usage
         */
        MenuItem delete = new MenuItem("delete");

        delete.setOnAction((e) -> {
            deleteSelf();
        });

        ContextMenu contextMenu = new ContextMenu(delete);

        setOnMouseClicked((event) -> {
            if(event.getButton() == MouseButton.SECONDARY)
            {
                System.out.println("Right click on line");
                contextMenu.show(this, event.getScreenX(), event.getScreenY());
            }else{
                contextMenu.hide();
            }
        });
    }

    public void updateAnchorPoints()
    {
        double min = 999999999;
        point1Int = 0;
        point2Int = 0;
        for(int i = 0; i < anchorPoint1.getAnchorCount(); ++i)
        {
            startingAnchor = new Point2D(anchorPoint1.getAnchorPoint(i).getX(), anchorPoint1.getAnchorPoint(i).getY());
            for(int j = 0; j < anchorPoint2.getAnchorCount(); ++j)
            {
                endingAnchor = new Point2D(anchorPoint2.getAnchorPoint(j).getX(), anchorPoint2.getAnchorPoint(j).getY());
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
    }


    protected void setDashed()
    {
        if(dashed == false)
        {
            this.getStrokeDashArray().addAll(9d, 9d, 9d, 9d);
            dashed = true;
        }
    }

    protected void setSolid()
    {
        this.getStrokeDashArray().clear();
        dashed = false;
    }

    /**
     *
     * @return returns which anchor point the starting point of the line is
     * connected to.
     */
    public int getAnchorPoint1Int(){return point1Int;}

    /**
     *
     * @return returns which anchor point the ending point of the line is
     * connected to.
     */
    public int getAnchorPoint2Int(){return point2Int;}

    /**
     * deletes the line
     */
    public void deleteSelf()
    {
        anchorPoint1.deleteLine(id);
        anchorPoint2.deleteLine(id);
    }

    public int getIntId(){return id;}


}
