package UMLEditor.view;

import UMLEditor.model.LineType;
import javafx.geometry.Point2D;

/**
 * Created by beltre on 10/30/16.
 */
public interface Anchors {

    /**
     *
     * @param x
     *            The x position to be used to calculate the x position of the
     *            anchor points.
     * @param y
     *            The y position to be used to calculate the y position of the
     *            anchor points.
     */
    void setAnchorPoints(double x, double y);

    /**
     *
     * @param x
     *            The x position that will be used to update the x position of
     *            the anchor points.
     */
    void updateXAnchors(double x);

    /**
     *
     * @param y
     *            The y position to be used to calculate the y position of the
     *            anchor points.
     */
    void updateYAnchors(double y);

    /**
     *
     * @param i
     *            The index of the anchor point
     * @return Returns index i of anchorPoints
     */
    Point2D getAnchorPoint(int i);

    /**
     *
     * @return Returns how many anchor points this box has
     */
    //int getAnchorCount();

    /**
     *
     * @param str
     *            The enum that signifies whether this lineType is a startPoint
     *            or endPoint.
     */
    //public void addLineType(LineType str);

    /**
     *
     * @param line
     *            Adds a UMLLine line to Lines.
     */
    //public void addLine(UMLLine line);

    /**
     *
     * @param id
     *            The unique id of the line to determine which line needs to be
     *            deleted.
     */
    //public void deleteLine(int id);
}
