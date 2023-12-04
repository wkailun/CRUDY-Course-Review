package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class RegisterScreenController {
    @FXML
    private TextField userID;
    @FXML
    private TextField userPassword;
    @FXML
    private TextField confirmPassword;
    @FXML
    private Button registerButton;
    @FXML
    private Button backButton;
    @FXML
    private Label warningLabel;


    @FXML
    private void registerButtonAction() {
        String username = userID.getText();
        String password = userPassword.getText();
        String confirmPass = confirmPassword.getText();

        // username and password are valid
        if(validateUsername(username) & validatePassword(password) & confirmPass.equals(password)) {
            // add to database
            Student toRegisterStudent;
            toRegisterStudent = new Student(username, password);
            DatabaseController.registerNewLoginInformation(toRegisterStudent);

            warningLabel.setText("Account Registered!");
            PauseTransition pause = new PauseTransition(Duration.seconds(0.8));

            // Actions post pause
            pause.setOnFinished(event -> {
                // Return to login screen after the delay
                CourseReviewsApplication mainApp = new CourseReviewsApplication();
                Stage stage = new Stage();
                mainApp.showLoginScreen(stage);
                registerButton.getScene().getWindow().hide();
            });

            // start pause
            pause.play();

        } else if (!validateUsername(username)) {
            warningLabel.setText("Username is taken.");
        } else if (username.isEmpty()) {
            warningLabel.setText("Please enter a username.");
        } else if (password.isEmpty()) {
            warningLabel.setText("Please enter a password.");
        } else if (!validatePassword(password)) {
            warningLabel.setText("Passwords must be at least 8 characters long. Please try again!");
        } else if (!confirmPass.equals(password)) {
            warningLabel.setText("Passwords does not match. Please try again!");
        }
    }

    private boolean validateUsername(String username) {
        // Username already exists in database
        if(DatabaseController.checkUsernameExistence(username)) {
            return false;
        }
        return true;
    }

    private boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    @FXML
    private void backButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showLoginScreen(stage);
        backButton.getScene().getWindow().hide();
    }
}
