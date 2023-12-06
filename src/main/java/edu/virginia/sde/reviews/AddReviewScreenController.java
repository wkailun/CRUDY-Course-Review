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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import static edu.virginia.sde.reviews.LoginScreenController.loggedStudentUsername;
import static edu.virginia.sde.reviews.CourseSearchScreenController.mnemonicPublic;
import static edu.virginia.sde.reviews.CourseSearchScreenController.titlePublic;
import static edu.virginia.sde.reviews.CourseSearchScreenController.numberPublic;

public class AddReviewScreenController {
    @FXML
    private Button submitButton;
    @FXML
    private TextField ratingText, commentText;
    @FXML
    private Label warninglabel;

    @FXML
    private void submitButtonAction() {
        String rating = ratingText.getText();
        String comment = commentText.getText();

        if(!(rating.equals("1") || rating.equals("2") || rating.equals("3") || rating.equals("4") || rating.equals("5"))) {
            warninglabel.setText("Rating must be an integer between 1 and 5");
            return;
        }

        int ratingToInt = Integer.parseInt(rating);
        Course tempCourse = new Course(mnemonicPublic, numberPublic, titlePublic);
        DatabaseController.registerNewCourse(tempCourse);
        Student tempStudent = DatabaseController.getStudentFromUsername(loggedStudentUsername);
        CourseReviews tempReview = new CourseReviews(tempStudent, tempCourse, comment, ratingToInt);

        // Also, need to check that the user has not already submitted a review for this class
        // Needs username component
        DatabaseController.registerStudentReview(tempReview);


        try {
            //temporary send to review screen
            System.out.println(comment);
            FXMLLoader fxmlLoader = new FXMLLoader(CourseReviewsApplication.class.getResource("AddReviewScreen.fxml"));

            CourseReviewsApplication mainApp = new CourseReviewsApplication();
            //Stage stage = (Stage) submitButton.getScene().getWindow();
            Stage stage = new Stage();
            mainApp.showCourseReviewsScreen(stage);
            submitButton.getScene().getWindow().hide();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}