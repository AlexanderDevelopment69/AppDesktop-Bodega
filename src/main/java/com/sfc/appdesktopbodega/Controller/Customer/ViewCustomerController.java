package com.sfc.appdesktopbodega.Controller.Customer;

import com.jfoenix.controls.JFXTextField;
import com.sfc.appdesktopbodega.Model.Customer;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewCustomerController implements Initializable {



    @FXML
    private AnchorPane root;

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
    private TableColumn<?, ?> tbEmail;

    @FXML
    private TableColumn<?, ?> tbAge;

    @FXML
    private TableColumn<?, ?> tbHome;

    @FXML
    private TableColumn<?, ?> tbPhoneNumber;

    @FXML
    void exportDataExcel(ActionEvent event) {

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

    }
    public void showCustomerTable(){

        tbCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        tbDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tbRuc.setCellValueFactory(new PropertyValueFactory<>("ruc"));
        tbNames.setCellValueFactory(new PropertyValueFactory<>("names"));
        tbLastNames.setCellValueFactory(new PropertyValueFactory<>("lastNames"));
        tbEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbAge.setCellValueFactory(new PropertyValueFactory<>("age"));
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    showCustomerTable();
    }
}
