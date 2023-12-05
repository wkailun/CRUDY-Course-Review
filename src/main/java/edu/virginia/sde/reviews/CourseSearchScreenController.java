package edu.virginia.sde.reviews;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

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
    public TableView tableCourses;
    public Button btnSubmit;

    @FXML
    public void initialize() {
        initializeTables();
    }
    public void initializeTables(){
        List<Course> coursesList = DatabaseController.getAllCourses();
        List<ReviewedCoursesTable> existingCoursesToPopulateTable = new ArrayList<>();

        for(var course: coursesList) {
            ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
            tempTable.setCourseNumber(course.getCatalogNumber());
            tempTable.setCourseMnemonic(course.getMnemonic());
            tempTable.setCourseTitle(course.getCourseTitle());

            String courseMnemonic = course.getMnemonic();
            int courseNum = course.getID();

            CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
            tempTable.setCourseRating(reviews != null ? reviews.getRating() : 0);

            existingCoursesToPopulateTable.add(tempTable);
        }

        ObservableList<ReviewedCoursesTable> existingCoursesToPopulateList = FXCollections.observableArrayList(existingCoursesToPopulateTable);
        tableCourses.setItems(existingCoursesToPopulateList);

        TableColumn<ReviewedCoursesTable, String> courseTitleTable = new TableColumn<>("Course Title");
        courseTitleTable.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));

        TableColumn<ReviewedCoursesTable, String> courseMnemonicTable = new TableColumn<>("Mnemonic");
        courseMnemonicTable.setCellValueFactory(new PropertyValueFactory<>("courseMnemonic"));

        TableColumn<ReviewedCoursesTable, Integer> courseCatalogNumberTable = new TableColumn<>("Course Number");
        courseCatalogNumberTable.setCellValueFactory(new PropertyValueFactory<>("courseNumber"));

        TableColumn<ReviewedCoursesTable, Integer> courseRatingTable = new TableColumn<>("Course Rating");
        courseRatingTable.setCellValueFactory(new PropertyValueFactory<>("courseRating"));

        tableCourses.getColumns().setAll(courseTitleTable, courseMnemonicTable, courseCatalogNumberTable, courseRatingTable);


/*        tblCourses.getFocusModel().focusedCellProperty().addListener(
                new ChangeListener<TablePosition>() {
                    @Override
                    public void changed(ObservableValue<? extends TablePosition> observable,
                                        TablePosition oldPos, TablePosition pos) {
                        int row = pos.getRow();
                        Object obj = tblCourses.getFocusModel().getFocusedItem();
                        CourseReviewTable tmp = (CourseReviewTable)obj;
                        assert tmp != null;
                        if(tmp.getMessage() == null){
                            btnSubmit.setDisable(false);
                            txtReviewMessage.setDisable(false);
                            txtRating.setDisable(false);
                            txtRating.setText("");
                            txtReviewMessage.setText("");
                            return;
                        } else {
                            txtReviewMessage.setDisable(true);
                            txtRating.setDisable(true);
                            btnSubmit.setDisable(true);
                        }
                        txtReviewMessage.setText(tmp.getMessage());
                        txtRating.setText(Integer.toString(tmp.getRating()));

                        setReviewItems(false);
                    }
                });
        setReviewItems(false);*/
    }
}
