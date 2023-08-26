package com.sfc.appdesktopbodega.Model;
import javafx.concurrent.Task;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ejemplo {


    public static void main(String[] args) {

        Task<Boolean> backgroundTask = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                // Realiza tus consultas SQL aquí


                return null;
            }


        };

        backgroundTask.setOnSucceeded(event -> {
            // Actualiza la interfaz de usuario con los resultados de las consultas
        });

        backgroundTask.setOnFailed(event -> {
            // Maneja cualquier error si es necesario
        });

        Thread backgroundThread = new Thread(backgroundTask);
        backgroundThread.setDaemon(true);
        backgroundThread.start();

    }


    public boolean ValidarUser(String IDROL) throws SQLException {





        return false;

    }


}
