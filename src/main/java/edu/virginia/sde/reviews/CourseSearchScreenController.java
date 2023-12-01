package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CourseSearchScreenController {

    @FXML
    private Label mainPageLabel;

    @FXML
    private Button myReviewsButton, courseReviewsButton, logoutButton;

    @FXML
    private void logoutButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showLoginScreen(stage);
        logoutButton.getScene().getWindow().hide();
    }

    @FXML
    private void myReviewsButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showMyReviewsScreen(stage);
        myReviewsButton.getScene().getWindow().hide();
    }
    @FXML
    private void courseReviewsButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showCourseReviewsScreen(stage);
        courseReviewsButton.getScene().getWindow().hide();
    }


}
