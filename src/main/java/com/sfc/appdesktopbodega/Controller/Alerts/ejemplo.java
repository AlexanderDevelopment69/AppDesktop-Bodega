package com.sfc.appdesktopbodega.Controller.Alerts;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

public class ejemplo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple Interface
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        // Quantity
        HBox hBoxQuantity = new HBox(5);
        hBoxQuantity.setAlignment(Pos.CENTER);
        TextField txtQuantity = new TextField();
        hBoxQuantity.getChildren().addAll(
                new Label("Quantity:"),
                txtQuantity
        );

        // Price
        HBox hBoxPrice = new HBox(5);
        hBoxPrice.setAlignment(Pos.CENTER);
        TextField txtPrice = new TextField();
        hBoxPrice.getChildren().addAll(
                new Label("Price:"),
                txtPrice
        );

        // Total
        HBox hBoxTotal = new HBox(5);
        hBoxTotal.setAlignment(Pos.CENTER);
        Label lblTotal = new Label();
        hBoxTotal.getChildren().addAll(
                new Label("Total: $"),
                lblTotal
        );

        // Properties used for bindings
        DoubleProperty price = new SimpleDoubleProperty();
        DoubleProperty quantity = new SimpleDoubleProperty();
        DoubleProperty total = new SimpleDoubleProperty();

        // Bind the total to price x quantity
        total.bind(price.multiply(quantity));

        // Setup the converters to get the input from the textfields
        StringConverter<? extends Number> converter = new DoubleStringConverter();

        // Bind the text field entries to their properties
        Bindings.bindBidirectional(txtPrice.textProperty(), price, (StringConverter<Number>) converter);
        Bindings.bindBidirectional(txtQuantity.textProperty(), quantity, (StringConverter<Number>) converter);

        // Bind the total label
        lblTotal.textProperty().bind(total.asString());

        // Add all nodes to stage
        root.getChildren().addAll(hBoxPrice, hBoxQuantity, hBoxTotal);

        // Show the stage
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Sample");
        primaryStage.show();
    }
}