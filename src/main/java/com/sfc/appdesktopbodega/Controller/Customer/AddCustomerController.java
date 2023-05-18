package com.sfc.appdesktopbodega.Controller.Customer;

import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.sfc.appdesktopbodega.Model.Customer;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddCustomerController implements Initializable

{

    @FXML
    private AnchorPane root;

    @FXML
    private Label labelDescription;

    @FXML
    private Label labelDescription2;

    @FXML
    private Label labelTitle;

    @FXML
    private JFXTextField dni;

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
    private JFXTextField search;

    @FXML
    private MFXLegacyTableView<Customer> customerTable;

    @FXML
    private TableColumn<?, ?> tbCode;

    @FXML
    private TableColumn<?, ?> tbDni;

    @FXML
    private TableColumn<?, ?> tbRuc;

    @FXML
    private TableColumn<?, ?> tbNames;

    @FXML
    private TableColumn<?, ?> tbLastNames;

    @FXML
    private TableColumn<?, ?> tbHome;

    @FXML
    private TableColumn<?, ?> tbPhoneNumber;


    @FXML
    void addCustomer(ActionEvent event) throws SQLException, FileNotFoundException {


        if((dni.getText().isBlank()) || (names.getText().isBlank() || lastNames.getText().isBlank()) ){

        }
        else{
            Customer customer=new Customer(dni.getText(),ruc.getText(),names.getText(),lastNames.getText(),email.getText(),age.getText(),home.getText(),phoneNumber.getText());
            if(customer.AddCustomer()){
                showCustomerTable();
//            
                JFXSnackbar snackbar = new JFXSnackbar(root);
                snackbar.setPrefWidth(603);
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Cliente registrado correctamente")));
            }else{
                JFXSnackbar snackbar = new JFXSnackbar(root);
                snackbar.setPrefWidth(603);
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Cliente Existente")));
            }
        }

    }

    @FXML
    void cancel(ActionEvent event) {
        dni.setText("");
        ruc.setText("");
        names.setText("");
        lastNames.setText("");
        email.setText("");
        home.setText("");
        age.setText("");
        phoneNumber.setText("");

    }

    @FXML
    void deleteCustomer(ActionEvent event) throws SQLException {
       Customer customer=customerTable.getSelectionModel().getSelectedItem();

        if (customer==null) {
            JFXSnackbar snackbar = new JFXSnackbar(root);
            snackbar.setPrefWidth(603);
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Selecciona un cliente")));
        } else {

            customer.DeleteCustomer();
            showCustomerTable();

            JFXSnackbar snackbar = new JFXSnackbar(root);
            snackbar.setPrefWidth(603);
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Cliente eliminado correctamente")));

        }
    }

    @FXML
    void searchCustomer(KeyEvent event) {
        String Buscar=search.getText();
        try {
            Customer customer=new Customer();
            ObservableList<Customer> items=customer.search(Buscar);
            this.customerTable.setItems(items);
            customerTable.refresh();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void selectionCustomer(MouseEvent event) {
        Customer customer=customerTable.getSelectionModel().getSelectedItem();
        if(customer==null){

        }
        else {
            dni.setText(customer.getDni());
            ruc.setText(customer.getRuc());
            names.setText(customer.getNames());
            lastNames.setText(customer.getLastNames());
            email.setText(customer.getEmail());
            age.setText(customer.getAge());
            home.setText(customer.getHome());
            phoneNumber.setText(customer.getPhoneNumber());
        }
    }

    @FXML
    void updateCustomer(ActionEvent event) throws SQLException {

        Customer customer=customerTable.getSelectionModel().getSelectedItem();
        if (customer==null) {
            JFXSnackbar snackbar = new JFXSnackbar(root);
            snackbar.setPrefWidth(603);
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Selecciona un cliente")));
        } else {

            customer.UpdateCustomer(dni.getText(),ruc.getText(),names.getText(),lastNames.getText(),phoneNumber.getText());
            showCustomerTable();
//            customerTable.refresh();
            JFXSnackbar snackbar = new JFXSnackbar(root);
            snackbar.setPrefWidth(603);
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Cliente actualizado")));

        }
    }

    public void showCustomerTable(){

        tbCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        tbDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tbRuc.setCellValueFactory(new PropertyValueFactory<>("ruc"));
        tbNames.setCellValueFactory(new PropertyValueFactory<>("names"));
        tbLastNames.setCellValueFactory(new PropertyValueFactory<>("lastNames"));
        tbHome.setCellValueFactory(new PropertyValueFactory<>("home"));
        tbPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        try {
            Customer customer=new Customer();
            ObservableList<Customer> items=customer.GetDataCustomer();
            this.customerTable.setItems(items);
            customerTable.refresh();
        } catch (SQLException e) {
            System.out.println(e);;
        }

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
    showCustomerTable();
    validationTextfields();

    }
}
