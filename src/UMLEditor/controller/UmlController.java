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

        // called on load, set initial state of all buttons
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
                            
                        case DEPENDENCY:
                            setDependencyState();
                            break;
                            
                        case ASSOCIATION:
                            setAssociationState();
                            break;
                            
                        case GENERALIZATION:
                            setGeneralizationState();
                            break;

                        case IMPLEMENTATION:
                            setImplementationState();
                            break;

                        case AGGREGATION:
                            setAggregationState();
                            break;

                        case COMPOSITION:
                            setCompositionState();
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
                                
                            case DEPENDENCY:
                                System.out.println("Dependency button on");
                                model.setState(State.DEPENDENCY);
                                break;
                                
                            case ASSOCIATION:
                                System.out.println("Association button on");
                                model.setState(State.ASSOCIATION);
                                break;
                                
                            case GENERALIZATION:
                                System.out.println("Generalization button on");
                                model.setState(State.GENERALIZATION);
                                break;
                                
                            case IMPLEMENTATION:
                                System.out.println("Implementation button on");
                                model.setState(State.IMPLEMENTATION);
                                break;
                                
                            case AGGREGATION:
                                System.out.println("Aggregation button on");
                                model.setState(State.AGGREGATION);
                                break;
                                
                            case COMPOSITION:
                                System.out.println("Composition button on");
                                model.setState(State.COMPOSITION);
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

                if(filteredNode != null){// if clicking node
                    model.getCurrentlySelectedNodeProperty().setValue(filteredNode); // set currently selected
                    
                    //if we are in the line state and the node clicked on is able to have a line attached to it continue
                    if (model.getStateProperty().get() == State.LINE || model.getStateProperty().get() == State.ASSOCIATION || model.getStateProperty().get() == State.DEPENDENCY || model.getStateProperty().get() == State.GENERALIZATION && filteredNode instanceof Anchors) {
                        clickedNodes.add(filteredNode);
                        if(clickedNodes.size() == 2){
                            switch (model.getStateProperty().get()) {
                                
                            }
                        }
                    }
                    
                }// clicking node
            }
        });

    }

    //--------------------------------------------------------------------------------------------------------------
    public void initEvents(){
        this.toolbox.initEvents();
    }
    public void showToolbox(Boolean bool){
        if(bool){
            toolbox.stage.show();
        }else{ 
            toolbox.stage.hide();
        }
    }

    public void setDraw(String item) {
        /* sets what item teo draw next */
        this.item = item;
    }

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

    private void setDependencyState(){
        EventHandler<MouseEvent> createDependency = (event) -> {
            double x = event.getX();
            double y = event.getY();
            //System.out.println("You created a ClassBox at " + x + " , " + y);
            main.getEditPane().getChildren().add(new Dependency(x, y, 0, 0 ));
        };

        main.getEditPane().setOnMouseClicked(createDependency);
    }

    private void setAssociationState(){
        
    }
    
    private void setGeneralizationState(){
        
    }
    
    private void setImplementationState(){
        
    }
    
    private void setAggregationState(){
        
    }
    
    private void setCompositionState(){
        
    }
}
