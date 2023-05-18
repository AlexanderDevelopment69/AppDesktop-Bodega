package com.sfc.appdesktopbodega.Controller.Product;

import com.jfoenix.controls.JFXTextField;

import com.sfc.appdesktopbodega.Controller.Services.ExcelExport;
import com.sfc.appdesktopbodega.Model.Product;
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

public class ViewProductController implements Initializable {


    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField search;

    @FXML
    private MFXLegacyTableView<Product> productTable;

    @FXML
    private TableColumn<?, ?> tbCode;

    @FXML
    private TableColumn<?, ?> tbCodeProduct;

    @FXML
    private TableColumn<?, ?> tbProduct;

    @FXML
    private TableColumn<?, ?> tbCategory;

    @FXML
    private TableColumn<?, ?> tbBrand;

    @FXML
    private TableColumn<?, ?> tbCost;

    @FXML
    private TableColumn<?, ?> tbPrice;

    @FXML
    private TableColumn<?, ?> tbUnid;

    @FXML
    private TableColumn<?, ?> tbProvider;

    @FXML
    void exportDataExcel(ActionEvent event) {
        ExcelExport excelExport=new ExcelExport();
        excelExport.export(productTable);

    }


    @FXML
    void searchProduct(KeyEvent event) {
        String Buscar = search.getText();
        try {
            Product products = new Product();
            ObservableList<Product> items = products.Search(Buscar);
            this.productTable.setItems(items);
            productTable.refresh();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void selectionProduct(MouseEvent event) {

    }



    void showProduct() {
//        UserTable = FXCollections.observableArrayList();
        tbCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        tbCodeProduct.setCellValueFactory(new PropertyValueFactory<>("codeProduct"));
        tbProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
        tbCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tbBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        tbCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tbPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        try {
            Product products = new Product();
            ObservableList<Product> items = products.GetDataProduct();
            this.productTable.setItems(items);
            productTable.refresh();

        } catch (SQLException e) {
            System.out.println(e);

        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showProduct();
    }
}
