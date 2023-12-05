package edu.virginia.sde.reviews;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Import the correct Button class from JavaFX
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

import static edu.virginia.sde.reviews.LoginScreenController.loggedStudentUsername;

public class CourseReviewsScreenController {
    @FXML
    private Label reviewTitle;
    @FXML
    private Label avgratingLabel;
    @FXML
    private Button addbutton, deletebutton, backbutton; // Use the correct Button class
    @FXML
    private TableView allCourseSpecReviews, myCourseSpecReviews, myReviewedCourses;

    @FXML
    public void initialize() {
        initializeTables();
    }
    public void initializeTables(){
        String mnemonic = CourseSearchScreenController.getMnemonic();
        int number = CourseSearchScreenController.getNumber();
        String title = CourseSearchScreenController.getTitle();
        String text =  mnemonic + " " + number + " " + title;
        System.out.println(text);
        reviewTitle.setText(text);

        //LATER CHANGE TO REVIEW LIST FOR A SPECIFIC COURSE REPRESENTED BY COURSETITLELABEL
        List<CourseReviews> courseSpecReviewsList = DatabaseController.getAllReviews();
        List<MyReviewsTable> courseSpecReviewsForTable = new ArrayList<>();

        for (CourseReviews review : courseSpecReviewsList) {
            MyReviewsTable tempTable = new MyReviewsTable();

            tempTable.setCourseTitle(review.getCourses().getCourseTitle());
            tempTable.setCourseNumber(review.getCourses().getCatalogNumber());
            tempTable.setCourseMnemonic(review.getCourses().getMnemonic());
            tempTable.setCourseRating(review.getRating());

            courseSpecReviewsForTable.add(tempTable);
        }

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

        ObservableList<MyReviewsTable> existingMyCourseSpecReviewsToPopulateList =
                FXCollections.observableArrayList(courseSpecReviewsForTable);
//        myCourseSpecReviews.setItems(existingMyCourseSpecReviewsToPopulateList);
        allCourseSpecReviews.setItems(existingMyCourseSpecReviewsToPopulateList);

        ObservableList<MyReviewsTable> existingMyReviewsToPopulateList =
                FXCollections.observableArrayList(existingMyReviewsToPopulateTable);
        myCourseSpecReviews.setItems(existingMyReviewsToPopulateList);

        configureTableColumn(myCourseSpecReviews, "Course Title", "courseTitle", String.class);
        configureTableColumn(myCourseSpecReviews,"Mnemonic", "courseMnemonic", String.class);
        configureTableColumn(myCourseSpecReviews,"Course Number", "courseNumber", Integer.class);
        configureTableColumn(myCourseSpecReviews,"Course Rating", "courseRating", Integer.class);

        configureTableColumn(allCourseSpecReviews, "Course Title", "courseTitle", String.class);
        configureTableColumn(allCourseSpecReviews,"Mnemonic", "courseMnemonic", String.class);
        configureTableColumn(allCourseSpecReviews,"Course Number", "courseNumber", Integer.class);
        configureTableColumn(allCourseSpecReviews,"Course Rating", "courseRating", Integer.class);

        //tableMyReviews.setOnMouseClicked(this::handleRowClick);


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

    private <T> void configureTableColumn(TableView table, String columnName, String propertyName, Class<T> propertyType) {
        TableColumn<MyReviewsTable, T> column = new TableColumn<>(columnName);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        table.getColumns().add(column);
    }

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
            //sends back to Course Search Screen page
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
