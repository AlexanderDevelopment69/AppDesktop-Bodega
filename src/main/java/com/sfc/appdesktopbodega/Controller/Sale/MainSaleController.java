package com.sfc.appdesktopbodega.Controller.Sale;

import com.jfoenix.controls.JFXDrawer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSaleController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private Label labelTitle;

    @FXML
    private Label labelDescription;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private PieChart pieChartData;

    @FXML
    private JFXDrawer drawer;




    @FXML
    void dashboard(MouseEvent event) {

    }

    @FXML
    void newSale(ActionEvent event) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Sale/NewSale.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(root.widthProperty());
        fxml.prefHeightProperty().bind(root.heightProperty());
    }

    @FXML
    void saleDetail(ActionEvent event) {

    }

    @FXML
    void showSale(ActionEvent event) {

    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
