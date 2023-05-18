package com.sfc.appdesktopbodega.Controller.User;

import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.sfc.appdesktopbodega.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable {

    @FXML
    private AnchorPane stackDashboard;
    @FXML
    private JFXTextField image;

    @FXML
    private JFXTextField code;

    @FXML
    private JFXTextField dni;

    @FXML
    private JFXTextField names;

    @FXML
    private JFXTextField lastNames;

    @FXML
    private JFXTextField email;

    @FXML
    private Label labelTitle;

    @FXML
    private ImageView photo;

    @FXML
    private JFXTextField dateOfBirth;

    @FXML
    private JFXTextField homeAdress;

    @FXML
    private JFXTextField phoneNumber;

    @FXML
    private JFXTextField password;
    @FXML
    private JFXTextField repeatPassword;

    Stage stage = null;


    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    @FXML
    void uploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        System.out.println(selectedFile);
        image.setText(String.valueOf(selectedFile));
    }

    @FXML
    void updateUser(ActionEvent event) throws SQLException, FileNotFoundException {

        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
//        String idrol= cmRol.getValue();
//        if(cmRol.getValue() == "Administrador"){
//            idrol="1";
//
//        }
//        else if (cmRol.getValue() == "Vendedor"){
//            idrol="2";
//
//        }

//        User user = new User(dni.getText(), password.getText(), names.getText(), lastNames.getText(),email.getText(),idrol);
        User user = new User(dni.getText(), password.getText(), names.getText(), lastNames.getText(),email.getText(),"1",image.getText());


        if(dni.getText().isBlank()){

            dni.setPromptText("Campo requerido");
            dni.setStyle("-fx-prompt-text-fill:#EE4D4C");

        }
        if(names.getText().isBlank()){

            names.setPromptText("Campo requerido");
            names.setStyle("-fx-prompt-text-fill:#EE4D4C");

        }
        if(lastNames.getText().isBlank()){

            lastNames.setPromptText("Campo requerido");
            lastNames.setStyle("-fx-prompt-text-fill:#EE4D4C");

        }
        if(email.getText().isBlank()){

            email.setPromptText("Campo requerido");
            email.setStyle("-fx-prompt-text-fill:#EE4D4C");

        }

        if(password.getText().isBlank()){

            password.setPromptText("Campo requerido");
            password.setStyle("-fx-prompt-text-fill:#EE4D4C");

        }

        else {


            if (!isNumeric(dni.getText()) || dni.getText().length()!= 8) {

                dni.setPromptText("Dni no Valido ");
                dni.setStyle("-fx-prompt-text-fill:#FF6347");
                dni.setText("");

            }

            if (!password.getText().matches(pattern)|| !repeatPassword.getText().matches(pattern) ) {
                password.setPromptText("Contraseño no cumple");
                password.setStyle("-fx-prompt-text-fill:#FF6347");
                password.setText("");

            } else {

                if(user.AddUser()){
                    JFXSnackbar snackbar = new JFXSnackbar(stackDashboard);
                    snackbar.setPrefWidth(603);
                    snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Cambios realizados")));


                }
                else{
                    JFXSnackbar snackbar = new JFXSnackbar(stackDashboard);
                    snackbar.setPrefWidth(603);
                    snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("No se pudo realizar el cambio")));

                }

            }
        }



    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
