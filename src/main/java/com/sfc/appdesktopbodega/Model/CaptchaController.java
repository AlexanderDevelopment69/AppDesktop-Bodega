package com.sfc.appdesktopbodega.Model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class CaptchaController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        WebView browser = new WebView();

        WebEngine webEngine = browser.getEngine();

        webEngine.load("https://www.google.com");

        StackPane root = new StackPane();
        root.getChildren().add(browser);

        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        launch(args);
    }

}
