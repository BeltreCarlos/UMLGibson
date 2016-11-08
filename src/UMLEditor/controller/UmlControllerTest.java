package UMLEditor.controller;

import UMLEditor.Main;
import UMLEditor.model.State;
import UMLEditor.model.UmlModel;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;

/**
 * Created by beltre on 11/7/16.
 */
public class UmlControllerTest {
    Main main = new Main();

    @Test
    public void checkInitialStateIsSelect(){
        UmlController controller = new UmlController(this.main);
        UmlModel model = controller.getModel();
        assertEquals(model.getStateProperty().get(), State.SELECT);
    }

}