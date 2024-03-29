package com.sfc.appdesktopbodega.Controller.Alerts;



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;
public class barchart2 extends Application {


    final static String itemA = "A";
    final static String itemB = "B";
    final static String itemC = "F";
    @Override
    public void start(Stage stage) {
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis, yAxis);
        bc.setTitle("Summary");
        xAxis.setLabel("Value");
//        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Item");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(0.0, itemA));
//        series1.getData().add(new XYChart.Data(0.0, itemB));
//        series1.getData().add(new XYChart.Data(0.0, itemC));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(0.00, itemA));
//        series2.getData().add(new XYChart.Data(0.00, itemB));
//        series2.getData().add(new XYChart.Data(0.00, itemC));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(0.00, itemA));
//        series3.getData().add(new XYChart.Data(0.00, itemB));
//        series3.getData().add(new XYChart.Data(0.00, itemC));

        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(50),
                new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent actionEvent) {
                        for (XYChart.Series<Number, String> series : bc.getData()) {
                            for (XYChart.Data<Number, String> data : series.getData()) {
                                data.setXValue(1);
                            }
                        }
                    }
                }));
//        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();

        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
