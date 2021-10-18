package me.moshe.mamacord.util;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import me.moshe.mamacord.ui.Interface;

import java.io.IOException;

public class SwitchScenes {

    private static Scenes previous;

    private static Scene scene;

    public static void switchScene(Scenes scene){
        switch (scene){
            case LOGIN_WINDOW:
                switchScene("/view/LoginWindow.fxml");
                break;
            case REGISTER_WINDOW:
                switchScene("/view/RegisterWindow.fxml");
                break;
            case CHAT_WINDOW:
                switchScene("/view/ChatWindow.fxml");
                break;
            case SETTINGS_WINDOW:
                switchScene("/view/SettingsWindow.fxml");
            case PREVIOUS:
                switchScene(previous);
                break;
        }
    }

    private static void switchScene(String fxmlFile){
        try{
            Parent root = FXMLLoader.load(SwitchScenes.class.getResource(fxmlFile));
            scene = new Scene(root, 1440, 900);
            Interface.window.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Scene getScene() {
        return scene;
    }

    public static void RequestFocus(AnchorPane anchorPane){
        Platform.runLater(anchorPane::requestFocus);
    }

    public static void setPreviousScene(Scenes scene){
        previous = scene;
    }

}
