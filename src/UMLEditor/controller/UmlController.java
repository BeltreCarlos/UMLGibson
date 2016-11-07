package UMLEditor.controller;

import UMLEditor.Main;
import UMLEditor.model.*;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;
import UMLEditor.view.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * Created by beltre on 10/27/16.
 */
public class UmlController {


    // parent instance
    private Main main;
    private Toolbox toolbox;
    private UmlModel model = new UmlModel();
    ArrayList<Node> clickedNodes = new ArrayList<>();

    // action
    String item = null;
    //--------------------------------------------------------------------------------------------------------------
    public UmlController(Main main) {
        this.main = main;
        this.toolbox = new Toolbox(this.main);

        model.getStateProperty().addListener(
                (ObservableValue<? extends State> ov, State old_state,
                 State new_state) ->{

                    if(new_state != State.LINE){
                        clickedNodes.clear();
                    }

                    switch (new_state){
                        case SELECT:
                            setSelectState();
                            break;
                        case CLASSBOX:
                            setClassBoxState();
                            break;

                    }
                }
        );

        //keeps track of change in toggle buttons
        toolbox.getStateToggle().selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle> ov, Toggle toggle,
                 Toggle new_toggle) -> {

                    if (new_toggle == null){
                        //do nothing
                    }else{
                        switch ((State) new_toggle.getUserData()){
                            case SELECT:
                                System.out.println("Select button on");
                                model.setState(State.SELECT);
                                break;
                            case CLASSBOX:
                                System.out.println("Classbox button on");
                                model.setState(State.CLASSBOX);
                                break;

                            default:
                                //something went wrong
                                break;
                        }
                    }
                });
        this.main.pane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node selectedNode = event.getPickResult().getIntersectedNode();
                Node filteredNode = checkIfPane(selectedNode);

                if(filteredNode != null){
                    model.getCurrentlySelectedNodeProperty().setValue(filteredNode);
                    //if we are in the line state and the node clicked on is able to have a line attached to it continue
                    if (model.getStateProperty().get() == State.LINE || model.getStateProperty().get() == State.ASSOCIATION
                            || model.getStateProperty().get() == State.GENERALIZATION && filteredNode instanceof Anchors) {
                        clickedNodes.add(filteredNode);
                        if(clickedNodes.size() == 2){
                            switch (model.getStateProperty().get()) {


                            }
                        }
                    }
                }
            }
        });

    }

    //--------------------------------------------------------------------------------------------------------------


    public void setDraw(String item) {
        /* sets what item teo draw next */
        this.item = item;
    }

//    public void initEvents() {
//        UmlController self = this;
//        this.main.pane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                //System.out.println("mouse click detected! " + mouseEvent.getSource());
//                self.draw();
//            }
//        });
//    }

    private Node checkIfPane(Node n) {
        if (n.getClass().equals(Pane.class)) {
            return null;
        } else {
            return n;
        }
    }

    private void setSelectState() {
        main.getEditPane().setOnMouseClicked(null);
    }

    private void setClassBoxState() {
        EventHandler<MouseEvent> createClassBox = (event) -> {
            double x = event.getX();
            double y = event.getY();
            System.out.println("You created a ClassBox at " + x + " , " + y);
            main.getEditPane().getChildren().add(new Classbox(x, y));
        };

        main.getEditPane().setOnMouseClicked(createClassBox);
    }

    // called on click
//    public void draw() {
//        if (this.item != null) {
//            switch (this.item) {
//                case "class":
//                    this.drawClass();
//                    break;
//                default:
//                    // do nothing
//            }
//        }
//        this.item = null;
//    }

    // specific draw methods
//    public void drawClass() {
//        EventHandler<MouseEvent> createClassBox = (event) -> {
//            double x = event.getX();
//            double y = event.getY();
//
//            Classbox box = new Classbox(x, y);
//            this.main.pane.getChildren().addAll(box);
//            //this.main.model.addClass(box);
//        };
//        //this.main.model.addClass(createClassBox);
//
//        this.main.pane.setOnMouseClicked(createClassBox);
//
//    }

}
