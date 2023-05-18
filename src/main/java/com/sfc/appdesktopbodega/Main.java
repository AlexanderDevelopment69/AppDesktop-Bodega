package com.sfc.appdesktopbodega;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/sfc/appdesktopbodega/Login/Login-view.fxml"));

//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/sfc/appdesktopbodega/User/User-view.fxml"))
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 519);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();


        // Mover scena arrastrando la scena ----------------------
        scene.setOnMousePressed(pressEvent -> {
            scene.setOnMouseDragged(dragEvent -> {
                stage.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                stage.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
        // Mover scena arrastrando la scena ----------------------

    }

    public static void main(String[] args) {
        launch();
    }
}