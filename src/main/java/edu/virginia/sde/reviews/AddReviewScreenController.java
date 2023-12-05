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

        //add to database to use later in review screen controller
        //TODO
        CourseReviews tempReview = new CourseReviews();
        tempReview.setMessage(comment);
        tempReview.setRating(Integer.parseInt(rating));
        // Also, need to check that the user has not already submitted a review for this class
        // Needs username component
        DatabaseController.registerStudentReview(tempReview);


        try {
            //temporary send to review screen
            System.out.println(comment);
            FXMLLoader fxmlLoader = new FXMLLoader(CourseReviewsApplication.class.getResource("AddReviewScreen.fxml"));

            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }


}
