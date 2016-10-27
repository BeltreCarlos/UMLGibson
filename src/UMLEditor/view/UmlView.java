package UMLEditor.view;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by beltre on 10/27/16.
 */
public class UmlView {
    private Pane editPane = new Pane();

    public UmlView(){
        super();
        editPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public Pane getEditPane() {
        return editPane;
    }
}
