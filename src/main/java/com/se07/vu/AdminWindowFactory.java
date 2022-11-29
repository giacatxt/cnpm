package com.se07.vu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AdminWindowFactory {
    public Stage openWindow() {
        try{//
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(LoginWindowFactory.class.getResource("admin.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 915, 603);
            Image image = new Image(AdminWindowFactory.class.getResource("IconLogin.png").toString());
            stage.getIcons().add(image);
            stage.setTitle("QUẢN LÝ NHÂN KHẨU");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
