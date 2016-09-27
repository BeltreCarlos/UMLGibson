import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
//import UMLEditor.Controller.Controller;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import UMLEditor.View.Classbox;
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

        BorderPane borderPane = new BorderPane();
//        borderPane.setCenter(box, box2);
        borderPane.getChildren().addAll(box, box2);
        //Pane layout = new Pane();
        //layout.getChildren().addAll(box, box2);

        Scene scene = new Scene(borderPane, 600, 550);

        window.setScene(scene);
        window.show();

    }

}
