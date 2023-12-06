package edu.virginia.sde.reviews;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static edu.virginia.sde.reviews.LoginScreenController.loggedStudentUsername;

public class CourseSearchScreenController {
    private static String mnemonic;
    private static int number;
    private static String title;
    public static String mnemonicPublic, titlePublic;
    public static int numberPublic;

    public TextField searchCourseTitle, searchCourseNumber, searchCourseMnemonic;
    
    @FXML
    private Label mainPageLabel;

    @FXML
    private Button myReviewsButton, courseReviewsButton, logoutButton, searchForCourseButton;
    @FXML
    private Label warningLabel;

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

    // THIS IS FOR ADDING A NEW COURSE
    @FXML
    private void searchForCourseButtonAction() {
        CourseReviewsApplication mainApp = new CourseReviewsApplication();
        Stage stage = new Stage();
        mainApp.showCourseSearchorAddScreen(stage);
        searchForCourseButton.getScene().getWindow().hide();
    }

    public void onSearchReviews(ActionEvent actionEvent) {
        List<Course> coursesList = DatabaseController.getAllCourses();
        List<ReviewedCoursesTable> existingCoursesToPopulateTable = new ArrayList<>();

        String mnemonicSearchTable = searchCourseMnemonic.getText().toUpperCase();
        String courseSearchTable = searchCourseNumber.getText();
        String titleSearchTable = searchCourseTitle.getText();

        List<CourseReviews> reviewsList = DatabaseController.getAllReviews();
        List<ReviewedCoursesTable> usersReviewTable = new ArrayList<>();

        if(mnemonicSearchTable.isEmpty() & courseSearchTable.isEmpty() & titleSearchTable.isEmpty()) {
            warningLabel.setText("Please populate at least one field to search.");

            for (var course : coursesList) {
                ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
                tempTable.setCourseNumber(course.getCatalogNumber());
                tempTable.setCourseMnemonic(course.getMnemonic());
                tempTable.setCourseTitle(course.getCourseTitle());

                String courseMnemonic = course.getMnemonic();
                int courseNum = course.getCatalogNumber();

                CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
                //tempTable.setCourseRating(reviews.getRating());
                tempTable.setCourseRating(reviews != null ? reviews.getRating() : 0);

                existingCoursesToPopulateTable.add(tempTable);
            }

        } else if(mnemonicSearchTable.isEmpty() & !courseSearchTable.isEmpty() & !titleSearchTable.isEmpty()) {


            for(var course : coursesList) {
                ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
                tempTable.setCourseNumber(course.getCatalogNumber());

                int courseCatalogNumberInteger = Integer.parseInt(courseSearchTable);
                if((course.getCatalogNumber() == courseCatalogNumberInteger) & titleSearchTable.equals(course.getCourseTitle())) {
                    tempTable.setCourseNumber(course.getCatalogNumber());
                    tempTable.setCourseMnemonic(course.getMnemonic());
                    tempTable.setCourseTitle(course.getCourseTitle());

                    String courseMnemonic = course.getMnemonic();
                    int courseNum = course.getCatalogNumber();

                    //CourseReviews courseSearch = DatabaseController.getCourseByMnemonicAndCourseNumber(mnemonicSearchTable.toUpperCase(),courseCatalogNumberInteger);
                    CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
                    tempTable.setCourseRating(reviews != null ? reviews.getRating() : 0);

                    existingCoursesToPopulateTable.add(tempTable);
                }
            }


        } else if(!mnemonicSearchTable.isEmpty() && courseSearchTable.isEmpty() && !titleSearchTable.isEmpty()) {

            for(var course : coursesList) {
                ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
                tempTable.setCourseNumber(course.getCatalogNumber());

                // Should search for matches on title substrings / exacts
                if((course.getMnemonic().equals(mnemonicSearchTable)) && (course.getCourseTitle().toLowerCase().contains(titleSearchTable.toLowerCase()))) {
                    tempTable.setCourseNumber(course.getCatalogNumber());
                    tempTable.setCourseMnemonic(course.getMnemonic());
                    tempTable.setCourseTitle(course.getCourseTitle());

                    String courseMnemonic = course.getMnemonic();
                    int courseNum = course.getCatalogNumber();

                    //CourseReviews courseSearch = DatabaseController.getCourseByMnemonicAndCourseNumber(mnemonicSearchTable.toUpperCase(),courseCatalogNumberInteger);
                    CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
                    tempTable.setCourseRating(reviews != null ? reviews.getRating() : 0);

                    existingCoursesToPopulateTable.add(tempTable);
                }
            }

        } else if(!mnemonicSearchTable.isEmpty() && !courseSearchTable.isEmpty() && titleSearchTable.isEmpty()) {

            for(var course : coursesList) {
                ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
                tempTable.setCourseNumber(course.getCatalogNumber());

                int courseCatalogNumberInteger = Integer.parseInt(courseSearchTable);
                if((course.getCatalogNumber() == courseCatalogNumberInteger) & mnemonicSearchTable.equals(course.getMnemonic())) {
                    tempTable.setCourseNumber(course.getCatalogNumber());
                    tempTable.setCourseMnemonic(course.getMnemonic());
                    tempTable.setCourseTitle(course.getCourseTitle());

                    String courseMnemonic = course.getMnemonic();
                    int courseNum = course.getCatalogNumber();

                    //CourseReviews courseSearch = DatabaseController.getCourseByMnemonicAndCourseNumber(mnemonicSearchTable.toUpperCase(),courseCatalogNumberInteger);
                    CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
                    tempTable.setCourseRating(reviews != null ? reviews.getRating() : 0);

                    existingCoursesToPopulateTable.add(tempTable);
                }
            }

        } else if(!mnemonicSearchTable.isEmpty() && !courseSearchTable.isEmpty() && !titleSearchTable.isEmpty()) {
            for(var course : coursesList) {
                ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
                tempTable.setCourseNumber(course.getCatalogNumber());

                int courseCatalogNumberInteger = Integer.parseInt(courseSearchTable);
                if((course.getCatalogNumber() == courseCatalogNumberInteger) & (mnemonicSearchTable.equals(course.getMnemonic())) & (course.getCourseTitle().toLowerCase().contains(titleSearchTable.toLowerCase()))) {
                    tempTable.setCourseNumber(course.getCatalogNumber());
                    tempTable.setCourseMnemonic(course.getMnemonic());
                    tempTable.setCourseTitle(course.getCourseTitle());

                    //CourseReviews courseSearch = DatabaseController.getCourseByMnemonicAndCourseNumber(mnemonicSearchTable.toUpperCase(),courseCatalogNumberInteger);
                    CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
                    tempTable.setCourseRating(reviews != null ? reviews.getRating() : 0);

                    existingCoursesToPopulateTable.add(tempTable);
                }
            }
        }
        else if(mnemonicSearchTable.isEmpty() && courseSearchTable.isEmpty() && !titleSearchTable.isEmpty()) {
            for(var course : coursesList) {
                ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
                tempTable.setCourseNumber(course.getCatalogNumber());

                if((course.getCourseTitle().toLowerCase().contains(titleSearchTable.toLowerCase()))) {
                    tempTable.setCourseNumber(course.getCatalogNumber());
                    tempTable.setCourseMnemonic(course.getMnemonic());
                    tempTable.setCourseTitle(course.getCourseTitle());

                    //CourseReviews courseSearch = DatabaseController.getCourseByMnemonicAndCourseNumber(mnemonicSearchTable.toUpperCase(),courseCatalogNumberInteger);
                    CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
                    tempTable.setCourseRating(reviews != null ? reviews.getRating() : 0);

                    existingCoursesToPopulateTable.add(tempTable);
                }
            }

        } else if(!mnemonicSearchTable.isEmpty() && courseSearchTable.isEmpty() && titleSearchTable.isEmpty()) {
            for(var course : coursesList) {
                ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
                tempTable.setCourseNumber(course.getCatalogNumber());

                if((mnemonicSearchTable.equals(course.getMnemonic()))) {
                    tempTable.setCourseNumber(course.getCatalogNumber());
                    tempTable.setCourseMnemonic(course.getMnemonic());
                    tempTable.setCourseTitle(course.getCourseTitle());

                    //CourseReviews courseSearch = DatabaseController.getCourseByMnemonicAndCourseNumber(mnemonicSearchTable.toUpperCase(),courseCatalogNumberInteger);
                    CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
                    tempTable.setCourseRating(reviews != null ? reviews.getRating() : 0);

                    existingCoursesToPopulateTable.add(tempTable);
                }
            }

        } else if(mnemonicSearchTable.isEmpty() && !courseSearchTable.isEmpty() && titleSearchTable.isEmpty()) {
            for(var course : coursesList) {
                ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
                tempTable.setCourseNumber(course.getCatalogNumber());

                int courseCatalogNumberInteger = Integer.parseInt(courseSearchTable);
                if((course.getCatalogNumber() == courseCatalogNumberInteger)) {
                    tempTable.setCourseNumber(course.getCatalogNumber());
                    tempTable.setCourseMnemonic(course.getMnemonic());
                    tempTable.setCourseTitle(course.getCourseTitle());

                    //CourseReviews courseSearch = DatabaseController.getCourseByMnemonicAndCourseNumber(mnemonicSearchTable.toUpperCase(),courseCatalogNumberInteger);
                    CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
                    tempTable.setAverageRating((double) (reviews != null ? reviews.getRating() : 0));

                    existingCoursesToPopulateTable.add(tempTable);
                }
            }

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
        courseRatingTable.setCellValueFactory(new PropertyValueFactory<>("courseAverageRating"));

    }
    // Have to have this reset the table
    @FXML
    private void resetTableOnAction() {
        List<Course> coursesList = DatabaseController.getAllCourses();
        List<ReviewedCoursesTable> existingCoursesToPopulateTable = new ArrayList<>();

        for (var course : coursesList) {
            ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
            tempTable.setCourseNumber(course.getCatalogNumber());
            tempTable.setCourseMnemonic(course.getMnemonic());
            tempTable.setCourseTitle(course.getCourseTitle());

            String courseMnemonic = course.getMnemonic();
            int courseNum = course.getCatalogNumber();

            CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
            //tempTable.setCourseRating(reviews.getRating());
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
        tableCourses.setOnMouseClicked(this::handleRowClick);
        setReviewItems(false);
    }
    public TableView tableCourses;
    public Button btnSubmit;

    @FXML
    public void initialize() {
        initializeTables();
    }
    public void initializeTables() {
        List<Course> coursesList = DatabaseController.getAllCourses();
        List<ReviewedCoursesTable> existingCoursesToPopulateTable = new ArrayList<>();

        for (var course : coursesList) {
            ReviewedCoursesTable tempTable = new ReviewedCoursesTable();
            tempTable.setCourseNumber(course.getCatalogNumber());
            tempTable.setCourseMnemonic(course.getMnemonic());
            tempTable.setCourseTitle(course.getCourseTitle());

            String courseMnemonic = course.getMnemonic();
            int courseNum = course.getCatalogNumber();

            CourseReviews reviews = DatabaseController.getCourseReviewFromMnemonicAndNumber(course);
            //tempTable.setCourseRating(reviews.getRating());
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
        tableCourses.setOnMouseClicked(this::handleRowClick);
        setReviewItems(false);
    }
    //    public static String mnemonicPublic, titlePublic;
    //    public static int numberPublic;
    private void handleRowClick(MouseEvent event) {
        if (event.getClickCount() == 1) {
            ReviewedCoursesTable selectedRow = (ReviewedCoursesTable) tableCourses.getSelectionModel().getSelectedItem();
            if (selectedRow != null) {
                //System.out.println("Clicked on row: " + selectedRow.getCourseTitle());
                mnemonicPublic = selectedRow.getCourseMnemonic();
                mnemonic = selectedRow.getCourseMnemonic();
                //System.out.println("Mnemonic: " + selectedRow.getCourseMnemonic());

                numberPublic = selectedRow.getCourseNumber();
                number = selectedRow.getCourseNumber();
                //System.out.println("number: " + selectedRow.getCourseNumber());

                titlePublic = selectedRow.getCourseTitle();
                title = selectedRow.getCourseTitle();
                //System.out.println("title: " + selectedRow.getCourseTitle());
                setReviewItems(true);
            }
        }
    }



    public void setReviewItems(boolean b) {
        courseReviewsButton.setVisible(b);
    }

    public static String getMnemonic() {
        return mnemonic;
    }
    public static void setMnemonic(String newMnemonic) { mnemonic = newMnemonic; }

    public static int getNumber() {
        return number;
    }
    public static void setNumber(int newNumber) { number = newNumber; }

    public static String getTitle() {
        return title;
    }
    public static void setTitle(String newTitle) { title = newTitle; }
}
