package UMLEditor.view;

import UMLEditor.Main;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Created by beltre on 10/27/16.
 */
public class UmlView extends BorderPane {
    private Pane editPane = new Pane();
    Main main = new Main();
    private Toolbox box = new Toolbox(main);
    private Toolbox toolBox;

    public UmlView() {
        super();
        editPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setCenter(editPane);

    }

    public Pane getEditPane() {
        return editPane;
    }

}
