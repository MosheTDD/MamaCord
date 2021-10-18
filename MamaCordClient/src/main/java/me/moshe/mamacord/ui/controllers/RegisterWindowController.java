package me.moshe.mamacord.ui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import me.moshe.mamacord.util.InputCheck;
import me.moshe.mamacord.util.Scenes;
import me.moshe.mamacord.util.SwitchScenes;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterWindowController implements Initializable {

    @FXML public AnchorPane anchorPane;
    @FXML public Button backButton, registerButton;
    @FXML public TextField emailTextField, usernameTextField;
    @FXML public PasswordField passwordField;
    @FXML public Label emailErrorLabel, usernameErrorLabel, passwordErrorLabel;

    public static String usernameReg, passReg, emailReg;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchScenes.RequestFocus(anchorPane);
    }

    @FXML
    public void switchToPreviousScene(){
        SwitchScenes.switchScene(Scenes.PREVIOUS);
        SwitchScenes.setPreviousScene(Scenes.REGISTER_WINDOW);
    }

    @FXML
    public void checkFields(){
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        String email = emailTextField.getText();
        if (usernameTextField.isFocused())
            usernameErrorLabel.setText(InputCheck.checkUsernameReg(username));
        if (passwordField.isFocused())
            passwordErrorLabel.setText(InputCheck.checkPassReg(password));
        if (emailTextField.isFocused())
            emailErrorLabel.setText(InputCheck.checkEmailReg(email));
    }

    @FXML
    public void register(){
        usernameReg = usernameTextField.getText();
        passReg = passwordField.getText();
        emailReg = emailTextField.getText();
        System.out.println(usernameReg + " " + passReg + " " + emailReg);
    }
}
