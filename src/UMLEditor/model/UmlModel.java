package UMLEditor.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;

/**
 * Created by beltre on 10/25/16.
 */
public class UmlModel {

    private SimpleObjectProperty<State> state;
    private SimpleObjectProperty<Node> currentlySelectedNode;

    public UmlModel(){
        this.state = new SimpleObjectProperty();
        state.setValue(State.SELECT);


        this.currentlySelectedNode = new SimpleObjectProperty();


    }

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
