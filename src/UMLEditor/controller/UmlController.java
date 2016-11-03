package UMLEditor.controller;

import UMLEditor.Main;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import UMLEditor.view.*;

/**
 * Created by beltre on 10/27/16.
 */
public class UmlController {


    // parent instance
    private final Main main;

    // action
    String item = null;

    public UmlController(Main main) {
        this.main = main;
    }

    public void setDraw(String item) {
        /* sets what item teo draw next */
        this.item = item;
    }

    public void initEvents() {
        UmlController self = this;
        this.main.pane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("mouse click detected! " + mouseEvent.getSource());
                self.draw();
            }
        });
    }

    // called on click
    public void draw() {
        if (this.item != null) {
            switch (this.item) {
                case "class":
                    this.drawClass();
                    break;
                default:
                    // do nothing
            }
        }
        this.item = null;
    }

    // specific draw methods
    public void drawClass() {
        EventHandler<MouseEvent> createClassBox = (event) -> {
            double x = event.getX();
            double y = event.getY();

            Classbox box = new Classbox(x, y);
            this.main.pane.getChildren().addAll(box);
            this.main.model.addClass(box);
        };
        //this.main.model.addClass(createClassBox);

        this.main.pane.setOnMouseClicked(createClassBox);
        //Classbox box = new Classbox();

        // model
        //this.main.model.addClass(box);

        // view
        //this.main.pane.getChildren().addAll(box);
    }
}
