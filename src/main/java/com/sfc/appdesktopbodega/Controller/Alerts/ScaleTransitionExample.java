package com.sfc.appdesktopbodega.Controller.Alerts;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.scene.paint.Color.rgb;

public class ScaleTransitionExample extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 500);
        stage.setScene(scene);

//        Text text = new Text ("Proveedores");
//
////        text.setX(500);
////        text.setY(500);
//        text.setStyle("-fx-fill: white; -fx-font-size: 30px");
        Rectangle rect = new Rectangle (0,500 , 30, 30);
        rect.setArcHeight(100);
        rect.setArcWidth(100);
        rect.setFill(rgb(97, 95, 245));
        ScaleTransition st = new ScaleTransition(Duration.millis(1000), rect);
        st.setByX(110);
        st.setByY(110);
        st.setAutoReverse(true);
        st.play();
        root.getChildren().add(rect);
//        root.getChildren().addAll(rect,text);

        Pane pane =new Pane();
        pane.setStyle("-fx-background-color: white");
        FadeTransition ft = new FadeTransition(Duration.millis(500), pane);
        ft.setFromValue(0);
        ft.setToValue(1);
        SequentialTransition pt = new SequentialTransition(st,ft);
        pt.play();
//        root.getChildren().removeAll();
        root.getChildren().add(pane);

           pane.prefWidthProperty().bind(scene.widthProperty());
            pane.prefHeightProperty().bind(scene.heightProperty());

        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}