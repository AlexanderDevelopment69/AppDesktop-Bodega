package com.sfc.appdesktopbodega.Controller.Login.RecoveryPassword;

import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.sfc.appdesktopbodega.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserRecoveryEmailCode implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private JFXTextField emailCode;
    @FXML
    private JFXTextField password;

    UserRecoveryEmailController stage1stag2;

    String email;

    public void recibeParametros(UserRecoveryEmailController stage1,String texto){
            stage1stag2=stage1;
            email= texto;
    }


    @FXML
    void btnRecovery(ActionEvent event) throws SQLException {
        String token = emailCode.getText();
        String contra = password.getText();

        JFXSnackbar snackbar = new JFXSnackbar(pane);
        snackbar.setPrefWidth(399);
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        User user = new User();
        if (token.isBlank() || email.isBlank()) {
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("introduce el codigo y la contraseña")));

        } else {
            if (password.getText().matches(pattern) && user.validatedToken(token)) {
                //Cambiar la contraseña con la contraseña, el token y el correo electronico
                user.recoveryPasswordToken(contra, token, email);

                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Contraseña Cambiada")));


            }
            if(!user.validatedToken(token)){
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("El codigo es Incorrecto")));

            }
            if(!password.getText().matches(pattern)){
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("La contraseña no cumple los requisitos")));
            }

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
