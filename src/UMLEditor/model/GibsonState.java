package UMLEditor.model;

import java.util.IntSummaryStatistics;

/**
 * Created by beltre on 12/6/16.
 */
public class GibsonState {

    public static int currentState = 0;


    public int getGibsonState(){
        return currentState;
    }

    public void setGibsonState(int x){
        currentState = x;
    }
}
