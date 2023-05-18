package com.sfc.appdesktopbodega.Controller.Alerts;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    @FXML
    private Button clickMeButton;

    @FXML
    private Pane contentPane;

    @FXML
    private AnchorPane root;

    @FXML
    private void handleButtonAction(ActionEvent event) {
//        Pane pane=new Pane();
//        TableView tableView = new TableView();
//        tableView.setMaxHeight(250);
//        tableView.setMinHeight(400);
//
//        ResizeHeightTranslation rht = new ResizeHeightTranslation(Duration.millis(600), contentPane, tableView.getMinHeight() );
//
//        FadeTransition ft = new FadeTransition(Duration.millis(300), tableView);
//        ft.setFromValue(0);
//        ft.setToValue(1);
//
//        SequentialTransition pt = new SequentialTransition(rht, ft);
//
//        pt.play();
//        contentPane.getChildren().add(tableView);
//        contentPane.maxWidthProperty().bind(tableView.widthProperty());
//        contentPane.maxHeightProperty().bind(tableView.heightProperty());


        Pane contentPane=new Pane();
        TableView tableView = new TableView();
        contentPane.setStyle("-fx-background-color: #83F687");
//        tableView.setMaxHeight(550);
        tableView.maxWidthProperty().bind(root.widthProperty());
        tableView.maxHeightProperty().bind(root.heightProperty());
//        tableView.setMinWidth(500);
        ResizeHeightTranslation rht = new ResizeHeightTranslation(Duration.millis(250), contentPane, tableView.getMaxHeight());


        FadeTransition ft = new FadeTransition(Duration.millis(400), tableView);
        ft.setFromValue(0);
        ft.setToValue(1);

        SequentialTransition pt = new SequentialTransition(rht, ft);

        pt.play();
        contentPane.getChildren().add(tableView);
        root.getChildren().add(contentPane);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}