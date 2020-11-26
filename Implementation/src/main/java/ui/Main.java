package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(new URL("Intersection.fxml"));
        Scene LogInScene = new Scene(root);

        primaryStage.setTitle("Traffic");
        primaryStage.setScene(LogInScene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
