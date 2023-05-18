package com.sfc.appdesktopbodega.Controller.Alerts;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SmoothKeyEvents extends Application {

    public final static String TITLE = "simple key-input program";
    public final static short WIDTH = 1280;
    public final static short HEIGHT = 720;

    private Stage window;
    private Scene mainS;
    private Group groupS;
    private Rectangle rect;

    private int x = 50;
    private int y = 50;
    private int velX = 0;
    private int velY = 0;

    @Override
    public void start(Stage primaryStage) {
        groupS = new Group();
        mainS = new Scene(groupS, WIDTH, HEIGHT, Color.DARKBLUE);
        window = primaryStage;
        window.setScene(mainS);
        window.setTitle(TITLE);
        window.show();
        window.requestFocus();

        rect = new Rectangle();
        rect.setFill(Color.MEDIUMSPRINGGREEN);
        rect.setX(x);
        rect.setY(y);
        rect.setWidth(150);
        rect.setHeight(150);
        groupS.getChildren().add(rect);

        mainS.setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent ke) {
                if(ke.getCode() == KeyCode.A) {
                    setVelX(-9);
                }
                if(ke.getCode() == KeyCode.S) {
                    setVelY(9);
                }
                if(ke.getCode() == KeyCode.D) {
                    setVelX(9);
                }
                if(ke.getCode() == KeyCode.W) {
                    setVelY(-9);
                }
            }
        });

        mainS.setOnKeyReleased(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent ke) {
                if(ke.getCode() == KeyCode.A) {
                    setVelX(0);
                }
                if(ke.getCode() == KeyCode.S) {
                    setVelY(0);
                }
                if(ke.getCode() == KeyCode.D) {
                    setVelX(0);
                }
                if(ke.getCode() == KeyCode.W) {
                    setVelY(0);
                }
            }
        });

        final AnimationTimer at = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                x += velX;
                rect.setX(x);
                y += velY;
                rect.setY(y);
            }
        };
        at.start();
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public void stop() {
        System.out.println("program exited");
    }

    public static void main(String[] args) {
        launch(args);
    }
}