package com.sfc.appdesktopbodega.PruebasDRAWPANE;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            // TODO
            VBox box = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/NavDrawer.fxml"));
            drawer.setSidePane(box);
            drawer.setMinWidth(0); // this is the new code added

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
            drawer.toggle();
        });
        drawer.setOnDrawerOpening((event) -> {
            task.setRate(task.getRate() * -1);
            task.play();
            drawer.setMinWidth(220);
        });
        drawer.setOnDrawerClosed((event) -> {
            task.setRate(task.getRate() * -1);
            task.play();
            drawer.setMinWidth(0);
        });



//        try {
//            // TODO
//            VBox box = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/NavDrawer.fxml"));
//            drawer.setSidePane(box);
//
//        } catch (IOException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
//        task.setRate(-1);
//        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
//            drawer.toggle();
//        });
//        drawer.setOnDrawerOpening((event) -> {
//            task.setRate(task.getRate() * -1);
//            task.play();
//            drawer.setMinWidth(220);
//        });
//        drawer.setOnDrawerClosed((event) -> {
//            task.setRate(task.getRate() * -1);
//            task.play();
//            drawer.setMinWidth(0);
//        });
    }
}