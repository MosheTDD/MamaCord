package me.moshe.mamacord.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.moshe.mamacord.ui.controllers.LoginWindowController;

import java.io.IOException;

public class Interface extends Application {
    public static Stage window;
    public static LoginWindowController loginWindowController;

    public void start(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        openLoginWindow();
    }

    private void openLoginWindow() throws IOException{
        window.setTitle("MamaCord");
        window.setResizable(false);
        //window.getIcons().add(new Image("Imgs/Icon.ico"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginWindow.fxml"));
        Parent root = loader.load();
        loginWindowController = loader.getController();
        window.setScene(new Scene(root, 1440, 900));
        window.show();
    }

    public static LoginWindowController getLoginWindowController() {
        return loginWindowController;
    }

    public static void setLoginWindowController(LoginWindowController loginWindowController) {
        Interface.loginWindowController = loginWindowController;
    }
}
