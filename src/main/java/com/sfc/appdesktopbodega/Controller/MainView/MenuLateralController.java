package com.sfc.appdesktopbodega.Controller.MainView;

import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import com.sfc.appdesktopbodega.Controller.Login.LoginController;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuLateralController implements Initializable {

    @FXML
    private AnchorPane paneLateral;
    @FXML
    private AnchorPane paneRoot;
    @FXML
    private BorderPane borderPane;
    @FXML
    private JFXButton btnExit;
    @FXML
    private JFXButton btnManagment;
    @FXML
    private Label texto;

    @FXML
    private JFXButton btnSales;

    @FXML
    private JFXButton btnWarehouse;

    @FXML
    private JFXButton btnCustomers;

    @FXML
    private JFXButton btnProvider;

    @FXML
    private JFXButton btnConfiguration;
    @FXML
    public AnchorPane stackDashboard;

    @FXML
    private HBox ButtonsAction;

    @FXML
    private JFXButton min;

    LoginController stage1stag2;
    Stage stage = null;

    @FXML
    private Label userName;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    private double x = 0;
    private double y = 0;

    private Region fxml;

    public void recibeParametros(LoginController stage1, String texto, String texto1, String texto2, String texto3, String texto4, String texto5, String texto6, String texto7) {
        stage1stag2 = stage1;
        userName.setText(texto);
        System.out.println(texto);
        System.out.println(texto1);
        System.out.println(texto2);
        System.out.println(texto3);
        System.out.println(texto4);
        System.out.println(texto5);
        System.out.println(texto6);
        System.out.println(texto7);

    }

    public void recibeParametros(AnchorPane stackDashboard) {
        this.stackDashboard = stackDashboard;

    }


    @FXML
    void exit(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/sfc/appdesktopbodega/Login/Login-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();
        Stage myStage = (Stage) this.btnExit.getScene().getWindow();
        myStage.close();

    }


    public void initopup() {

//        JFXListView<String> listview= new JFXListView<>();
//
//
//        listview.getItems().add("Administrar usuarios");
//        listview.getItems().add("Agregar usuarios");
//        listview.getItems().add("Vista de acciones");
//        listview.getItems().add("Vista de acciones");
//        listview.getItems().add("Vista de acciones");
//        listview.getItems().add("Vista de acciones");
//        listview.getItems().add("Vista de acciones");
//        listview.getItems().add("Vista de acciones");
//        listview.getItems().add("Vista de acciones");
//        listview.getItems().add("Vista de acciones");
//
//        pruebapane.getChildren().setAll(listview);
    }

//    public void menuPopup(){
//
//        JFXListView<String> listview= new JFXListView<>();
//        listview.getItems().add("Administrar usuarios");
//        listview.getItems().add("Agregar usuarios");
//        listview.getItems().add("Vista de acciones");
//
//        JFXPopup popup = new JFXPopup(listview);
//
////        btnSales.setOnAction(e -> popup.show(btnSales, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT));
//        popup.show(btnManagment, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT,200,-20);
//
//
//        listview.setOnMouseClicked(new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent arg0) {
//                //Check wich list index is selected then set txtContent value for that index
//                if(listview.getSelectionModel().getSelectedIndex() == 0){
//                    try {
//                        userManagement();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//
//                else if(listview.getSelectionModel().getSelectedIndex() == 1){
//                    try {
//                        addUser();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//                else if(listview.getSelectionModel().getSelectedIndex() == 2){
//                    try {
//                        overviewActions();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//
//            }
//
//        });
//
//
//
//
//    }
//


//    void userManagement() throws IOException {
//
//        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/UserDashboard3.fxml"));
//        stackDashboard.getChildren().removeAll();
//        stackDashboard.getChildren().setAll(fxml);
//        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
//        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
//    }
//    void overviewActions() throws IOException {
//        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Dashboard/VistaCambios.fxml"));
//        stackDashboard.getChildren().removeAll();
//        stackDashboard.getChildren().setAll(fxml);
//        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
//        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
//    }
//
//    void addUser() throws IOException {
////        Parent fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/UserRegister3.fxml"));
//        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/UserRegisterPrueba.fxml"));
//        stackDashboard.getChildren().removeAll();
//        stackDashboard.getChildren().setAll(fxml);
//        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
//        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
//
//    }GUARDADOg


    @FXML
    public void openUserManagement() throws IOException {

        //    menuPopup();
//        menus menu=new menus();
//        menu.menuPopup(btnManagment,stackDashboard);

//        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/MainUser.fxml"));
//        stackDashboard.getChildren().removeAll();
//        stackDashboard.getChildren().setAll(fxml);
//        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
//        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());



                fxml = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/MainUser.fxml"));
                stackDashboard.getChildren().removeAll();
                fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
                fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
                stackDashboard.getChildren().setAll(fxml);






    }

    public void vista() {


    }


    @FXML
    void openProvider(ActionEvent event) throws IOException {
        menus menu = new menus();
        menu.provider(stackDashboard);

    }

    @FXML
    void openSales(ActionEvent event) throws IOException {
//        menus menu=new menus();
//        menu.sales(stackDashboard);

        Region fxml = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Sale/MainSale.fxml"));
        stackDashboard.getChildren().removeAll();
        stackDashboard.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
    }

    @FXML
    void openWarehouse(ActionEvent event) throws IOException {
//        menus menu=new menus();
//        menu.warehouse(stackDashboard);
        Region fxml = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Product/MainProduct.fxml"));
        stackDashboard.getChildren().removeAll();
        stackDashboard.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
    }

    @FXML
    void openConfiguration(ActionEvent event) throws IOException {
        menus menu = new menus();
        menu.configuration(stackDashboard);
    }

    @FXML
    void openCustomers(ActionEvent event) throws IOException {
//        menus menu=new menus();
//        menu.custormers(stackDashboard);

        Region fxml = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Customer/MainCustomer.fxml"));
        stackDashboard.getChildren().removeAll();
        stackDashboard.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
    }


    @FXML
    void maximize(ActionEvent event) {
        stage = (Stage) borderPane.getScene().getWindow();
        if (stage.isMaximized()) {
            stage.setMaximized(false);

        } else {
            new FadeIn(borderPane).play();
            stage.setMaximized(true);
        }


    }

    @FXML
    void minimize(ActionEvent event) {
        stage = (Stage) borderPane.getScene().getWindow();
        stage.setIconified(true);
//        new ZoomOutDown(paneRoot).play();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            // TODO
            AnchorPane box = FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/MainView/MenuOptions.fxml"));
            drawer.setSidePane(box);
            drawer.setMinWidth(0); // this is the new code added
//            drawer.prefHeightProperty().bind(paneLateral.heightProperty());

        } catch (IOException ex) {
            Logger.getLogger(MenuLateralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
            drawer.toggle();
            drawer.toBack();

        });
        drawer.setOnDrawerOpening((event) -> {
            drawer.setVisible(true);

            task.setRate(task.getRate() * -1);
            task.play();

            // Empuja el drawer a lado derecho cambio el tamaño del stackdashboard
//             drawer.setMinWidth(145);

            //-----------------------------------------------------------------
//            drawer.prefHeightProperty().bind(paneLateral.heightProperty());

            //Drawer toma el tamaño del otro componente Anchorpane
//            AnchorPane.setBottomAnchor(drawer,0.0);

//            drawer.setMaxWidth(200);
//            drawer.setPrefWidth(200);
//            drawer.setMaxWidth(255);
        });
        drawer.setOnDrawerClosed((event) -> {
            task.setRate(task.getRate() * -1);
            task.play();

            // Empuja el drawer a lado derecho cambio el tamaño del stackdashboard
//             drawer.setMinWidth(0);

            //-----------------------------------------------------------------

        });


// *MENU TOP AGREGADO DESDE OTRO FXML

//        try {
////            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("/com/sfc/appdesktopbodega/User/UserRegister3.fxml"));
////            FXMLLoader fxml = new FXMLLoader(getClass().getResource("./User/UserRegister3.fxml"));
//
//            Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/menuTOP.fxml"));
//            stackDashboard.getChildren().removeAll();
//            stackDashboard.getChildren().setAll(fxml);
//
//            fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
//            fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
////
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//
        borderPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
            }
        });


        borderPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) borderPane.getScene().getWindow();
                stage.setY(event.getScreenY() - y);
                stage.setX(event.getScreenX() - x);
            }
        });

    }


}
