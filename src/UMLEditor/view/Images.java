package UMLEditor.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by beltre on 11/2/16.
 */
public class Images extends ImageView {
    //private final Image aggregation = new Image(getClass().getResourceAsStream("images/Aggregation.png"));
//    private final Image association = new Image(getClass().getResourceAsStream("images/Association.png"));
    private final Image classbox = new Image(getClass().getResourceAsStream("images/Classbox.png"));
//    private final Image composition = new Image(getClass().getResourceAsStream("images/Aggregation.png"));
//    private final Image dependency = new Image(getClass().getResourceAsStream("images/Dependency.png"));
//    private final Image generalization = new Image(getClass().getResourceAsStream("images/Generalization.png"));
//    private final Image implementation = new Image(getClass().getResourceAsStream("images/Implementation.png"));

    public Image classbox(){
        return this.classbox;

    }
}
