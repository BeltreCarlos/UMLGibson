/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMLEditor.view;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Display {
    private final Rectangle2D bounds;
    
    public double width;
    public double height;
    
    public Display(){
        this.bounds = Screen.getPrimary().getVisualBounds();
        this.width = this.bounds.getWidth();
        this.height = this.bounds.getHeight();
    }
}
