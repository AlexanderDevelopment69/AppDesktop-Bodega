package com.sfc.appdesktopbodega.Controller.Audit;


import com.sfc.appdesktopbodega.Model.User;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyTableView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserAudit implements Initializable {

    @FXML
    private AnchorPane stackDashboard;

    @FXML
    private MFXLegacyTableView<User> userAuditTable;

    @FXML
    private TableColumn<?, ?> tbChangeId;

    @FXML
    private TableColumn<?, ?> tbUser;

    @FXML
    private TableColumn<?, ?> tbPassword;

    @FXML
    private TableColumn<?, ?> tbName;

    @FXML
    private TableColumn<?, ?> tbNewName;

    @FXML
    private TableColumn<?, ?> tbRolOLD;

    @FXML
    private TableColumn<?, ?> tbRolNEW;

    @FXML
    private TableColumn<?, ?> tbFecha;

    @FXML
    private TableColumn<?, ?> tbAction;

    @FXML
    private TableColumn<?, ?> tbHost;

    public void showUserTable(){

        tbNewName.setStyle("-fx-text-fill: green");
        tbRolNEW.setStyle("-fx-text-fill: green");
        tbAction.setStyle("-fx-text-fill: green");

        tbChangeId.setCellValueFactory(new PropertyValueFactory<>("idAudit"));
        tbUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        tbPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tbName.setCellValueFactory(new PropertyValueFactory<>("names"));
        tbNewName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        tbRolOLD.setCellValueFactory(new PropertyValueFactory<>("idRol"));
        tbRolNEW.setCellValueFactory(new PropertyValueFactory<>("rolNew"));
        tbFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tbAction.setCellValueFactory(new PropertyValueFactory<>("auditAction"));
        tbHost.setCellValueFactory(new PropertyValueFactory<>("auditHost"));

        try {
            User user=new User();
            ObservableList<User> items=user.GetDataUserAudit();
            this.userAuditTable.setItems(items);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);;
        }

    }

    @FXML
    void searchChanges(KeyEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


            showUserTable();
    }
}
