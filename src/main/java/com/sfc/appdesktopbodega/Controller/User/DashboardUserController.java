package com.sfc.appdesktopbodega.Controller.User;

import animatefx.animation.FadeInLeft;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import com.sfc.appdesktopbodega.Controller.Alerts.AlertsController;
import com.sfc.appdesktopbodega.Model.User;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyListView;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javafx.util.Duration;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.TimerTask;

public class DashboardUserController implements Initializable {




    @FXML
    private StackPane stackDashboard;
    @FXML
    private Label countUsers;
    @FXML
    private Label countActiveUsers;
    @FXML
    private Label countDesactivateUsers;
    @FXML
    private Label countBlockedUsers;
    @FXML
    private JFXTextField search;
    @FXML
    private MFXLegacyTableView<User> userTable;

    @FXML
    private TableColumn<?,?> tbCode;

    @FXML
    private TableColumn<?,?> tbDni;

    @FXML
    private TableColumn<?,?> tbLatNames;

    @FXML
    private TableColumn<?,?> tbNames;

    @FXML
    private TableColumn<User,String> tbState;

    @FXML
    private TableColumn<?,?> tbRol;

    @FXML
    private TableColumn<?,?> tbFecha;

    @FXML
    private TableColumn<User,String> tbActions;

    //BloquedUsers ---- Tabla de usuarios bloqueados

    @FXML
    private MFXLegacyTableView<User> BlockedUserTable;
    @FXML
    private TableColumn<?, ?> tbBlockedDni;

    @FXML
    private TableColumn<?, ?> tbBlockedNames;

    @FXML
    private TableColumn<?, ?> tbBlockedAttemps;

    @FXML
    private TableColumn<User, String> tbBlockedActions;

    @FXML
    public Label labelTitle;

    @FXML
    private Label labelDescription;

    @FXML
    private MFXLegacyListView<Label> listUser;


    AlertsController alertsController=new AlertsController();


