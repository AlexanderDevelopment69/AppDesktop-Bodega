package com.sfc.appdesktopbodega.Controller.Alerts;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void main(String[] args) {

        // change accordingly
        final String username = "alexandergdbryan@gmail.com";

        // change accordingly
        final String password = "alexanderbryan666";

        // or IP address
        final String host = "localhost";

        // Get system properties
        Properties props = new Properties();

        // enable authentication
        props.put("mail.smtp.auth", "true");

        // enable STARTTLS
        props.put("mail.smtp.starttls.enable", "true");

        // Setup mail server
        props.put("mail.smtp.host", "smtp.gmail.com");

        // TLS Port
        props.put("mail.smtp.port", "587");

        // creating Session instance referenced to
        // Authenticator object to pass in
        // Session.getInstance argument
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    //override the getPasswordAuthentication method
                    protected PasswordAuthentication
                    getPasswordAuthentication() {

                        return new PasswordAuthentication(username,
                                password);
                    }
                });

        try {

            // compose the message
            // javax.mail.internet.MimeMessage class is
            // mostly used for abstraction.
            Message message = new MimeMessage(session);

            // header field of the header.
            message.setFrom(new InternetAddress("alexandergdbryan@gmail.com"));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("74118606@continental.edu.pe"));
            message.setSubject("Restablecimiento de contraseña");
            message.setText("El codigo es : 12334445");

            Transport.send(message);         //send Message



        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }}