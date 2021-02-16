package sk.kosickaakademia.mizak.chatapp.sample;

import sk.kosickaakademia.mizak.chatapp.entity.Users;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class ChatController {
    public Label lbl_login;
    private Users users;

    public ChatController(){
        System.out.println("Success.");
    }

    public void logout(MouseEvent mouseEvent) {
    }

    public void setUser(Users users){
        this.users = users;
    }

    public void initLoginName() {
        lbl_login.setText(users.getLogin());
    }
}
