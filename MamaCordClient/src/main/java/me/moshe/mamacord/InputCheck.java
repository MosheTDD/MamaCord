package me.moshe.mamacord;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class InputCheck {

    static EventHandler<KeyEvent> consume = Event::consume;
    public static String checkUsernameReg(String username){
        if(username.isBlank() || username.isEmpty()) return "Username can't be empty!";
        if(username.length() > 10){
            SwitchScenes.getScene().addEventFilter(KeyEvent.KEY_TYPED, consume);
            return  "Username need to be 10 characters or below!";
        }else SwitchScenes.getScene().removeEventFilter(KeyEvent.KEY_TYPED, consume);
        if(checkNumbers(username)) return "Username can't include only numbers!";
        if(checkForBlackList(username)) return "No bad words allowed!";
        if(username.contains(" ")) return  "No spaces allowed!";
        return "";
    }

    public static String checkPassReg(String password){
        if(password.length() <= 5 || password.length() >= 20) return  "Password needs to be above 5 and below 20 characters!";
        return "";
    }

    private static boolean checkForBlackList(String s){
        String[] words = {"dick", "shit", "fuck", "bitch"};
        for (String word : words)
            if (s.toLowerCase().contains(word)) return true;
        return false;
    }

    private static boolean checkNumbers(String s){
        return s.matches("^[0-9]+$");
    }
}