    public void showUserTable() {
//        ObservableList<User> UserTable;
//        UserTable = FXCollections.observableArrayList();
//        tbState.setStyle("-fx-text-fill: green");
//            String a= "Activo";






        tbCode.setCellValueFactory(new PropertyValueFactory<>("IdUser"));
        tbDni.setCellValueFactory(new PropertyValueFactory<>("Dni"));
        tbLatNames.setCellValueFactory(new PropertyValueFactory<>("LastNames"));
        tbState.setCellValueFactory(new PropertyValueFactory<>("Estado"));
        tbNames.setCellValueFactory(new PropertyValueFactory<>("Names"));
        tbRol.setCellValueFactory(new PropertyValueFactory<>("IdRol"));
        tbFecha.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
//        tbActions.setCellValueFactory(new PropertyValueFactory<>("buttonActivate"));


        try {
            User user=new User();
            ObservableList<User> items=user.GetDataUser();
            this.userTable.setItems(items);
        } catch (SQLException e) {
            System.out.println(e);;
        }

        Callback<TableColumn<User, String>, TableCell<User, String>> cellFoctory = (TableColumn<User, String> param) -> {
            final TableCell<User, String> cell = new TableCell<>() {

                public void updateItem(String item, boolean empty) {

                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        JFXButton buttonActivate, buttonDesactivate;
                        buttonActivate = new JFXButton("Activar");
                        buttonActivate.setStyle("-fx-background-color: transparent; -fx-text-fill:#14D965;-fx-font-size: 12px; -fx-border-color: #14D965");
                        buttonDesactivate = new JFXButton("Desactivar");
                        buttonDesactivate.setStyle("-fx-background-color: transparent; -fx-text-fill:#FD433E;-fx-font-size: 12px;-fx-border-color: #FD433E ");


                        HBox paneBox = new HBox(buttonActivate, buttonDesactivate);
                        paneBox.setStyle("-fx-alignment:center; -fx-background-color: transparent");

                        HBox.setMargin(buttonActivate, new Insets(2, 2, 0, 3));
                        HBox.setMargin(buttonDesactivate, new Insets(2, 3, 0, 2));
                        setGraphic(paneBox);



                        buttonActivate.setOnMouseClicked((MouseEvent events) -> {
                            User user=userTable.getSelectionModel().getSelectedItem();
                            if(user==null){
                                alertsController.Alert("Mensaje","Selecciona un usuario",stackDashboard);
//                               buttonActivate.setOnAction(event -> NotificationsManager.send(NotificationPos.TOP_CENTER,createNotification("Action 3 Performed")));


                            }else{
                                try {

                                    if(user.getIdRol().equals("Administrador")){
                                        user.updateROl(1);
                                    }
                                    if(user.getIdRol().equals("Vendedor")){
                                        user.updateROl(2);
                                    }
                                    kpis();


//                                       DashboardUserController.updateROl(2);
//                                   System.out.println(DashboardUserController.getIdRol());


                                    showUserTable();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                            }


                        });


                        buttonDesactivate.setOnMouseClicked((MouseEvent event) -> {
                            User user=userTable.getSelectionModel().getSelectedItem();
                            if(user==null){
                                alertsController.Alert("Mensaje","Selecciona un usuario",stackDashboard);

                            }else{
                                try {
                                    if(user.getIdRol().equals("Administrador")){
                                        user.updateROl(3);
                                    }
                                    if(user.getIdRol().equals("Vendedor")){
                                        user.updateROl(4);
                                    }
                                    kpis();
                                    showUserTable();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                            }




                        });

                    }


                }
            };
            return cell;
        };
        tbActions.setCellFactory(cellFoctory);


//
//        Callback<TableColumn<User, String>, TableCell<User, String>> cellFoctorys = (TableColumn<User, String> param) -> {
//            final TableCell<User, String> cell = new TableCell<>() {
//                public void updateItem(String item, boolean empty) {
//
//                    if (empty) {
//                        setGraphic(null);
//                        setText(null);
//
//                    } else {
//
//
//                        Label fields =new Label();
//                        fields.setStyle("-fx-background-color : #14D965;-fx-alignment:center; -fx-background-radius:10px;-fx-text-fill:white; -fx-pref-width:70px; -fx-padding: 3 3 3 3");
//                        HBox paneBox = new HBox(fields);
//                        paneBox.setStyle("-fx-alignment:center; -fx-background-color: transparent");
//
//                        HBox.setMargin(fields, new Insets(2, 2, 0, 3));
//                        setGraphic(paneBox);
//
//                    }
//
//
//                }
//            };
//            return cell;
//        };
//        tbState.setCellFactory(cellFoctorys);

    }


    public void kpis()  {
        try {
            User user = new User();
            user.dashboardKPI();
            countUsers.setText(user.getTotalUsers());
            countActiveUsers.setText(user.getTotalUsersActivate());
            countDesactivateUsers.setText(user.getTotalUsersDesactivate());
            countBlockedUsers.setText(user.getBlockedUsers());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchUser(KeyEvent event) {
        String Buscar=search.getText();
        try {
            User user=new User();
            ObservableList<User> items=user.search(Buscar);
            this.userTable.setItems(items);
            userTable.refresh();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void showBlockedUsers(){
//        ObservableList<User> UserTable;
//        UserTable = FXCollections.observableArrayList();
        tbBlockedAttemps.setStyle("-fx-text-fill: red");
        tbBlockedDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tbBlockedNames.setCellValueFactory(new PropertyValueFactory<>("Names"));
        tbBlockedAttemps.setCellValueFactory(new PropertyValueFactory<>("UsuarioIntentos"));

        FadeTransition ft = new FadeTransition(Duration.millis(300), BlockedUserTable);

        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();

        try {
            User user=new User();
            ObservableList<User> items=user.GetDataBlockedUser();
            this.BlockedUserTable.setItems(items);
            BlockedUserTable.refresh();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);;
        }


        Callback<TableColumn<User, String>, TableCell<User, String>> cellFoctory = (TableColumn<User, String> param) -> {
            final TableCell<User, String> cell = new TableCell<>() {

                public void updateItem(String item, boolean empty) {

                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        JFXButton buttonUnBlocked;
                        buttonUnBlocked = new JFXButton("Desbloquear");
                        buttonUnBlocked.setStyle("-fx-background-color:TRANSPARENT; -fx-text-fill:BLACK ;-fx-font-size: 12px;-fx-border-color: black");


                        HBox paneBox = new HBox(buttonUnBlocked);
                        paneBox.setStyle("-fx-alignment:center; -fx-background-color: transparent");

                        HBox.setMargin(buttonUnBlocked, new Insets(2, 2, 0, 3));
                        setGraphic(paneBox);


                        buttonUnBlocked.setOnMouseClicked((MouseEvent event) -> {
                            User user=BlockedUserTable.getSelectionModel().getSelectedItem();
                            if(user==null){
                                alertsController.Alert("Mensaje","Selecciona un usuario",stackDashboard);

                            }else{
                                try {
                                    user.deleteAttemptFailed();
                                    showBlockedUsers();
                                    kpis();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                            }


                        });


                    }


                }
            };
            return cell;
        };

        tbBlockedActions.setCellFactory(cellFoctory);

    }


    public void showUsersList() {

        try {
            User user = new User();
            ObservableList<String> items = user.GetDataOnlineUsers();
//    System.out.println(items);
//    for (int i = 0; i < items.size(); i++) {
//        System.out.println(items.get(i));

//}


            ObservableList<Label> values = FXCollections.observableArrayList();

            Label[] l = new Label[items.size()];
            for (int i = 0; i < items.size(); i++) {
                values.addAll(l[i] = createLegacyLabel(items.get(i)));
            }

            listUser.setItems(values);




        } catch (SQLException e) {
            e.printStackTrace();
        }








//    ObservableList<Label> labelsList = FXCollections.observableArrayList(List.of(
//
//            createLegacyLabel(items.get(0)),
//            createLegacyLabel(items.get(1))
////            createLegacyLabel("Label 1"),
////            createLegacyLabel("Label 2"),
////            createLegacyLabel("Label 3"),
////            createLegacyLabel("Label 4"),
////            createLegacyLabel("Label 5"),
////            createLegacyLabel("Label 6"),
////            createLegacyLabel("Label 9")
////            createLegacyLabel("Label 9", "/Images/pointGreen.png"),
//
//
////    createLegacyLabel()
//
//
//
//
//
//    ));
//    userList.setItems(labelsList);



//    FadeTransition ft = new FadeTransition(Duration.millis(300), userList);
//    ft.setFromValue(0);
//    ft.setToValue(1);
//    ft.play();

    }

    class MyTask extends TimerTask {
        @Override
        public void run(){
            Platform.runLater(()->{

                showUsersList();

            });


        }
    }



    private Label createLegacyLabel(String text)  {

        ImageView item = new ImageView("/com/sfc/appdesktopbodega/Images/pointGreen.png");
        item.setFitHeight(10);
        item.setFitWidth(10);
        item.setPreserveRatio(true);
        Label label = new Label(text);
        label.setStyle("-fx-background-color: transparent");
        label.setGraphic(item);
        label.setGraphicTextGap(10);
        label.setPadding(new Insets(5,0,5,20));
        return label;
    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Consulta de usuarios conectados
//        MyTask task=new MyTask();
//        Timer timer=new Timer(true);
//        timer.scheduleAtFixedRate(task,10000,5000);

//         showUsersList();
//
//
//
//
//        //Tabla de usuarios
//        showUserTable();
////
//        //Kpi de numero de usuarios en el sistema
//        kpis();
//
//        //Tabla de usuarios Bloqueados
//        showBlockedUsers();

        // do your GUI stuff here
        Platform.runLater(() -> {
            showUserTable();
//
            //Kpi de numero de usuarios en el sistema
            kpis();

            //Tabla de usuarios Bloqueados
            showBlockedUsers();

            //Usuarios Conectados de sistema
            showUsersList();

            //Titulos de la scena
            new FadeInLeft(labelTitle).play();
            labelTitle.setVisible(true);
            new FadeInLeft(labelDescription).play();
            labelDescription.setVisible(true);
            FadeTransition fts = new FadeTransition(Duration.millis(300),userTable);

            fts.setFromValue(0);
            fts.setToValue(1);
            fts.play();


            // Kpis de la escena
            FadeTransition ft = new FadeTransition(Duration.millis(300), countUsers);
            FadeTransition fa = new FadeTransition(Duration.millis(300), countActiveUsers);
            FadeTransition fs = new FadeTransition(Duration.millis(300), countDesactivateUsers);
            FadeTransition fd = new FadeTransition(Duration.millis(300), countBlockedUsers);
            ft.setFromValue(0);
            ft.setToValue(1);
            fa.setFromValue(0);
            fa.setToValue(1);
            fs.setFromValue(0);
            fs.setToValue(1);
            fd.setFromValue(0);
            fd.setToValue(1);
            SequentialTransition pt = new SequentialTransition(ft,fa,fs,fd);
            pt.play();

            //Usuarios Conectados de la escena
            FadeTransition us = new FadeTransition(Duration.millis(300), listUser);
            us.setFromValue(0);
            us.setToValue(1);
            us.play();


        });





//        for (int i = 0; i < userTable.getItems().size(); i++) {
//            System.out.println(userTable.getItems().get(i).getEstado().toString());
//            if(userTable.getItems().get(i).getEstado().equals("Activo")){
//                if(tbState.getText().equals("Activo")){
//
//                    tbState.setStyle("-fx-text-fill: green");
//                }
//
//            }
//            if(userTable.getItems().get(i).getEstado().equals("Desactivado")){
//                if( tbState.getText().equals("Desactivado")){
//                    tbState.setStyle("-fx-text-fill: red");
//                }
//            }
//
//
//            if(userTable.getItems().get(i).equals("Activo")){
//
//
//            }
//        }

    }
}


