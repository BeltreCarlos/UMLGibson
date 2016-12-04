package UMLEditor.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by beltre on 11/2/16.
 */
public class Images extends ImageView {
    private final Image classbox = new Image(getClass().getResourceAsStream("images/Classbox.png"));
    private final Image aggregation = new Image(getClass().getResourceAsStream("images/Aggregation.png"));
    private final Image association = new Image(getClass().getResourceAsStream("images/Association.png"));
    private final Image composition = new Image(getClass().getResourceAsStream("images/Composition.png"));
    private final Image dependency = new Image(getClass().getResourceAsStream("images/Dependency.png"));
    private final Image generalization = new Image(getClass().getResourceAsStream("images/Generalization.png"));
    private final Image implementation = new Image(getClass().getResourceAsStream("images/Implementation.png"));

    public Image getClassbox(){return this.classbox;}

    public Image getAggregation(){return this.aggregation;}

    public Image getAssociation(){return this.association;}

    public Image getComposition(){return this.composition;}

    public Image getDependency(){return this.dependency;}

    public Image getGeneralization(){return this.generalization;}

    public Image getImplementation(){return this.implementation;}
}
