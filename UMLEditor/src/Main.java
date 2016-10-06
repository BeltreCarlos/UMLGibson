import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import UMLEditor.Controller.Controller;
import javafx.scene.layout.Pane;
import UMLEditor.View.Classbox;
import UMLEditor.Test;
import java.awt.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Test Window");

        Classbox box = new Classbox();
        Classbox box2 = new Classbox();
        Test buttons = new Test();

        Pane layout = new Pane();
        layout.getChildren().addAll(box, box2, buttons.createEditButton(), buttons.createSelectButton());

        Scene scene = new Scene(layout, 600, 550);

        window.setScene(scene);
        window.show();

    }

}
