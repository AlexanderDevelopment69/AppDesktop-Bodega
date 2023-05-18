package com.sfc.appdesktopbodega.Controller.Customer;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainCustomerController implements Initializable {


    @FXML
    private AnchorPane root;

    @FXML
    private Label labelTitle;

    @FXML
    private Label labelDescription;

    @FXML
    private JFXDrawer drawer;

    @FXML
    void addCustomer(ActionEvent event) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Customer/AddCustomer.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(root.widthProperty());
        fxml.prefHeightProperty().bind(root.heightProperty());
    }

    @FXML
    void dashboard(ActionEvent event) {

    }

    @FXML
    void showCustomer(ActionEvent event) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Customer/ViewCustomer.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(root.widthProperty());
        fxml.prefHeightProperty().bind(root.heightProperty());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
