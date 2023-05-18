package com.sfc.appdesktopbodega.Controller.Product;

import com.jfoenix.controls.JFXDrawer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.SortedMap;

public class MainProductController implements Initializable {


    @FXML
    private AnchorPane root;

    @FXML
    private Label labelTitle;

    @FXML
    private Label labelDescription;


    @FXML
    private BarChart<String,Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private PieChart pieChartData;


    @FXML
    private JFXDrawer drawer;

    @FXML
    private StackPane MenuDrawerADD;
    @FXML
    private StackPane MenuDrawerUP;

    private SortedMap<String, Integer> points;


    @FXML
    void addProduct(MouseEvent event) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/AddProduct.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(root.widthProperty());
        fxml.prefHeightProperty().bind(root.heightProperty());
    }




    @FXML
    void dashboard(MouseEvent event) {

    }

    @FXML
    void addCategory(MouseEvent event) throws IOException {
        MenuDrawerADD = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/Category/AddCategory.fxml"));
//        drawer.setOnDrawerClosed(e -> drawer.setSidePane());
        if (drawer.isOpening()) {
            drawer.close();

        } else {
            drawer.setSidePane(MenuDrawerADD);
            drawer.open();
            drawer.toFront();

//                drawer.setMinWidth(300);


        }


    }

    @FXML
    void updateCategory(MouseEvent event) throws IOException {

        MenuDrawerUP = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/Category/UpdateCategory.fxml"));

//        drawer.setOnDrawerClosed(e -> drawer.setSidePane());
        if (drawer.isOpening()) {

            drawer.close();


        } else {
            drawer.setSidePane(MenuDrawerUP);
            drawer.open();
            drawer.toFront();
//                drawer.setMinWidth(300);

        }


    }
    @FXML
    void showProduct(MouseEvent event) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/ViewProduct.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(root.widthProperty());
        fxml.prefHeightProperty().bind(root.heightProperty());
    }

public void showBartChart(){


//    //Defining the x axis
//    CategoryAxis xAxis = new CategoryAxis();
//
//    xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
//            "Speed", "User rating", "Milage", "Safety")));
//    xAxis.setLabel("category");
//
////Defining the y axis
//    NumberAxis yAxis = new NumberAxis();
//    yAxis.setLabel("score");
//    barChart.setTitle("Comparison between various cars");
//
////Prepare XYChart.Series objects by setting data
//    XYChart.Series<String, Number> series1 = new XYChart.Series<>();
//    series1.setName("Fiat");
//    series1.getData().add(new XYChart.Data<>("Speed", 1.0));
//    series1.getData().add(new XYChart.Data<>("User rating", 3.0));
//    series1.getData().add(new XYChart.Data<>("Milage", 5.0));
//    series1.getData().add(new XYChart.Data<>("Safety", 5.0));
//
//    XYChart.Series<String, Number> series2 = new XYChart.Series<>();
//    series2.setName("Audi");
//    series2.getData().add(new XYChart.Data<>("Speed", 5.0));
//    series2.getData().add(new XYChart.Data<>("User rating", 6.0));
//
//    series2.getData().add(new XYChart.Data<>("Milage", 10.0));
//    series2.getData().add(new XYChart.Data<>("Safety", 4.0));
//
//    XYChart.Series<String, Number> series3 = new XYChart.Series<>();
//    series3.setName("Ford");
//    series3.getData().add(new XYChart.Data<>("Speed", 4.0));
//    series3.getData().add(new XYChart.Data<>("User rating", 2.0));
//    series3.getData().add(new XYChart.Data<>("Milage", 3.0));
//    series3.getData().add(new XYChart.Data<>("Safety", 6.0));
//    //Setting the data to bar chart
//    barChart.getData().addAll(series1, series2, series3);



    yAxis.setAutoRanging(false);
//    yAxis.setLowerBound(0);
    yAxis.setUpperBound(1000);
    yAxis.setTickUnit(100);
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    int f = 0;

    XYChart.Series<String, Number>  set1=new XYChart.Series<>();
    set1.getData().add(new XYChart.Data<>("Enero", a));
    set1.getData().add(new XYChart.Data<>("Febrero",b));
    set1.getData().add(new XYChart.Data<>("Marzo",c));
    set1.getData().add(new XYChart.Data<>("Abril",d));
    set1.getData().add(new XYChart.Data<>("Mayo",e));
    set1.getData().add(new XYChart.Data<>("Junio",f));




    Timeline tl = new Timeline();
    tl.getKeyFrames().add(new KeyFrame(Duration.millis(50),
            new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                    for (XYChart.Series<String,Number> series : barChart.getData()) {
                        for (XYChart.Data<String,Number> data : series.getData()) {
//                            data.setYValue(new XYChart.Data<String,Number>("Enero",2));
                                data.setYValue(500);


                        }

                    }
                }
            }));
//        tl.setCycleCount(Animation.INDEFINITE);
    tl.play();

//    barChart.getData().addAll(set1);
    set1.setName("Total de venta");

    barChart.getData().addAll(set1);



}
    ObservableList<XYChart.Data<String, Number>> chartData = FXCollections.observableArrayList();
    public void showPieChart(){

        ObservableList<PieChart.Data> pieChartDatas =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30)
                );
        pieChartData.setData(pieChartDatas);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    showBartChart();
    showPieChart();
    }
}
