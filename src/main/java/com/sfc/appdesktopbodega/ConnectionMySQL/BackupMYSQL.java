package com.sfc.appdesktopbodega.ConnectionMySQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BackupMYSQL {
   public void backup(){
        try {


            /* - Datos de acceso a nuestra base de datos */
            /* Usa localhost si el servidor corre en la misma maquina, de lo
            contrario utiliza la IP o dirección del sevidor*/
            String ssh="ssh -i C:\\Users\\Alexander/.ssh/id_rsa alexander@192.168.88.10";
            String dbServer = "192.168.88.13";
            /* El usuario de tu base de datos*/
            String dbName = "Muebleria";
            /* El usuario de tu base de datos*/
            String dbUser = "root";
            /* La contraseña de la base de datos (dejarla en texto plano puede
            ser un problema)*/
            String dbPass = "alexander";

            /*El nombre o ruta a donde se guardara el archivo de volcado .sql*/
            String sqlFile = "/home/alexander/Documentos/alexander.sql";

            /* La linea de comando completa que ejecutara el programa*/
            String command = ssh+" mysqldump -u " + dbUser
                    + " -p" + dbPass + " " + dbName + " -r " + sqlFile;

            /*Se crea un proceso que ejecuta el comando dado*/
            Process bck = Runtime.getRuntime().exec(command);

            /* Obtiene el flujo de datos del proceso, esto se hace para obtener
            el texto del proceso*/
            InputStream stdout = bck.getErrorStream();

            /* Se obtiene el resultado de finalizacion del proceso*/
            int resultado = bck.waitFor();

            String line;

            /* Se crea un buffer de lectura con el flujo de datos outstd y ese mismo
            sera leido e impreso, esto mostrara el texto que muestre el programa
            mysqldump, de esta forma sabra cual es el error en su comando*/
            BufferedReader brCleanUp
                    = new BufferedReader(new InputStreamReader(stdout));
            while ((line = brCleanUp.readLine()) != null) {
                System.out.println(line);
            }
            brCleanUp.close();

            if (resultado == 0) {
                System.out.println("Respaldo exitoso");
            } else {
                System.out.println("Error al respaldar");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

    }
}
