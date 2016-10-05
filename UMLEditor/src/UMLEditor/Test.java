package UMLEditor;

import javafx.scene.control.Button;

/**
 * Created by beltre on 9/27/16.
 */
public class Test {

    public Button createEditButton(){

        Button button = new Button();
        button.setTranslateX(400.0);
        button.setTranslateY(0.0);
        button.setMinWidth(100.0);
        button.setMinHeight(50.0);
        button.setText("Edit");

        return button;
    }

    public Button createSelectButton(){
        Button selectButton = new Button();
        selectButton.setTranslateX(300.0);
        selectButton.setTranslateY(0.0);
        selectButton.setMinWidth(100.0);
        selectButton.setMinHeight(50.0);
        selectButton.setText("Select");

        return selectButton;
    }

}
