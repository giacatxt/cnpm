package com.se07.vu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUserWindowFactory implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneNewPeopleUser.setVisible(false);
    }
    @FXML
    AnchorPane paneRightUser, anchorPaneUserMax, paneNewPeopleUser, paneLeftUser;
    @FXML
    Button buttonLogoutUser;
    private Stage stage;

    public void keyPressedEscUser(){
        anchorPaneUserMax.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode().equals(KeyCode.ESCAPE)){
                setButtonLogoutUser();
            }
        });
    }
    public void setMenuButtonAwardUser(){

    }
    public void setButtonNewPeopleUser(){
        paneRightUser.setVisible(false);
        paneLeftUser.setVisible(false);
        paneNewPeopleUser.setVisible(true);
    }
    public void setButtonCancelTemporaryRegistrationPeopleUser(){
        paneNewPeopleUser.setVisible(false);
        paneLeftUser.setVisible(true);
        paneRightUser.setVisible(true);
    }
    public void setButtonLogoutUser() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Đăng xuất");
        alert.setHeaderText("Bạn thực sự muốn đăng xuất");
        alert.setContentText("Bạn có muốn lưu trước khi thoát");
        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) anchorPaneUserMax.getScene().getWindow();
            System.out.println("Bạn đã đăng xuất khỏi trái đất");
            stage.close();
            LoginWindowFactory loginWindowFactory = new LoginWindowFactory();
            loginWindowFactory.openWindow();
        }

    }


}
