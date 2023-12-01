// LoginController.java
package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScreenController {

    @FXML
    private TextField userid;
    @FXML
    private TextField passid;
    @FXML
    private Button loginbutton, registerbutton;

    @FXML
    private Label warninglabel;


    @FXML
    private void loginButtonAction() {
        String username = userid.getText();
        String password = passid.getText();

        if (isValidUser(username)) {
            if (isCorrectPassword(username, password)) {
                CourseReviewsApplication mainApp = new CourseReviewsApplication();
                Stage stage = new Stage();
                mainApp.showCourseSearchScreen(stage);
                loginbutton.getScene().getWindow().hide();
            }
            else{
                warninglabel.setText("Incorrect Username or Password.");
            }
        }
        else{
            warninglabel.setText("Username not Registered.");
        }
    }

    @FXML
    private void registerButtonAction() {
        try {
            String username = userid.getText();
            String password = passid.getText();

            if (isValidUser(username) && password.length() >= 8) {
                //TODO: add user to database
                warninglabel.setText("Account Registered.");
            }
            else if (isValidUser(username)) {
                warninglabel.setText("Password to short.");
            }
            else {
                warninglabel.setText("Username already Exists.");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isValidUser(String username) {
        //check for username in database
        if (username.equals("1234")) {         //temp
            return true;
        }

        return false;
    }

    private boolean isCorrectPassword(String username, String password) {
        //check is password is correct for username
        if (username.equals("1234") && password.equals("1234")) {         //temp
            return true;
        }

        return false;
    }

}