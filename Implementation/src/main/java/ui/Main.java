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
        Parent root = FXMLLoader.load(new URL("file:/C:/Users/Maxi/Documents/Fontys_Venlo/Semester_3/PRJ3/Repository/prj3-2020-traffic-control-international-prj3-2020-group-05/Implementation/src/main/java/ui/Intersection.fxml"));
        Scene Intersections = new Scene(root);

        primaryStage.setTitle("Traffic");
        primaryStage.setScene(Intersections);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
