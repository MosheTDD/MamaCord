package me.moshe.mamacord.ui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import me.moshe.mamacord.util.Scenes;
import me.moshe.mamacord.util.SwitchScenes;

import java.net.URL;
import java.util.ResourceBundle;

;

public class LoginWindowController implements Initializable {

    @FXML public AnchorPane anchorPane;
    @FXML public TextField usernameTextField;
    @FXML public PasswordField passwordField;
    @FXML public Button loginButton, registerButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SwitchScenes.RequestFocus(anchorPane);
    }

    @FXML
    public void switchToRegisterScene(){
        SwitchScenes.switchScene(Scenes.REGISTER_WINDOW);
        SwitchScenes.setPreviousScene(Scenes.LOGIN_WINDOW);
    }
}
