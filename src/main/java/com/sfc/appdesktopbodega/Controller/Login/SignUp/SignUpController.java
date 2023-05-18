package com.sfc.appdesktopbodega.Controller.Login.SignUp;

import com.jfoenix.controls.*;

import com.sfc.appdesktopbodega.Controller.Login.LoginController;
import com.sfc.appdesktopbodega.Controller.Login.ValidationTextFields;
import com.sfc.appdesktopbodega.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField dni;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField repeatPassword;

    @FXML
    private JFXButton btnIngresar;

    @FXML
    void cancel(ActionEvent event) {
        LoginController.validDialog.close();
    }

    @FXML
    void ingresarKey(KeyEvent event) {

    }






    @FXML
    void signUP(ActionEvent event) throws SQLException, FileNotFoundException {
        if (dni.getText().isBlank() || email.getText().isBlank() || password.getText().isBlank() || repeatPassword.getText().isBlank()) {
            dni.validate();
            email.validate();
            password.validate();
            repeatPassword.validate();
        }
        else {
            if(dni.getText().length()!=8 ||!ValidationTextFields.isNumeric(dni.getText()) ){

            }
            if(!email.getText().matches(ValidationTextFields.patternEmail)){

            }
            if(!password.getText().matches(ValidationTextFields.patternPassword)){

            }
            if(!repeatPassword.getText().equals(password.getText())){

            }
            else {

                User user = new User(dni.getText(), password.getText(), " ", " ", email.getText(), "1", " ");
                if (user.AddUser()) {
                    JFXSnackbar snackbar = new JFXSnackbar(stackPane);
                    snackbar.setPrefWidth(603);
                    snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Cuenta registrada")));

                }
            }


        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    ValidationTextFields validationTextFields=new ValidationTextFields();
    validationTextFields.dniValidator(dni);
    validationTextFields.emailValidator(email);
    validationTextFields.passwordValidator(password);
    validationTextFields.equalPassword(repeatPassword,password);




    }
}
