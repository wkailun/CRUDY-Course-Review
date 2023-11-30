package edu.virginia.sde.reviews;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class CourseReviewsApplication extends Application {
    public void start(Stage primaryStage) {
        showLoginScreen(primaryStage);
    }

    void showLoginScreen(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(scene);

            // Access the controller if needed:idk yet
            LoginController loginController = fxmlLoader.getController();
            loginController.setPrimaryStage(stage);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showCourseSearchScreen(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseSearchScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Course Search Screen");
            stage.setScene(scene);

            //same thing
            CourseSearchScreenController CourseSearchScreenController = fxmlLoader.getController();
            CourseSearchScreenController.setPrimaryStage(stage);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
