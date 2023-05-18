package com.sfc.appdesktopbodega.Controller.MainView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.sfc.appdesktopbodega.Controller.Alerts.ResizeHeightTranslation;
import io.github.palexdev.materialfx.controls.MFXTreeItem;
import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

import static javafx.scene.paint.Color.rgb;

public class menus {

   void menuPopup(JFXButton btnManagment, AnchorPane stackDashboard) throws IOException {



        JFXListView<String> listview= new JFXListView<>();
        listview.getItems().add("Administrar usuarios");
        listview.getItems().add("Agregar usuarios");
        listview.getItems().add("Vista de acciones");

        JFXPopup popup = new JFXPopup();
        popup.setPopupContent(listview);
//        btnSales.setOnAction(e -> popup.show(btnSales, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT));
       popup.show(btnManagment, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT,200,-20);

        listview.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
                //Check wich list index is selected then set txtContent value for that index
                if(listview.getSelectionModel().getSelectedIndex() == 0){
                    try {
                        userManagement(stackDashboard);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

                else if(listview.getSelectionModel().getSelectedIndex() == 1){
                    try {
                        addUser(stackDashboard);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                else if(listview.getSelectionModel().getSelectedIndex() == 2){
                    try {
                        overviewActions(stackDashboard);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }

        });




    }

    public MFXTreeItem<String> createRoot() {
        MFXTreeItem<String> root = new MFXTreeItem<>("Tree View Root");
        MFXTreeItem<String> item1 = new MFXTreeItem<>("Administracion");
        item1.getItems().addAll(List.of(
                        new MFXTreeItem<>("ITEM1-Sub1"),
                        new MFXTreeItem<>("ITEM1-Sub2")
                )
        );

        MFXTreeItem<String> item2 = new MFXTreeItem<>("Ventas");
        item2.getItems().addAll(List.of(
                        new MFXTreeItem<>("ITEM2-Sub1"),
                        new MFXTreeItem<>("ITEM2-Sub2"),
                        new MFXTreeItem<>("ITEM2-Sub3"),
                        new MFXTreeItem<>("ITEM2-Sub4")
                )
        );

        MFXTreeItem<String> item3 = new MFXTreeItem<>("Almacen");

        MFXTreeItem<String> item4 = new MFXTreeItem<>("Clientes");
        item4.getItems().add(
                new MFXTreeItem<>("ITEM4-Sub1")
        );

        MFXTreeItem<String> item5 = new MFXTreeItem<>("Proveedores");
        item5.getItems().addAll(List.of(
                        new MFXTreeItem<>("ITEM5-Sub1"),
                        new MFXTreeItem<>("ITEM5-Sub2"),
                        new MFXTreeItem<>("ITEM5-Sub3")
                )
        );
        MFXTreeItem<String> item6 = new MFXTreeItem<>("Configuracion");
        item6.getItems().addAll(List.of(
                        new MFXTreeItem<>("ITEM5-Sub1"),
                        new MFXTreeItem<>("ITEM5-Sub2"),
                        new MFXTreeItem<>("ITEM5-Sub3")
                )
        );
        root.getItems().addAll(List.of(item1, item2, item3, item4, item5));
        return root;
    }









    void userManagement(AnchorPane stackDashboard) throws IOException {

        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/MainUser.fxml"));
        stackDashboard.getChildren().removeAll();
        stackDashboard.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
    }
    void overviewActions(AnchorPane stackDashboard) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/MainView/VistaCambios.fxml"));
        stackDashboard.getChildren().removeAll();
        stackDashboard.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
    }

    void addUser(AnchorPane stackDashboard) throws IOException {
//        Parent fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/UserRegister3.fxml"));
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/User/User-view.fxml"));
        stackDashboard.getChildren().removeAll();
        stackDashboard.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());

    }






    void provider(AnchorPane stackDashboard) throws IOException {

//
//        Group root = new Group(rect);
//        stackDashboard.getChildren().add(root);

        Rectangle rect = new Rectangle (400,500 , 30, 30);
        rect.setArcHeight(100);
        rect.setArcWidth(100);
        rect.setFill(rgb(97, 95, 245));
        ScaleTransition st = new ScaleTransition(Duration.millis(1000), rect);
        st.setByX(40);
        st.setByY(40);

        st.setAutoReverse(true);
        st.play();
        stackDashboard.getChildren().add(rect);


//        root.getChildren().add(rect);
//        root.getChildren().addAll(rect,text);
//        stackDashboard.setStyle("-fx-background-color: white");
//        FadeTransition ft = new FadeTransition(Duration.millis(500), stackDashboard);
//        ft.setFromValue(0);
//        ft.setToValue(1);
//        SequentialTransition pt = new SequentialTransition(st,ft);
//        pt.play();

//        root.getChildren().add(stackDashboard);
//

//        stackDashboard.prefHeightProperty().bind(rect.heightProperty());
//        rect.heightProperty().bind(stackDashboard.heightProperty());
//        rect.widthProperty().bind(stackDashboard.widthProperty());





//        FadeTransition ft = new FadeTransition(Duration.millis(300), stackDashboard);
//        ft.setFromValue(0);
//        ft.setToValue(1);
//        SequentialTransition pt = new SequentialTransition(ft);
//        pt.play();
//

//        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Provider/ProviderDashboard.fxml"));
//        stackDashboard.getChildren().removeAll();
//        stackDashboard.getChildren().setAll(fxml);
//        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
//        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
    }


    void sales(AnchorPane stackDashboard) throws IOException {
//       stackDashboard.setStyle("-fx-background-color: RED");

        Pane pane=new Pane();
        pane.setStyle("-fx-background-color: red");
        pane.setMinHeight(200);

        ResizeHeightTranslation rht = new ResizeHeightTranslation(Duration.millis(600), pane,400 );



        rht.play();
//        stackDashboard.getChildren().add(pane);
        stackDashboard.getChildren().add(pane);
//        stackDashboard.maxHeightProperty().bind(pane.heightProperty());
//        stackDashboard.maxWidthProperty().bind(pane.widthProperty());


//
//        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Sales/SaleDashboard.fxml"));
//        stackDashboard.getChildren().removeAll();
//        stackDashboard.getChildren().setAll(fxml);
//        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
//        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
    }


    void warehouse(AnchorPane stackDashboard) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/WareHouse/warehouseDashboard.fxml"));
        stackDashboard.getChildren().removeAll();
        stackDashboard.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
    }


    void configuration(AnchorPane stackDashboard) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Configuration/ConfigurationDashboard.fxml"));
        stackDashboard.getChildren().removeAll();
        stackDashboard.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
    }


    void custormers(AnchorPane stackDashboard) throws IOException {
        Region fxml= FXMLLoader.load(getClass().getResource("/com/sfc/appdesktopbodega/Customer/CustomerDashboard.fxml"));
        stackDashboard.getChildren().removeAll();
        stackDashboard.getChildren().setAll(fxml);
        fxml.prefWidthProperty().bind(stackDashboard.widthProperty());
        fxml.prefHeightProperty().bind(stackDashboard.heightProperty());
    }


}
