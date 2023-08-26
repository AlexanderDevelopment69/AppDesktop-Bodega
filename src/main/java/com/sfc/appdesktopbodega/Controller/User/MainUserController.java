package com.sfc.appdesktopbodega.Controller.User;


import animatefx.animation.FadeInLeft;
import com.jfoenix.controls.*;

import com.sfc.appdesktopbodega.Controller.Alerts.AlertsController;
import com.sfc.appdesktopbodega.Model.User;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyListView;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.TimerTask;

public class MainUserController implements Initializable {
    @FXML
    private AnchorPane root;



    AlertsController alertsController=new AlertsController();


    @FXML
    private JFXDrawer drawer;

    @FXML
    private StackPane MenuDrawerADDUser;


    @FXML
    private JFXTextField dni;

    @FXML
    private JFXTextField names;

    @FXML
    private JFXTextField lastNames;
    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField repeatPassword;






    @FXML
    void openDashboard(ActionEvent event) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/DashboardUser.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(root.widthProperty());
        fxml.prefHeightProperty().bind(root.heightProperty());



    }

    @FXML
    void addUser(ActionEvent event) throws IOException {



        //        drawer.setOnDrawerClosed(e -> drawer.setSidePane());
        if (drawer.isOpening()) {

            drawer.close();


        } else {
            drawer.setSidePane(MenuDrawerADDUser);
            drawer.open();
            drawer.toFront();
//                drawer.setMinWidth(300);

        }

    }



//    @FXML
//    void newUser(ActionEvent event) throws SQLException {
//
////        String Dni= dni.getText();
////        String Password= password.getText();
////        String RepeatPassword= repeatPassword.getText();
////        String Names= names.getText();
////        String LastNames= lastNames.getText();
//        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
////        String idrol= cmRol.getValue();
////        if(cmRol.getValue() == "Administrador"){
////            idrol="1";
////
////        }
////        else if (cmRol.getValue() == "Vendedor"){
////            idrol="2";
////
////        }
//
//        User user = new User(dni.getText(), password.getText(), names.getText(), lastNames.getText(),email.getText(),idrol);
//        User user = new User(dni.getText(), password.getText(), names.getText(), lastNames.getText(),email.getText(),"1");
//
//
//        if(dni.getText().isBlank()){
//
//            dni.setPromptText("Campo requerido");
//            dni.setStyle("-fx-prompt-text-fill:#EE4D4C");
//
//        }
//        if(names.getText().isBlank()){
//
//            names.setPromptText("Campo requerido");
//            names.setStyle("-fx-prompt-text-fill:#EE4D4C");
//
//        }
//        if(lastNames.getText().isBlank()){
//
//            lastNames.setPromptText("Campo requerido");
//            lastNames.setStyle("-fx-prompt-text-fill:#EE4D4C");
//
//        }
//        if(email.getText().isBlank()){
//
//            email.setPromptText("Campo requerido");
//            email.setStyle("-fx-prompt-text-fill:#EE4D4C");
//
//        }
//
//        if(password.getText().isBlank()){
//
//            password.setPromptText("Campo requerido");
//            password.setStyle("-fx-prompt-text-fill:#EE4D4C");
//
//        }
//        if(repeatPassword.getText().isBlank()){
//
//            repeatPassword.setPromptText("Campo requerido");
//            repeatPassword.setStyle("-fx-prompt-text-fill:#EE4D4C");
//
//        }
//
//        else {
//
//            if (!password.getText().equals(repeatPassword.getText())) {
//                JOptionPane.showMessageDialog(null, "Contraseñas no coinciden");
//
//            }
//
//            if (!isNumeric(dni.getText()) || dni.getText().length()!= 8) {
//
//                dni.setPromptText("Dni no Valido ");
//                dni.setStyle("-fx-prompt-text-fill:#FF6347");
//                dni.setText("");
//
//            }
//
//            if (!password.getText().matches(pattern) || !repeatPassword.getText().matches(pattern)) {
//                password.setPromptText("Contraseño no cumple");
//                repeatPassword.setPromptText("Contraseña no cumple");
//                password.setStyle("-fx-prompt-text-fill:#FF6347");
//                repeatPassword.setStyle("-fx-prompt-text-fill:#FF6347");
//                password.setText("");
//                repeatPassword.setText("");
//
//            } else {
//
//                if(user.AddUser()){
//                    JOptionPane.showMessageDialog(null, "Registro Correcto");
//                    dni.setText("");
//                    password.setText("");
//                    repeatPassword.setText("");
//                    names.setText("");
//                    lastNames.setText("");
//                    email.setText("");
//                    password.setPromptText("Contraseña");
//                    repeatPassword.setPromptText("Repite contraseña");
//                    password.setStyle("-fx-prompt-text-fill:#888888");
//                    repeatPassword.setStyle("-fx-prompt-text-fill:#888888");
//
//                    showUserTable();
//
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Ingreso Incorrecto");
//
//                }
//
//
////                    DashboardUserController.RegistrarUser();
////                    JOptionPane.showMessageDialog(null, "Registro Correcto");
////                    dni.setText("");
////                    password.setText("");
////                    repeatPassword.setText("");
////                    names.setText("");
////                    lastNames.setText("");
////                    password.setPromptText("Contraseña");
////                    repeatPassword.setPromptText("Repite contraseña");
////                    password.setStyle("-fx-prompt-text-fill:#888888");
////                    repeatPassword.setStyle("-fx-prompt-text-fill:#888888");
////
////                    showUserTable();
//            }
//        }
//    }


    @FXML
    void cancel(ActionEvent event) {

        dni.setText("");
        password.setText("");
        repeatPassword.setText("");
        names.setText("");
        lastNames.setText("");
        email.setText("");
        dni.requestFocus();
        dni.setPromptText("Dni");
        password.setPromptText("Contraseña");
        repeatPassword.setPromptText("Repite contraseña");
        names.setPromptText("Nombres");
        lastNames.setPromptText("Apellidos");
        email.setPromptText("Correo Electronico");
        dni.setStyle("-fx-prompt-text-fill:#888888");
        password.setStyle("-fx-prompt-text-fill:#888888");
        repeatPassword.setStyle("-fx-prompt-text-fill:#888888");
        names.setStyle("-fx-prompt-text-fill:#888888");
        lastNames.setStyle("-fx-prompt-text-fill:#888888");
        email.setStyle("-fx-prompt-text-fill:#888888");
    }




    @FXML
    void viewUser(ActionEvent event) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/User-view.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(root.widthProperty());
        fxml.prefHeightProperty().bind(root.heightProperty());
    }


    @FXML
    void changeView(ActionEvent event) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/MainView/VistaCambios.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(root.widthProperty());
        fxml.prefHeightProperty().bind(root.heightProperty());
    }










    @FXML
    void myProfile(ActionEvent event) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/UserProfile-view.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(root.widthProperty());
        fxml.prefHeightProperty().bind(root.heightProperty());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ObservableList<String> obs = FXCollections.observableArrayList("Administrador","Vendedor");
