package UMLEditor.view;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * Created by beltre on 10/30/16.
 */
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
