package sk.kosickaakademia.mizak.chatapp.sample;

import sk.kosickaakademia.mizak.chatapp.database.Database;
import sk.kosickaakademia.mizak.chatapp.entity.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private TextField txt_login;
    public PasswordField txt_password;
    public Label lbl_error;
    public Button btn_login;
//-----------------------------------------------------------------------------------
    public void btn_click(ActionEvent actionEvent) {
        System.out.println("Hello! It works!");
        String login = txt_login.getText().trim();
        String password = txt_password.getText().trim();
        if(login.length()>0 && password.length()>0){
            Database db = new Database();
            Users users = db.loginUser(login,password);
            if(users ==null){
                lbl_error.setVisible(true);
            }else{
                System.out.println("You are logged!");
                openMainForm(users);
            }
        }
    }
//---------------------------------------------------------------------------
    private void openMainForm(Users users) {
        try {
            //FXMLLoader root = new FXMLLoader().load(getClass().getResource("Chat.fxml"));
            FXMLLoader root = new FXMLLoader();
            root.setLocation(getClass().getResource("Chat.fxml"));
            Stage stage = new Stage();
            stage.setTitle("ChatApp");
            stage.setScene(new Scene(root.load(), 800, 600));
            stage.show();
            ChatController mc= root.getController();
          //  mc.setUser(user);
            mc.initLoginName();
            btn_login.getScene().getWindow().hide();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
