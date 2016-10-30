package UMLEditor.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import UMLEditor.view.*;

/**
 * Created by beltre on 10/27/16.
 */
public class UmlController {

    UmlView view = new UmlView();

    private void setClassBox() {
        EventHandler<MouseEvent> createClassBox = (event) -> {
            double x = event.getX();
            double y = event.getY();
            //System.out.println("You created a ClassBox at " + x + " , " + y);
            //view.getEditPane().getChildren().add(new ClassBox(x, y));
        };
    }

}
