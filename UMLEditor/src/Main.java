import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import UMLEditor.Controller.Controller;

import java.awt.*;

public class Main extends Application {
    Stage window;
    Button button;

    Circle circle_red, circle_green;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    Point m_start = new Point(320, 20);
    Point m_end = new Point(440, 20);

    @Override
    public void start(Stage primaryStage)
    {

//        window = primaryStage;
//        window.setTitle("Test Window");
//        button = new Button("Click Me!");
//
//        //Create Circles
//        circle_red = new Circle(50.0f, Color.RED);
//        circle_red.setCursor(Cursor.OPEN_HAND);
//        circle_red.setCenterX(150);
//        circle_red.setCenterY(150);
//        circle_red.setOnMousePressed(circleOnMousePressedEventHandler);
//        circle_red.setOnMouseDragged(circleOnMouseDraggedEventHandler);
//
//        circle_green = new Circle(50.0f, Color.GREEN);
//        circle_green.setCursor(Cursor.OPEN_HAND);
//        circle_green.setCenterX(200);
//        circle_green.setCenterY(150);
//        circle_green.setOnMousePressed(circleOnMousePressedEventHandler);
//        circle_green.setOnMouseDragged(circleOnMouseDraggedEventHandler);
//
//        button.setAlignment(Pos.CENTER);
//        button.setOnAction(e -> {
//            boolean result = ConfirmBox.display();
//            //System.out.println(result);
//            if(result){
//                circle_red.setFill(Color.GREEN);
//            }else {
//                circle_red.setFill(Color.BLUE);
//            }
//        });
//
//        Group layout = new Group();
//        layout.getChildren().addAll(circle_red, circle_green, button);
//
//        Scene scene = new Scene(layout, 700, 650);
//        window.setResizable(false);
//        window.setScene(scene);
//        window.show();

        Group root = new Group();
        Scene scene = new Scene(root, 400, 350);
        primaryStage.setScene(scene);

        Group g = new Group();

        Line line = new Line();
        line.setStartX(10.0);
        line.setStartY(60.0);
        line.setEndX(300.0);
        line.setEndY(60.0);
        line.setStrokeWidth(3.0);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
                300.0, 60.0,
                320.0, 45.0,
                340.0, 60.0,
                320.0, 75.0
        });

        g.getChildren().addAll(polygon, line);

        scene.setRoot(g);
        primaryStage.show();

    }

//    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
//            new EventHandler<MouseEvent>()
//            {
//                @Override
//                public void handle(MouseEvent event)
//                {
//                    orgSceneX = event.getSceneX();
//                    orgSceneY = event.getSceneY();
//                    //Typecasting Circle to the event
//                    orgTranslateX = ((Circle)(event.getSource())).getTranslateX();
//                    orgTranslateY = ((Circle)(event.getSource())).getTranslateY();
//                }
//            };
//
//    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
//            new EventHandler<MouseEvent>()
//            {
//                @Override
//                public void handle(MouseEvent event)
//                {
//                    double offsetX = event.getSceneX() - orgSceneX;
//                    double offsetY = event.getSceneY() - orgSceneY;
//                    double newTranslateX = orgTranslateX + offsetX;
//                    double newTranslateY = orgTranslateY + offsetY;
//
//                    ( (Circle)(event.getSource()) ).setTranslateX(newTranslateX);
//                    ( (Circle)(event.getSource()) ).setTranslateY(newTranslateY);
//
//                }
//            };


    public static void main(String[] args) {
        launch(args);
    }
}
