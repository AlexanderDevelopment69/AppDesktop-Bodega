package com.sfc.appdesktopbodega.Controller.Login;


import animatefx.animation.FadeIn;
import com.jfoenix.controls.*;

import com.sfc.appdesktopbodega.Controller.MainView.MenuLateralController;
import com.sfc.appdesktopbodega.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Pane validPane;
    @FXML
    public static JFXDialog validDialog;
    @FXML
    private StackPane stackPane;
    @FXML
    private Pane pane;
    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField username;
    @FXML
    private JFXButton btnIngresar;






    @FXML
    void login() throws SQLException, IOException {
//        User DashboardUserController=new User(username.getText(),password.getText());
//        User user =new User(username.getText(),password.getText());
        User user=new User("74118606","alexander#123A");
        int intentos;
        intentos= user.addUserAttemptFailed();
        if((user.ValidarUser("1")||user.ValidarUser("2")) && intentos <= user.getUsuarioIntentos()){

//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./User/UserRegister3.fxml"));
                user.deleteAttemptFailed();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sfc/appdesktopbodega/MainView/MenuLateral-viewDrawPane.fxml"));
                Parent root = loader.load();
                // Pasar valores a otra Vista-Controlador
                MenuLateralController stage2instancia= loader.getController();
//            stage2instancia.recibeParametros(loginController,DashboardUserController.getIdRol(),DashboardUserController.getDni(),DashboardUserController.getLastNames(),DashboardUserController.getIdUser(),DashboardUserController.getIdRol(),DashboardUserController.getPassword(),DashboardUserController.getEmail(),DashboardUserController.getUserName());

                Stage stage = new Stage();
                stage.initStyle( StageStyle.UNDECORATED );
//                stage.setFullScreen(true);

                Scene scene=new Scene(root);
                 new FadeIn(root).play();

                scene.setFill(Color.rgb(97, 95, 245));

                stage.setScene(scene);
//                stage.setScene(new Scene(root));
                stage.show();
                Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
                myStage.close();

//                FXResizeHelper.addResizeListener(stage);




        }

        else{
            error();
            if(intentos==2){
                try {
                    validPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/sfc/appdesktopbodega/Alerts/Captcha.fxml")));

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

                validDialog = new JFXDialog(stackPane, validPane, JFXDialog.DialogTransition.CENTER);

                validDialog.show();

            }
            if(intentos > user.getUsuarioIntentos()){
                JFXSnackbar snackbar= new JFXSnackbar(pane);
                snackbar.setPrefWidth(603);
                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Intento superados")));

            }
            if((user.ValidarUser("3")||user.ValidarUser("4")) ){
                JFXSnackbar snackbar= new JFXSnackbar(pane);
                snackbar.setPrefWidth(603);

                snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Usuario Deshabilitado")));

            }

        }


        }


    @FXML
    void ingresarKey(KeyEvent event) throws SQLException, IOException{

        if (event.getCode().equals(KeyCode.ENTER)) {
            login();

        }
    }


    public void error(){
        JFXSnackbar snackbar= new JFXSnackbar(pane);
        snackbar.setPrefWidth(603);
        snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Usuario o contraseña incorrecta")));

    }

    @FXML
    void exit() {
       System.exit(0);


    }
    @FXML
    void recoveryUserPassword() {
        try {
            validPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/sfc/appdesktopbodega/Login/UserRecoveryEmail.fxml")));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        validDialog = new JFXDialog(stackPane, validPane, JFXDialog.DialogTransition.CENTER);
        validDialog.show();

    }

    @FXML
    void signUp(ActionEvent event) {

        try {
            validPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/sfc/appdesktopbodega/Login/SignUp-view.fxml")));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        validDialog = new JFXDialog(stackPane, validPane, JFXDialog.DialogTransition.CENTER);
        validDialog.show();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}