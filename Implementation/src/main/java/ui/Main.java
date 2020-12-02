package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lights.StraightTrafficLight;
import lights.StraightTrafficLightObserver;
import lights.StraightTrafficLightObserverStandard;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Intersection.fxml"));
        Scene Intersections = new Scene(root);

        primaryStage.setTitle("Traffic");
        primaryStage.setScene(Intersections);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
