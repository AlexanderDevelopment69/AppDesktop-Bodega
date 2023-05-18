package com.sfc.appdesktopbodega.PruebasDRAWPANE;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main2 extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Principal.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Principal.fxml"));
        Scene scene = new Scene(root);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
