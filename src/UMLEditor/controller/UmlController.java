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

                        case ASSOCIATION:
                            model.setState(State.ASSOCIATION);
                            break;

                        case LINE:
                            model.setState(State.LINE);
                            break;

                        case GENERALIZATION:
                            model.setState(State.GENERALIZATION);
                            break;

                        case IMPLEMENTS:
                            model.setState(State.IMPLEMENTS);
                            break;

                        case AGGREGATION:
                            model.setState(State.AGGREGATION);
                            break;

                        case COMPOSITION:
                            model.setState(State.COMPOSITION);
                            break;

                        case DEPENDENCY:
                            model.setState(State.DEPENDENCY);
                            break;

                        default:
                            //do nothing
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
        // listens for all presses on the pane, we use this to see what nodes are being pressed on
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

    /**
     * Checks if what you clicked on is the pane
     *
     * @param n what you clicked on
     * @return the node or null if the pane
     */
    private Node checkIfPane(Node n) {
        if (n.getClass().equals(Pane.class)) {
            return null;
        } else {
            return n;
        }
    }
    /**
     * sets the panes clicks to null
     */
    private void setSelectState() {
        main.getEditPane().setOnMouseClicked(null);
    }

    /**
     * returns the model
     * @return UmlModel
     */
    public UmlModel getModel() {
        return model;
    }

    public Toolbox getToolbox() {
        return toolbox;
    }

    /**
     * Sets the panes clicks to create class boxes
     */
    private void setClassBoxState() {
        EventHandler<MouseEvent> createClassBox = (event) -> {
            double x = event.getX();
            double y = event.getY();
            System.out.println("You created a ClassBox at " + x + " , " + y);
            main.getEditPane().getChildren().add(new Classbox(x, y));
        };

        main.getEditPane().setOnMouseClicked(createClassBox);
    }


}
