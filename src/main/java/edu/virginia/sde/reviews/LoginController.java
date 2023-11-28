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
    private TextField newUsernameField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private Label messageLabel, newAccountMessageLabel;

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

    @FXML
    private void createAccountButtonAction() {
        String username = newUsernameField.getText();
        String password = newPasswordField.getText();

        if (password.length() < 8) {
            newAccountMessageLabel.setText("Password is too short.");
            return;
        }

        //TODO: check if username exists in database
        boolean usernameExists = true;  //temp true

        if (usernameExists) {
            newAccountMessageLabel.setText("The username " + username + " is already in use. Try another username.");
            return;
        }

        //TODO: add username and password to database

        newAccountMessageLabel.setText("Account Created Successfully, Sign in Above.");
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
