package UMLEditor.view;

import UMLEditor.Main;
import UMLEditor.Style;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Created by beltre on 10/27/16.
 */
public class UmlView extends BorderPane {
    private Pane editPane = new Pane();
    private Style style = new Style();
    Main main = new Main();
    public BorderPane layout = new BorderPane();
    private Pane pane = new Pane();

    public UmlView() {
        super();
        editPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setCenter(editPane);

    }

    public Pane getEditPane() {
        return editPane;
    }


}
