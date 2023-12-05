package edu.virginia.sde.reviews;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CourseSearchorAddController {
    public Button btnLogOff;
    public TableView tblCourses;
    public Label warningLabel;
    public Button btnSubmit;
    public Label lblRating;
    public Label lblMessage;
    @FXML
    public Button addCourseButton, searchForCourseButton;
    public TextField textMnemonic, textCourseCatalogNumber, textCourseTitle;
    @FXML
    private String username;
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

    public void onAddCourse(ActionEvent actionEvent) {
        String courseMnemonic = textMnemonic.getText();
        String courseCatalog = textCourseCatalogNumber.getText();
        String courseAddTitle = textCourseTitle.getText();

        String warning = "";
        if (courseMnemonic.length() == 0) {
            warningLabel.setText("A course mnemonic is required.");
        } else if(!courseMnemonic.matches("[a-zA-Z]+")) {
            warning = "Course mnemonic must be characters.";
            warningLabel.setText(warning);
        }
        else if (courseMnemonic.length() > 4) {
            warning = "Course mnemonic should be no more than 4 characters.";
            warningLabel.setText(warning);
        }
        else if (courseMnemonic.length() < 2) {
            warning = "Course mnemonic should contain at least two characters.";
            warningLabel.setText(warning);
        }
        else if (courseCatalog.length() == 0) {
            warning = "Missing course catalog number.";
            warningLabel.setText(warning);
        } else if (!courseCatalog.matches("\\d+")) {
            warning = "Course catalog must made up of integers.";
            warningLabel.setText(warning);
        }
        else if (courseCatalog.length() != 4) {
            warning = "Catalog number must be four digits long.";
            warningLabel.setText(warning);
        } else if (!courseAddTitle.matches("[a-zA-Z]+")) {
            warning = "Course title must be made up of characters.";
            warningLabel.setText(warning);
        }else if (courseAddTitle.length() < 1) {
            warning = "Course title may not be empty.";
            warningLabel.setText(warning);
        } else if (courseAddTitle.length() > 50) {
            warning = "Course title must not exceed 50 characters.";
            warningLabel.setText(warning);
        } else {
            Course tempCourse = new Course();
            tempCourse.setMnemonic(courseMnemonic);
            tempCourse.setCatalogNumber(Integer.parseInt(courseCatalog));
            tempCourse.setCourseTitle(courseAddTitle);
            DatabaseController.registerNewCourse(tempCourse);

            //initUsername(username);
            textMnemonic.setText("");
            textCourseCatalogNumber.setText("");
            textCourseTitle.setText("");
            warningLabel.setText("New course added!");


            // Return to course search screen after the delay
            CourseReviewsApplication mainApp = new CourseReviewsApplication();
            Stage stage = new Stage();
            mainApp.showCourseSearchScreen(stage);
            addCourseButton.getScene().getWindow().hide();

        }
    }

    // This has to update the search screen table -- which still have no clue what to do
    @FXML
    private void onSearchForCourse(ActionEvent actionEvent) {
        // Currently buliding out as I ignore course search screen

        String courseMnemonic = textMnemonic.getText();
        String courseCatalog = textCourseCatalogNumber.getText();
        String courseAddTitle = textCourseTitle.getText();

        String warning = "";
        if(courseMnemonic.length() == 0 & courseCatalog.length() == 0 & courseAddTitle.length() == 0) {
            warning = "Please populate at least one field.";
            warningLabel.setText(warning);
        }
    }
}
