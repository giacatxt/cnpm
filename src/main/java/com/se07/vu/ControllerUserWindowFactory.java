package com.se07.vu;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerUserWindowFactory {
    @FXML
    AnchorPane paneRightUser, anchorPaneUserMax;
    @FXML
    Button buttonLogoutUser;
    private Stage stage;
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
