package edu.virginia.sde.reviews;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CourseReviewsApplication extends Application {


    public void start(Stage primaryStage) {
        showLoginScreen(primaryStage);

        if(DatabaseController.getAllCourses().size() == 0){
            initDB();
        }

    }

    void showLoginScreen(Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Login Screen");
            newStage.setScene(scene);

            // Hide the current stage
            currentStage.hide();

            // Show the new stage
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showRegisterScreen(Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Register Screen");
            newStage.setScene(scene);

            currentStage.hide();
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initDB() {
        Student dummyStudent;
        Student dummyStudent2;
        Student dummyStudent3;
        Student dummyStudent4;
        Student dummyStudent5;
        dummyStudent = new Student("Hugo", "12345678");
        dummyStudent2 = new Student("Marietta", "22222222");
        dummyStudent3 = new Student("Philip", "87654321");
        dummyStudent4 = new Student("Jeanna", "12341234");
        dummyStudent5 = new Student("Brooke", "12345678");

        DatabaseController.registerNewLoginInformation(dummyStudent);
        DatabaseController.registerNewLoginInformation(dummyStudent2);
        DatabaseController.registerNewLoginInformation(dummyStudent3);
        DatabaseController.registerNewLoginInformation(dummyStudent4);
        DatabaseController.registerNewLoginInformation(dummyStudent5);

        Course dummyCourse;
        Course dummyCourse2;
        Course dummyCourse3;
        Course dummyCourse4;
        dummyCourse = new Course("CS", 3140, "Software Development Essentials");
        dummyCourse2 = new Course("APMA", 3100, "Probability");
        dummyCourse3 = new Course("ECE", 2700, "Signals & Systems");
        dummyCourse4 = new Course("PHIL", 2200, "Intro to Philosophy");

        DatabaseController.registerNewCourse(dummyCourse);
        DatabaseController.registerNewCourse(dummyCourse2);
        DatabaseController.registerNewCourse(dummyCourse3);
        DatabaseController.registerNewCourse(dummyCourse4);

        CourseReviews r1;
        CourseReviews r2;
        CourseReviews r3;
        CourseReviews r4;
        CourseReviews r11;
        CourseReviews r12;
        r1 = new CourseReviews(dummyStudent, dummyCourse, "Learned a lot. Lots of time spent on this class.", 4);
        r2 = new CourseReviews(dummyStudent2, dummyCourse2, "This class was really hard. Professor did not really teach, either.", 1);
        r3 = new CourseReviews(dummyStudent3, dummyCourse3, "AWESOME CLASS!!! You should take it!!!", 5);
        r4 = new CourseReviews(dummyStudent4, dummyCourse4, "Explored things I never would have thought I would - considering philosophy major now, in fact.", 5);
        r11 = new CourseReviews(dummyStudent5, dummyCourse, "I don't think I'm cut out for programming. I found this class really hard, and I'm not sure why. I think I enjoy theory more than practice.", 2);
        r12 = new CourseReviews(dummyStudent, dummyCourse2, "This class was hard but was pretty intuitive.", 3);

        DatabaseController.registerStudentReview(r1);
        DatabaseController.registerStudentReview(r2);
        DatabaseController.registerStudentReview(r3);
        DatabaseController.registerStudentReview(r4);
        DatabaseController.registerStudentReview(r11);
        DatabaseController.registerStudentReview(r12);
    }


    void showCourseSearchScreen(Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseSearchScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Course Search Screen");
            newStage.setScene(scene);

            currentStage.hide();
            newStage.show();

            //CourseSearchScreenController controller = fxmlLoader.getController();
            //controller.initializeTables();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showCourseReviewsScreen(Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseReviewsScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Course Reviews Screen");
            newStage.setScene(scene);

            currentStage.hide();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showCourseSearchorAddScreen(Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseSearchorAddScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Create a new stage
            Stage newStage = new Stage();
            newStage.setTitle("Search or Add Screen");
            newStage.setScene(scene);

            currentStage.hide();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showMyReviewsScreen(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyReviewsScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("My Reviews Screen");
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
