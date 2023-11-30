// LoginController.java
package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScreenController {

    @FXML
    private TextField userid;
    @FXML
    private TextField passid;
    @FXML
    private Button loginbutton;
    @FXML
    private Button registerbutton;

    @FXML
    private Label warninglabel;


    @FXML
    private void loginButtonAction() {
        String username = userid.getText();
        String password = passid.getText();

        if(!isValidUser(username, password)) {
            warninglabel.setText("get on a diet fat mf");
        }
        else{
            warninglabel.setText("");
        }
    }

    @FXML
    private void registerButtonAction() {
        try {
            //temporary send to review screen
            FXMLLoader fxmlLoader = new FXMLLoader(CourseReviewsApplication.class.getResource("CourseReviewsScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Review");
            stage.show();
            registerbutton.getScene().getWindow().hide();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isValidUser(String username, String password) {
        //check for unique username and 8 character minimum password
        return false;
    }

}