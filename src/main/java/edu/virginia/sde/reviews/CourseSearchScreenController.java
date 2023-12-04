package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CourseSearchScreenController {

    @FXML
    private Label mainPageLabel;

    @FXML
    private Button myReviewsButton, courseReviewsButton, logoutButton, searchForCourseButton;

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
    // Both add and search actions are linked to the same button, its actions defined below
    // Their separate purposes are handled in a separate class called "CourseSearchorAddController"
    @FXML
    private void searchForCourseButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showCourseSearchorAddScreen(stage);
        searchForCourseButton.getScene().getWindow().hide();
    }
    // Have to have this reset the table
    @FXML
    private void resetTableOnAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showCourseSearchorAddScreen(stage);
        searchForCourseButton.getScene().getWindow().hide();
    }
}