//        cmRol.setItems(obs);

        //Consulta de usuarios conectados
//        MyTask task=new MyTask();
//        Timer timer=new Timer(true);
//        timer.scheduleAtFixedRate(task,10000,5000);





//        new Thread(() -> showUserTable()).start();






        // do your GUI stuff here
//        Platform.runLater(() -> {
//            showUserTable();
////
//            //Kpi de numero de usuarios en el sistema
//            kpis();
//
//            //Tabla de usuarios Bloqueados
//            showBlockedUsers();
//
//            //Usuarios Conectados de sistema
//            showUsersList();
//
//    //Titulos de la scena
//            new FadeInLeft(labelTitle).play();
//            labelTitle.setVisible(true);
//            new FadeInLeft(labelDescription).play();
//            labelDescription.setVisible(true);
//            FadeTransition fts = new FadeTransition(Duration.millis(300),userTable);
//
//            fts.setFromValue(0);
//            fts.setToValue(1);
//            fts.play();
//
//
//            // Kpis de la escena
//            FadeTransition ft = new FadeTransition(Duration.millis(300), countUsers);
//            FadeTransition fa = new FadeTransition(Duration.millis(300), countActiveUsers);
//            FadeTransition fs = new FadeTransition(Duration.millis(300), countDesactivateUsers);
//            FadeTransition fd = new FadeTransition(Duration.millis(300), countBlockedUsers);
//            ft.setFromValue(0);
//            ft.setToValue(1);
//            fa.setFromValue(0);
//            fa.setToValue(1);
//            fs.setFromValue(0);
//            fs.setToValue(1);
//            fd.setFromValue(0);
//            fd.setToValue(1);
//            SequentialTransition pt = new SequentialTransition(ft,fa,fs,fd);
//            pt.play();
//
//            //Usuarios Conectados de la escena
//            FadeTransition us = new FadeTransition(Duration.millis(300), listUser);
//            us.setFromValue(0);
//            us.setToValue(1);
//            us.play();
//
//
//        });


    }
}
