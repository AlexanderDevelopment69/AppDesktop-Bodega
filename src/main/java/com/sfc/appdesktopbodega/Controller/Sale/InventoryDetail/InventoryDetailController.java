package com.sfc.appdesktopbodega.Controller.Sale.InventoryDetail;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryDetailController implements Initializable {

    @FXML
    private Label labelTitle11;

    @FXML
    private JFXTextField code;

    @FXML
    private JFXTextField product;

    @FXML
    private JFXTextField category;

    @FXML
    private JFXTextField brand;

    @FXML
    private JFXTextField cost;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField stock;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
