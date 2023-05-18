package com.sfc.appdesktopbodega.Controller.Alerts;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class AlertsController {

    public void Alert(String title, String contenido, StackPane stackDashboard){
        Label label1= new Label(title);
        Label label2= new Label(contenido);
        JFXDialogLayout content =new JFXDialogLayout();
        content.setStyle("-fx-pref-height: 100;-fx-pref-width: 250;-fx-font-size: 11");
        label1.setStyle("  -fx-font-size: 13;-fx-font-family:Poppins SemiBold");
        label2.setStyle("  -fx-font-size: 11");
        content.setHeading(label1);
        content.setBody(label2);
        JFXDialog dialog =new JFXDialog(stackDashboard,content, JFXDialog.DialogTransition.CENTER);
        JFXButton button=new JFXButton("Ok");
        button.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-pref-width: 60; -fx-pref-height: 40;");
        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                dialog.close();
            }
        });
        content.setActions(button);
        dialog.show();

    }




    public void menu(StackPane stackPane){
        ContextMenu cm =  new ContextMenu(new MenuItem("Item 1"), new MenuItem("Item 2"));



        Scene scene = new Scene(stackPane, 300, 250);

        scene.setOnContextMenuRequested(event -> {
            cm.show(stackPane,event.getScreenX(),event.getScreenY());

            double yIni=scene.getWindow().getY();
            double yEnd=cm.getY();
            cm.setY(yIni);

            final DoubleProperty yProperty = new SimpleDoubleProperty(yIni);
            yProperty.addListener((ob,n,n1)->cm.setY(n1.doubleValue()));

            Timeline timeIn = new Timeline();
            timeIn.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(0.5),
                            new KeyValue(yProperty, yEnd, Interpolator.EASE_BOTH)));
            timeIn.play();

        });



    }


}
