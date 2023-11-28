// LoginController.java
package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    private Stage primaryStage; // Reference to the stage

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    private void loginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Password Check
        if (isValidUser(username, password)) {
            openCourseSearchScreen();
        } else {
            messageLabel.setText("Invalid username or password.");
        }
    }

    private boolean isValidUser(String username, String password) {
        // TODO password authentication
        boolean verificationResult = true;

        return verificationResult;
    }

    private void openCourseSearchScreen() {
        MainFileApplication mainApp = new MainFileApplication();
        mainApp.showCourseSearchScreen(primaryStage);
    }
}
