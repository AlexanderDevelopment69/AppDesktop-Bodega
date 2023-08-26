package com.sfc.appdesktopbodega.ConnectionMySQL;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMYSQL {
    Connection connection;
    public Connection getConnection() throws SQLException {


        String dbName = "bodega";
        String userName = "root";
        String password = "alexander";
        String ip="192.168.88.10";
//        String ip="20.51.242.204";

        try{

        Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.setLoginTimeout(3);

        connection = DriverManager.getConnection("jdbc:mysql://"+ip+"/" + dbName,userName,password);

//        String dbName = "Bodega";
//        String userName = "root";
//        String password = "43982498@@mysql";
//
//        try{
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            DriverManager.setLoginTimeout(3);
//
//            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName,userName,password);





//        connection.setNetworkTimeout(Executors.newSingleThreadExecutor(), 100000);
//            connection = DriverManager.getConnection("jdbc:mysql://52.186.140.134/" + "muebleria","root","adminuser123");
//            String url ="jdbc:mysql://cloudmysql2021.mysql.database.azure.com:3306/muebleria?useSSL=true&requireSSL=false"; connection = DriverManager.getConnection(url, "superadmin@cloudmysql2021", "adminUser123");
//            String url ="jdbc:mysql://mysql2023.mysql.database.azure.com:3306/muebleria?useSSL=true&requireSSL=false"; connection = DriverManager.getConnection(url, "alexanderadmin@mysql2023", "alexander#123A");
    }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();

        }


        return connection;
    }
}
