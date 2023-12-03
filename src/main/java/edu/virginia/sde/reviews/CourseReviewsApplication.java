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

    void showLoginScreen(Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Login Screen");
            newStage.setScene(scene);

            // Hide the current stage
            currentStage.hide();

            // Show the new stage
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showRegisterScreen(Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Register Screen");
            newStage.setScene(scene);

            currentStage.hide();
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showCourseSearchScreen(Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseSearchScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Course Search Screen");
            newStage.setScene(scene);

            currentStage.hide();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showCourseReviewsScreen(Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseReviewsScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Course Reviews Screen");
            newStage.setScene(scene);

            currentStage.hide();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showCourseSearchorAddScreen(Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseSearchorAddScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Search or Add Screen");
            newStage.setScene(scene);

            currentStage.hide();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showMyReviewsScreen(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyReviewsScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("My Reviews Screen");
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
