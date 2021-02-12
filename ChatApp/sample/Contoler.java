package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sk.kosickaakademia.app.Database;
import sk.kosickaakademia.app.Users;

import java.awt.event.ActionEvent;

public class Controller {
    @FXML
    private TextField txt_login;
    public PasswordField txt_pwd;
    public Label label_error;
    public Button login_button;

    public  void btn_click(ActionEvent ae){
        System.out.println("It works.");
        String login= txt_login.getText().trim();
        String pwd=txt_pwd.getText().trim();
        if (login.length()>0 && pwd.length()>0){
            Database db=new Database();
            Users users=db.loginUser(login, pwd);
            if (users==null){
                label_error.setVisible(true);
            }else{
                System.out.println("Logged.");
            }
        }
    }
}
