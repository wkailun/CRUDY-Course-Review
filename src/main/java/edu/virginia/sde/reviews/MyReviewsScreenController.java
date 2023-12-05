package edu.virginia.sde.reviews;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MyReviewsScreenController {

    @FXML
    private Button backButton;

    public TableView tableMyReviews;

    @FXML
    private void initialize() {

        List<CourseReviews> reviewsList = DatabaseController.getAllReviews();

        List<MyReviewsTable> existingMyReviewsToPopulateTable = new ArrayList<>();

        for (CourseReviews review : reviewsList) {
            MyReviewsTable tempTable = new MyReviewsTable();

            tempTable.setCourseTitle(review.getCourses().getCourseTitle());
            tempTable.setCourseNumber(review.getCourses().getID());
            tempTable.setCourseMnemonic(review.getCourses().getMnemonic());
            tempTable.setCourseRating(review.getRating());
            tempTable.setReviewMessage(review.getMessage());


            existingMyReviewsToPopulateTable.add(tempTable);
        }

        ObservableList<MyReviewsTable> existingMyReviewsToPopulateList =
                FXCollections.observableArrayList(existingMyReviewsToPopulateTable);
        tableMyReviews.setItems(existingMyReviewsToPopulateList);

        TableColumn<MyReviewsTable, String> courseTitleTable = new TableColumn<>("Course Title");
        courseTitleTable.setCellValueFactory(new PropertyValueFactory<>("CourseTitle"));

        TableColumn<MyReviewsTable, String> courseMnemonicTable = new TableColumn<>("Mnemonic");
        courseMnemonicTable.setCellValueFactory(new PropertyValueFactory<>("Mnemonic"));

        TableColumn<MyReviewsTable, Integer> courseCatalogNumberTable = new TableColumn<>("Course Number");
        courseCatalogNumberTable.setCellValueFactory(new PropertyValueFactory<>("CourseCatalogNumber"));

        TableColumn<MyReviewsTable, Integer> courseRatingTable = new TableColumn<>("Course Rating");
        courseRatingTable.setCellValueFactory(new PropertyValueFactory<>("CourseRating"));

        TableColumn<MyReviewsTable, String> courseMessageTable = new TableColumn<>("Rating Message");
        courseMessageTable.setCellValueFactory(new PropertyValueFactory<>("RatingMessage"));

        tableMyReviews.getColumns().setAll(courseTitleTable, courseMnemonicTable, courseCatalogNumberTable, courseRatingTable, courseMessageTable);
    }


    private void configureTableColumn(String columnName, String propertyName, Class<?> propertyType) {
        TableColumn<ReviewedCoursesTable, ?> column = new TableColumn<>(columnName);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        tableMyReviews.getColumns().add(column);
    }


    @FXML
    private void backButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showCourseSearchScreen(stage);
        backButton.getScene().getWindow().hide();
    }

}
