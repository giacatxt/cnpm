package com.se07.vu;

import com.se07.main.ConnectionDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControllerLoginWindowFactory {
    @FXML
    Label LableAlerLogin;
    @FXML
    TextField TextFieldUserName;
    @FXML
    PasswordField PasswordFieldPassword;
    @FXML
    Button ButtonLogin;
    @FXML
    Button ButtonCancelLogin;//

    public  void onButtonLogin(){
        if(TextFieldUserName.getText().isBlank()==false&&PasswordFieldPassword.getText().isBlank()==false){
            validateLogin();
        }else{
            LableAlerLogin.setText("Vui lòng nhập tên hoặc mật khẩu");
        }
    }
    public  void onButtonCancelLogin(){
        PasswordFieldPassword.setText("");
        TextFieldUserName.setText("");
        LableAlerLogin.setText("");
    }
    public void validateLogin(){
        ConnectionDatabase connectionDatabase = new ConnectionDatabase();
        Connection connection = connectionDatabase.getConnection();
        String veritylogin = "select * from dangnhap where passwordd='"+PasswordFieldPassword.getText()+"'and userd='"+TextFieldUserName.getText()+"'";
        System.out.println(veritylogin);
        try{
            Statement statement  = connection.createStatement();
            ResultSet queryResult =statement.executeQuery(veritylogin);
            if(queryResult.getRow()==0){
                LableAlerLogin.setText("Vui lòng nhập lại tên hoặc mật khẩu");
            }
            while (queryResult.next()){
//                System.out.println(-1);
//                System.out.println(queryResult.getString(2));
                if(queryResult.getRow()==1){
                    if(TextFieldUserName.getText().equals("admin")){
                        LableAlerLogin.setText("");
                        AdminWindowFactory adminWindowFactory = new AdminWindowFactory();
                        adminWindowFactory.openWindow();
                    } else if (TextFieldUserName.getText().equals("user")) {
                        LableAlerLogin.setText("");
                        UserWindowFactory userWindowFactory = new UserWindowFactory();
                        userWindowFactory.openWindow();
                    }else{
                        LableAlerLogin.setText("");
                        TreasurerWindowFactory treasurerWindowFactory = new TreasurerWindowFactory();
                        treasurerWindowFactory.openWindow();
                    }
                }else{
                    LableAlerLogin.setText("Vui lòng nhập lại tên hoặc mật khẩu");
                }
            }

        }catch (Exception e){

        }
    }
}
