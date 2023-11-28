// MainPageController.java
package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    private Label mainPageLabel;

    private Stage primaryStage; // Reference to the primary stage

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void logoutButtonAction() {
        MainFileApplication mainApp = new MainFileApplication();
        mainApp.showLoginScreen(primaryStage);
    }
}
