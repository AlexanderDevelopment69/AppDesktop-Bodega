package com.sfc.appdesktopbodega.Controller.Sale.CustomerDetail;

import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import com.sfc.appdesktopbodega.Controller.Sale.NewSaleController;
import com.sfc.appdesktopbodega.Model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

//Pasar valor de DNI  a la otra ventana
//import static com.sfc.javafxapp.Controller.Sale.NewSaleController.static_a;

public class NewCustomerController implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private Label labelTitle;

    @FXML
    private Label labelDescription;

    @FXML
    private Label labelDescription2;

    @FXML
    public JFXTextField dni;

    @FXML
    private JFXTextField ruc;

    @FXML
    private JFXTextField names;

    @FXML
    private JFXTextField lastNames;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField home;

    @FXML
    private JFXTextField age;

    @FXML
    private JFXTextField phoneNumber;


    @FXML
    void addCustomer(ActionEvent event) throws SQLException, IOException {
//        String valor= dni.getText();
        NewSaleController.static_dni.setText(dni.getText());



        if((dni.getText().isBlank()) || (names.getText().isBlank() || lastNames.getText().isBlank()) ){

        }
        else{
            Customer customer=new Customer(dni.getText(),ruc.getText(),names.getText(),lastNames.getText(),email.getText(),age.getText(),home.getText(),phoneNumber.getText());
            if(customer.AddCustomer()){

                JFXSnackbar snackbar = new JFXSnackbar(root);
                snackbar.setPrefWidth(603);
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Registro Exitoso")));


            }else{
                JFXSnackbar snackbar = new JFXSnackbar(root);
                snackbar.setPrefWidth(603);
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Cliente ya existe")));
            }
        }

    }

    @FXML
    void cancel(ActionEvent event) {

    }
    public void validationTextfields(){

        RequiredFieldValidator validator = new RequiredFieldValidator();
        ImageView item = new ImageView("/com/sfc/appdesktopbodega/Images/inputBlank.png");
        validator.setMessage("Completa el campo vacio!");
        item.setFitHeight(15);
        item.setFitWidth(15);
        item.setPreserveRatio(true);
        validator.setIcon(item);



        dni.getValidators().add(validator);
        ruc.getValidators().add(validator);
        names.getValidators().add(validator);
        lastNames.getValidators().add(validator);



        dni.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                dni.validate();
            }
        });
        ruc.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ruc.validate();
            }
        });
        names.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                names.validate();
            }
        });
        lastNames.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                lastNames.validate();
            }
        });









    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    validationTextfields();
    }
}
