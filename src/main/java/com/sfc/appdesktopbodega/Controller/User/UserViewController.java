package com.sfc.appdesktopbodega.Controller.User;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTextField;
import com.sfc.appdesktopbodega.Model.User;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class UserViewController implements Initializable {

    @FXML
    private AnchorPane stackDashboard;

    @FXML
    private MFXLegacyTableView<User> userTable;

//    @FXML
//    private TableView<User> userTable;

    @FXML
    private TableColumn<?, ?> tbCode;

    @FXML
    private TableColumn<?, ?> tbDni;

    @FXML
    private TableColumn<?, ?> tbLastNames;

    @FXML
    private TableColumn<?, ?> tbNames;

    @FXML
    private TableColumn<?, ?> tbEmail;




    @FXML
    private StackPane MenuDrawerADDUser;

    @FXML
    private ImageView photo;
    @FXML
    private JFXTextField code;
    @FXML
    private JFXTextField dni;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField names;

    @FXML
    private JFXTextField lastNames;

    @FXML
    private JFXDrawer drawer;





    @FXML
    void updateUser(ActionEvent event) throws SQLException {


        User user=userTable.getSelectionModel().getSelectedItem();
        if (user==null) {
            JOptionPane.showMessageDialog(null,"Selecciona un usuario");
        } else {

//            user.UpdateUser(names.getText(),lastNames.getText());
//            showUserTable();
//            JOptionPane.showMessageDialog(null,"Usuario Actualizado");

        }

    }
    @FXML
    void deleteUser(ActionEvent event) throws SQLException {

        User user=userTable.getSelectionModel().getSelectedItem();

        if (user==null) {
            JOptionPane.showMessageDialog(null,"Selecciona un usuario");
        } else {

           user.DeleteUser();
           showUserTable();
           JOptionPane.showMessageDialog(null,"Usuario Eliminado Correctamente");

        }



    }

    @FXML
    void selectionUser(MouseEvent event) throws SQLException {
        User user=userTable.getSelectionModel().getSelectedItem();
        if(user==null){
        }
        else {
            code.setText(user.getIdUser());
            dni.setText(user.getDni());
            names.setText(user.getNames());
            lastNames.setText(user.getLastNames());
            email.setText(user.getEmail());


            user.GetPhotoUser(user.getIdUser());;
            photo.setImage(user.getImage());






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
    }



    public void showUserTable(){

//        ObservableList<User> UserTable;
//        UserTable = FXCollections.observableArrayList();
        tbCode.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        tbDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tbLastNames.setCellValueFactory(new PropertyValueFactory<>("lastNames"));
        tbNames.setCellValueFactory(new PropertyValueFactory<>("names"));
        tbEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        try {
            User user=new User();
            ObservableList<User> items=user.GetDataUser();
            this.userTable.setItems(items);
            userTable.refresh();
        } catch (SQLException e) {
            System.out.println(e);;
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


         showUserTable();


    }
}
