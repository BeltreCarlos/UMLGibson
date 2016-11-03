package UMLEditor.view;

import javafx.scene.image.Image;

/**
 * Created by beltre on 11/2/16.
 */
public class Images {
    private final Image aggregation = new Image(getClass().getResourceAsStream("images/Classbox.png"));
//    private final Image association = new Image(getClass().getResourceAsStream("/resources/images/Association.png"));
//    private final Image classbox = new Image(getClass().getResourceAsStream("/resources/images/Classbox.png"));
//    private final Image composition = new Image(getClass().getResourceAsStream("/resources/images/Aggregation.png"));
//    private final Image dependency = new Image(getClass().getResourceAsStream("/resources/images/Dependency.png"));
//    private final Image generalization = new Image(getClass().getResourceAsStream("/resources/images/Generalization.png"));
//    private final Image implementation = new Image(getClass().getResourceAsStream("/resources/images/Implementation.png"));

    public Images() {
        //public Image aggregation(){ return this.aggregation;}
        //System.out.println(aggregation.getHeight() + " " + aggregation.getWidth());
    }

    public Image aggregation(){
        return this.aggregation;

    }
}
