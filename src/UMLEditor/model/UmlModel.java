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

    // parent instance
    //private final Main main;

    private SimpleObjectProperty<State> state;
    private SimpleObjectProperty<Node> currentlySelectedNode;

    // lists of items
    ArrayList<Classbox> classboxList = new ArrayList<>();

    public UmlModel(){
        this.state = new SimpleObjectProperty();
        state.setValue(State.SELECT);

        this.currentlySelectedNode = new SimpleObjectProperty();
        //this.main = main;
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

    public void addClass(Classbox box){
        this.classboxList.add(box);
        //System.out.println(box.orgX);
    }
//================================================================================================================
//    private SimpleObjectProperty<State> state;
//    private SimpleObjectProperty<Node> currentlySelectedNode;
//
//    public UmlModel(){
//        this.state = new SimpleObjectProperty();
//        state.setValue(State.SELECT);
//
//
//        this.currentlySelectedNode = new SimpleObjectProperty();
//
//
//    }
//
//    public void setState(State s){
//        this.state.setValue(s);
//    }
//
//    public SimpleObjectProperty<State> getStateProperty(){
//        return state;
//    }
//
//    public SimpleObjectProperty<Node> getCurrentlySelectedNodeProperty(){
//        return currentlySelectedNode;
//    }

//================================================================================================================


}
