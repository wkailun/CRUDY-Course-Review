// LoginController.java
package edu.virginia.sde.reviews;

import javafx.fxml.FXML;
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
    }



    private boolean isValidUser(String username, String password) {
        //check for unique username and 8 character minimum password
        return false;
    }

}