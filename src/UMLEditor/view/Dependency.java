/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMLEditor.view;

import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.shape.Line;

/**
 *
 * @author pslandis
 */
public class Dependency extends Line implements Anchors {
    private int anchorCount;
    private Point2D[] anchorPoints; // array of each anchorpoint in the box
    // start
    // end
    
    public Dependency(double startX, double startY, double endX, double endY){
        super(startX, startY, endX, endY);

        anchorCount = 2;
        anchorPoints = new Point2D[anchorCount];
        //setCursor(Cursor.OPEN_HAND);
        //setAnchorPoints(x, y);
        //setTranslateX(x);
        //setTranslateY(y);
        // set anchor on first click of classbox
        // set anchor on second click of classbox   
    }
    
    public void setAnchorPoints(double x, double y){
        //anchorPoints[0] = new Point2D(x, y + (height/2)); //left
        //anchorPoints[1] = new Point2D(x + (width/2), y); //top
    }

    public void updateXAnchors(double x){
        //anchorPoints[0] = new Point2D(x, anchorPoints[0].getY()); //left
        //anchorPoints[1] = new Point2D(x + (width/2), anchorPoints[1].getY()); //top
    }

    public void updateYAnchors(double y){
        //anchorPoints[0] = new Point2D(anchorPoints[0].getX(), y + (height/2)); //left
        //anchorPoints[1] = new Point2D(anchorPoints[1].getX(), y); //top
    }

    public Point2D getAnchorPoint(int i){
        if(i <= anchorPoints.length){
            return anchorPoints[i];
        }else{
            return null;
        }
    }
}
