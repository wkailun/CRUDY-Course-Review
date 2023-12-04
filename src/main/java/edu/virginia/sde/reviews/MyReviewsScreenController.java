package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MyReviewsScreenController {

    @FXML
    private Label mainPageLabel;
    @FXML
    private Button backButton;
    @FXML
    private void backButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showCourseSearchScreen(stage);
        backButton.getScene().getWindow().hide();
    }

}
