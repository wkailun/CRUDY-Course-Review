package edu.virginia.sde.reviews;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static edu.virginia.sde.reviews.LoginScreenController.loggedStudentUsername;


public class MyReviewsScreenController {

    @FXML
    private Button backButton, viewReviewButton;

    public TableView<MyReviewsTable> tableMyReviews;


    @FXML
    private void initialize() {
        List<CourseReviews> reviewsList = DatabaseController.getAllReviewsByStudentName(loggedStudentUsername);

        List<MyReviewsTable> existingMyReviewsToPopulateTable = new ArrayList<>();

        for (CourseReviews review : reviewsList) {
            MyReviewsTable tempTable = new MyReviewsTable();

            tempTable.setCourseTitle(review.getCourses().getCourseTitle());
            tempTable.setCourseNumber(review.getCourses().getCatalogNumber());
            tempTable.setCourseMnemonic(review.getCourses().getMnemonic());
            tempTable.setCourseRating(review.getRating());

            existingMyReviewsToPopulateTable.add(tempTable);
        }

        ObservableList<MyReviewsTable> existingMyReviewsToPopulateList =
                FXCollections.observableArrayList(existingMyReviewsToPopulateTable);
        tableMyReviews.setItems(existingMyReviewsToPopulateList);

        configureTableColumn("Course Title", "courseTitle");
        configureTableColumn("Mnemonic", "courseMnemonic");
        configureTableColumn("Course Number", "courseNumber");
        configureTableColumn("Course Rating", "courseRating");

        tableMyReviews.setOnMouseClicked(this::handleRowClick);
    }



    private <T> void configureTableColumn(String columnName, String propertyName) {
        TableColumn<MyReviewsTable, T> column = new TableColumn<>(columnName);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        tableMyReviews.getColumns().add(column);
    }
    private void handleRowClick(MouseEvent event) {
        if (event.getClickCount() == 1) {
            MyReviewsTable selectedRow = tableMyReviews.getSelectionModel().getSelectedItem();
            if (selectedRow != null) {
                CourseSearchScreenController.setMnemonic(selectedRow.getCourseMnemonic());
                CourseSearchScreenController.setNumber(selectedRow.getCourseNumber());
                CourseSearchScreenController.setTitle(selectedRow.getCourseTitle());
            }
        }
    }

    @FXML
    private void backButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showCourseSearchScreen(stage);
        backButton.getScene().getWindow().hide();
    }


    @FXML
    private void viewReviewButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showCourseReviewsScreen(stage);
        viewReviewButton.getScene().getWindow().hide();
    }
}