package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

        if (!validateUsername(username) || !validatePassword(password)) {
            warningLabel.setText("Invalid Username and/or Password");
        }

        // Confirm passwords match
        else if (!confirmPass.equals(password)) {
            warningLabel.setText("Passwords does not match. Please try again!");
        }

        else {
            // TODO: Add user to the database
            warningLabel.setText("Account Registered.");

            CourseReviewsApplication mainApp = new CourseReviewsApplication();
            Stage stage = new Stage();
            mainApp.showCourseSearchScreen(stage);
            registerButton.getScene().getWindow().hide();
        }
    }

    private boolean validateUsername(String username) {
        // Check if the username is empty
        if (username.isEmpty()) {
            return false;
        }

        // TODO: Check if username exists in the database
        return true;
    }

    private boolean validatePassword(String password) {
        // Check if the password is empty
        if (password.isEmpty()) {
            return false;
        }

        else if (password.length() < 8) {
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
