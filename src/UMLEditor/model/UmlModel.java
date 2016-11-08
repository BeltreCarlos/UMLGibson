package UMLEditor.model;

import UMLEditor.Main;
import UMLEditor.view.Classbox;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;

import java.util.ArrayList;

/**
 * Created by beltre on 10/25/16.
 */
public class UmlModel {
    //the current state for the object at hand
    private SimpleObjectProperty<State> state;
    private SimpleObjectProperty<Node> currentlySelectedNode;

    public UmlModel(){
        this.state = new SimpleObjectProperty();
        state.setValue(State.SELECT);

        this.currentlySelectedNode = new SimpleObjectProperty();
    }

    /**
     * @param s the state being toggled on
     */
    public void setState(State s){
        this.state.setValue(s);
    }

    public SimpleObjectProperty<State> getStateProperty(){
        return state;
    }

    public SimpleObjectProperty<Node> getCurrentlySelectedNodeProperty(){
        return currentlySelectedNode;
    }


}
