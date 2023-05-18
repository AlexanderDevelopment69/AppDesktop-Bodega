package com.sfc.appdesktopbodega.Controller.Login.RecoveryPassword;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.sfc.appdesktopbodega.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserRecoveryController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField code;

    @FXML
    void btnRecovery() throws SQLException {
        String codigo =code.getText();
        String contra=password.getText();
        String DNI=username.getText();
        JFXSnackbar snackbar= new JFXSnackbar(pane);
        snackbar.setPrefWidth(460);
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

        if(codigo.equals("123") && password.getText().matches(pattern) ){
            User user = new User();
            user.recoveryPassword(contra,DNI);
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Contraseña Cambiada")));

        }else{
            if(!password.getText().matches(pattern)){
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("La contraseña no cumple")));
            }
            if(!codigo.equals("123")){
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Codigo Incorrecto")));
            }


        }


    }


    @FXML
    void ingresarKey(KeyEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
