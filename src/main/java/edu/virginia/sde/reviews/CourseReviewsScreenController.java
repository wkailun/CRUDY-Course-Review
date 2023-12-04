package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Import the correct Button class from JavaFX
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class CourseReviewsScreenController {
    @FXML
    private Label reviewTitle;
    @FXML
    private Label avgratingLabel;
    @FXML
    private Button addbutton, deletebutton, backbutton; // Use the correct Button class

    @FXML
    private void addButtonAction() {
        try {
            // temporary send to addreview screen
            FXMLLoader fxmlLoader = new FXMLLoader(CourseReviewsApplication.class.getResource("AddReviewScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("AddReview :3");
            stage.show();
            addbutton.getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteButtonAction() {
        //database remove reviews in my own tableview
        System.out.println("yippee");
    }
    @FXML
    private void backButtonAction() {
        try {
            //sends back to login page
            CourseReviewsApplication mainApp = new CourseReviewsApplication();
            Stage stage = new Stage();
            mainApp.showCourseSearchScreen(stage);
            backbutton.getScene().getWindow().hide();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
