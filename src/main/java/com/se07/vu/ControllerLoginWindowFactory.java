package com.se07.vu;

import com.se07.main.ConnectionDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    Button buttonLogin;
    @FXML
    Button ButtonCancelLogin;
    @FXML
    BorderPane borderPaneMainAdmin;
    private Stage stage;

    public void keyPressedEscLogin(){
        borderPaneMainAdmin.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ESCAPE)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Đăng xuất");
                alert.setHeaderText("Bạn thực sự muốn đăng xuất");
                alert.setContentText("Bạn có muốn lưu trước khi thoát");
                if(alert.showAndWait().get() == ButtonType.OK) {
                    stage = (Stage) borderPaneMainAdmin.getScene().getWindow();
                    System.out.println("Bạn đã đăng xuất khỏi trái đất");
                    stage.close();
                }
            }
        });
    }

    public void keyPressedEnter(){
        TextFieldUserName.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                onButtonLogin();
            }
        });
        PasswordFieldPassword.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                onButtonLogin();
            }
        });
    }

    public  void onButtonLogin(){
        if(TextFieldUserName.getText().isBlank()==false && PasswordFieldPassword.getText().isBlank()==false){
            validateLogin();
        }else{
            LableAlerLogin.setText("Vui lòng nhập tên hoặc mật khẩu");
        }
    }
    public void onButtonCancelLogin(){
        PasswordFieldPassword.setText("");
        TextFieldUserName.setText("");
        LableAlerLogin.setText("");
    }
    public void validateLogin(){
        String user = System.getenv("USER");
        String password = System.getenv("MSSQL_PWD");
        String serverName = System.getenv("SERVER_NAME");
        String databaseName = System.getenv("DATABASE_NAME");
        int portNumber = Integer.parseInt(System.getenv("PORT_NUMBER"));
        boolean encrypt = Boolean.parseBoolean(System.getenv("ENCRYPT"));

        Connection connection = ConnectionDatabase.getConnection(user, password, serverName, databaseName,
                portNumber, encrypt);
        String veritylogin = "select * from dangnhap where passwordd='" + PasswordFieldPassword.getText() +
                "'and userd='"+ TextFieldUserName.getText() + "'";
//        System.out.println(veritylogin);
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
                    }else {
                        LableAlerLogin.setText("");
                        TreasurerWindowFactory treasurerWindowFactory = new TreasurerWindowFactory();
                        treasurerWindowFactory.openWindow();
                    }
                    Stage loginStage = (Stage) buttonLogin.getScene().getWindow();
                    loginStage.close();
                }else{
                    LableAlerLogin.setText("Vui lòng nhập lại tên hoặc mật khẩu");
                }
            }

        }catch (Exception e){

        }
    }
}
