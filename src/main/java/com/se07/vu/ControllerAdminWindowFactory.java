package com.se07.vu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAdminWindowFactory implements Initializable {
    @FXML
    AnchorPane paneUserAdmin, paneLeftAdmin, paneAbsentRegistrationAdmin, paneRightAdmin, paneNewUserAdmin, paneSplitUserAdmin;
    @FXML

    Button buttonLogoutAdmin, buttonCancelNewPeopleAdmin;
    @FXML
    AnchorPane anchorPaneAdminMax, panePeopleAdmin, paneMidPeopleAdmin, paneNewPeopleAdmin, paneTemporaryRegistrationPeoppleAdmin;
    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneNewUserAdmin.setVisible(false);
        panePeopleAdmin.setVisible(false);
        paneMidPeopleAdmin.setVisible(false);
        paneNewPeopleAdmin.setVisible(false);
        paneTemporaryRegistrationPeoppleAdmin.setVisible(false);
        paneUserAdmin.setVisible(false);
        paneAbsentRegistrationAdmin.setVisible(false);
        paneSplitUserAdmin.setVisible(false);
    }
    public void setButtonAbsentRegistrationAdmin(){
        paneRightAdmin.setVisible(false);
        paneLeftAdmin.setVisible(false);
        paneAbsentRegistrationAdmin.setVisible(true);
    }
    public void setButtonCancelAbsentRegistrationAdmin(){
        paneLeftAdmin.setVisible(true);
        paneRightAdmin.setVisible(true);
        paneAbsentRegistrationAdmin.setVisible(false);
    }
    public void setButtonCancelTemporaryRegistrationPeoppleAdmin(){
        paneTemporaryRegistrationPeoppleAdmin.setVisible(false);
        paneLeftAdmin.setVisible(true);
        paneRightAdmin.setVisible(true);
    }
    public void setButtonTemporaryRegistrationPeopleAdmin(){
        paneTemporaryRegistrationPeoppleAdmin.setVisible(true);
        paneLeftAdmin.setVisible(false);
        paneRightAdmin.setVisible(false);
    }
    public void setButtonCancelNewPeopleAdmin(){
        paneNewPeopleAdmin.setVisible(false);
        paneLeftAdmin.setVisible(true);
        paneRightAdmin.setVisible(true);
    }
    public void setButtonUserAdmin(){
        paneMidPeopleAdmin.setVisible(false);
        panePeopleAdmin.setVisible(false);
        paneRightAdmin.setVisible(false);
        paneUserAdmin.setVisible(true);
    }
    public void setButtonNewPeopleAdmin(){
        paneUserAdmin.setVisible(false);
        paneNewPeopleAdmin.setVisible(true);
        paneLeftAdmin.setVisible(false);
        paneRightAdmin.setVisible(false);
    }
    public void keyPressedEscAdmin(){
        anchorPaneAdminMax.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ESCAPE)){
                setButtonLogoutAdmin();
            }
        });
    }
    public void  setButtonHomeAdmin(){
        panePeopleAdmin.setVisible(false);
        paneMidPeopleAdmin.setVisible(false);
        paneUserAdmin.setVisible(false);
        paneRightAdmin.setVisible(true);
    }
    public  void setButtonPeopleAdmin(){
        paneUserAdmin.setVisible(false);
        panePeopleAdmin.setVisible(true);
        paneMidPeopleAdmin.setVisible(true);
        paneRightAdmin.setVisible(true);

    }
    public void setButtonRemovePeopleAdmin() {
        System.out.println("ban da xoa thanh cong");
    }
    public void setButtonNewUserAdmin(){
        paneNewUserAdmin.setVisible(true);
        paneLeftAdmin.setVisible(false);
    }
    public void setButtonSplitUserAdmin(){
        paneSplitUserAdmin.setVisible(true);
        paneLeftAdmin.setVisible(false);
    }
    public void setButtonRemoveUserAdmin(){

    }
    public void setButtonCancelNewUserAdmin(){
        paneNewUserAdmin.setVisible(false);
        paneLeftAdmin.setVisible(true);
    }
    public void setButtonCancelSplitUserAdmin(){
        paneSplitUserAdmin.setVisible(false);
        paneLeftAdmin.setVisible(true);
    }
    public void setButtonAcceptNewPeopleAdmin(){

    }
    public void setButtonLogoutAdmin(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Đăng xuất");
        alert.setHeaderText("Bạn thực sự muốn đăng xuất");
        alert.setContentText("Bạn có muốn lưu trước khi thoát");
        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) anchorPaneAdminMax.getScene().getWindow();
            System.out.println("Bạn đã đăng xuất khỏi trái đất");
            stage.close();
            LoginWindowFactory loginWindowFactory = new LoginWindowFactory();
            loginWindowFactory.openWindow();
        }

    }


}
