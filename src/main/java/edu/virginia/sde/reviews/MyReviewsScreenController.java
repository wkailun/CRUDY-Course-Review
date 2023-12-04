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


public class MyReviewsScreenController {

    @FXML
    private Label mainPageLabel;
    @FXML
    private Button backButton;

    @FXML
    private TableView<CourseReviews> myReviewsTable;
    @FXML
    private TableColumn<CourseReviews, String> courseMnemonicColumn, messageColumn;
    @FXML
    private TableColumn<CourseReviews, Integer> courseNumberColumn, ratingColumn;


    @FXML
    private void initialize() {
        // Initialize TableView columns
        courseNumberColumn.setCellValueFactory(new PropertyValueFactory<>("courses.catalogNumber"));
        courseMnemonicColumn.setCellValueFactory(new PropertyValueFactory<>("courses.Mnemonic"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        messageColumn.setCellValueFactory(new PropertyValueFactory<>("message"));

        // Load data into TableView
        ObservableList<CourseReviews> reviewsList = FXCollections.observableArrayList(
                DatabaseController.getAllReviewsByStudentName("YourStudentName")
        );
        myReviewsTable.setItems(reviewsList);
    }



    @FXML
    private void backButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showCourseSearchScreen(stage);
        backButton.getScene().getWindow().hide();
    }

}
