package com.sfc.appdesktopbodega.Controller.Login.RecoveryPassword;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.sfc.appdesktopbodega.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRecoveryEmailController implements Initializable {
    @FXML
    private Pane validPane;
    @FXML
    public static JFXDialog validDialog;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField email;

    UserRecoveryEmailController stage1controller;





    @FXML
    void btnRecovery(ActionEvent event) throws IOException, SQLException {
        String correoE=email.getText();

        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
                "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(emailPattern);

//        int longitud = 12;
        String token = RandomString.cadenaAleatoria(12);

//        String token = cadenaAleatoria(longitud);
//        System.out.printf("Cadena aleatoria de %d caracteres: %s\n", longitud, token);
        JFXSnackbar snackbar= new JFXSnackbar(stackPane);
        snackbar.setPrefWidth(460);

        if (correoE.isBlank()){
            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("Introduce tu correo")));

        }
        else {
            Matcher matcher = pattern.matcher(correoE);
            if (matcher.matches())
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sfc/appdesktopbodega/Login/UserRecoveryEmailCode.fxml"));
//                validPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/sfc/appdesktopbodega/User/UserRecoveryEmailCode.fxml")));
                validPane= loader.load();

                // Pasar valores a otra Vista-Controlador
                UserRecoveryEmailCode stage2instancia= loader.getController();
                stage2instancia.recibeParametros(stage1controller,correoE);

                validDialog = new JFXDialog(stackPane, validPane, JFXDialog.DialogTransition.CENTER);
                validDialog.show();



                User user = new User();
//                DashboardUserController.sendEmailToken(token, correoE);
                new Thread(() -> {
                    try {
                        user.sendEmailToken(token, correoE);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }).start();

                new Thread(() -> RecoveryPassowrdEmail(token)).start();

            }
             else
             {
                    email.setText("");
                    email.setPromptText("Email no valido");
                    email.setStyle("-fx-prompt-text-fill: rgb(253, 129, 126)");

             }
            }
    }


    public void RecoveryPassowrdEmail(String token) {

        String ms = "<h1 style=\"color:#615FF5\">Recuperar la contraseña</h1>";
        ms+= "<p2 style=\"color:black\">Restablecer su contraseña es fácil. Simplemente escriba el codigo de recuperacion y siga las instrucciones. " +
                "Luego escriba una contraseña que cumpla con los requisitos de seguridad.</p2><br>";
        ms += "<font color=red FONT SIZE=3>El codigo es  : </font>";
        ms+="<font color red FONT SIZE =5 >"+token+"</font>";
     

        final String username = "alexandergdbryan@gmail.com";
        final String password="xspwcnzjgxdmnpmj";
        final String to = email.getText();
        Properties props= System.getProperties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        props.setProperty("mail.debug", "true");

        Session session= Session.getDefaultInstance(props,new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username,password);
            }
        });
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("alexandergdbryan@gmail.com"));
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Restablecimiento de contraseña");
            message.setContent(ms, "text/html; charset=utf-8");
            Transport.send(message);


        }catch (MessagingException e){
            throw new RuntimeException(e);
        }

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
