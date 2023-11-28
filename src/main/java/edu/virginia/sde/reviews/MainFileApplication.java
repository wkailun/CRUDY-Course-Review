package edu.virginia.sde.reviews;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFileApplication extends Application {
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

    void showMainPageScreen(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Main Page");
            stage.setScene(scene);

            //same thing
            MainPageController mainPageController = fxmlLoader.getController();
            mainPageController.setPrimaryStage(stage);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
