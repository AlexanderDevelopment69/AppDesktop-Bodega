package com.sfc.appdesktopbodega.Controller.Login.Captcha;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import com.sfc.appdesktopbodega.Controller.Login.LoginController;
import com.sfc.appdesktopbodega.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CaptchaController implements Initializable {

    @FXML
    private JFXTextField captcha;
    @FXML
    private Pane alertCaptcha;
    @FXML
    private ImageView textImage;
    @FXML
    private JFXButton btnIngresar;
    @FXML
    private JFXCheckBox checkBox;
    @FXML
    private Label notification;
    @FXML
    void submitCaptcha(ActionEvent event) throws IOException, SQLException {

        String var="recaptcha";
        User user= new User();
        if(captcha.getText().equals(var)&& checkBox.isSelected()){
            LoginController.validDialog.close();
            user.deleteAttemptFailed();
        }
        else{
            if(!checkBox.isSelected()){
                notification.setText("Marca la casilla porfavor");
            }
        }

    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
