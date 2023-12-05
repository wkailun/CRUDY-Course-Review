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

import java.util.List;

public class LoginScreenController {

    @FXML
    private TextField userid;
    @FXML
    private TextField passid;
    @FXML
    private Button loginbutton, registerbutton;

    @FXML
    private Label warninglabel;


    // Current assumption: Usernames are case-sensitive, so "Hugo" is not the same username as "hugo"
    // Login info ( you can either create a new one or you can use the following):
    // Username: Hugo
    // Password: 12345678
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
            } else if (username.isEmpty()){
                warninglabel.setText("Please enter a valid username.");
            } else if (password.isEmpty()) {
                warninglabel.setText("Please enter a password.");
            } else if (!isCorrectPassword(username, password)) {
                warninglabel.setText("Incorrect password.");
            }
        } else if (username.isEmpty() & !password.isEmpty()) {
            warninglabel.setText("Please enter a username.");
            printDatabaseContents();
        }
        else{
            warninglabel.setText("Invalid Username or Password.");
        }
    }

    public void printDatabaseContents() {
        System.out.println("\nCourses:");
        List<Course> courses = DatabaseController.getAllCourses();
        for (Course course : courses) {
            System.out.println(course);
        }

        System.out.println("\nCourse Reviews:");
        List<CourseReviews> reviews = DatabaseController.getAllReviews();
        for (CourseReviews review : reviews) {
            System.out.println(review);
        }
    }
    @FXML
    private void registerButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showRegisterScreen(stage);
        registerbutton.getScene().getWindow().hide();
    }

    private boolean isValidUser(String username) {
        return DatabaseController.checkUsernameExistence(username);
    }

    private boolean isCorrectPassword(String username, String password) {
        return DatabaseController.checkUserExistence(username, password);
    }

}