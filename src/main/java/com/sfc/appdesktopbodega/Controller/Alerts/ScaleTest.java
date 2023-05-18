package com.sfc.appdesktopbodega.Controller.Alerts;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ScaleTest extends Application {

    @Override
    public void start(final Stage stage) {
        final ImageView spinner =
                new ImageView("https://cdn1.iconfinder.com/data/icons/duesseldorf/16/process.png");
        spinner.setVisible(false);

        final Label title = new Label("Timed Action Commander Example", spinner);
        title.setContentDisplay(ContentDisplay.BOTTOM);
        title.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 16));

        final TextField textInput = new TextField();
        textInput.setPromptText("Enter command");

        final TextArea textOutput = new TextArea();
        textOutput.setPromptText("Command results will show up here");

        final VBox layout = new VBox(title, textInput, textOutput);
        layout.setSpacing(24);

        // setup some transition that rotates an icon for 2 seconds
        final RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), spinner);
        rotateTransition.setByAngle(90);
        // delay rotation so that DashboardUserController can type without being distracted at once
        rotateTransition.setDelay(Duration.seconds(1));

        // restart transition on DashboardUserController input
        textInput.textProperty().addListener((observable, oldText, newText) -> {
            spinner.setVisible(true);
            rotateTransition.playFromStart();
        });

        rotateTransition.setOnFinished((finishHim) -> {
            // execute command
            textOutput.setText("Executing " + textInput.getText());
            spinner.setVisible(false);
        });


        final Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}