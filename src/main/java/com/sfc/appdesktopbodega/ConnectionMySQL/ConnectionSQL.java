package com.sfc.appdesktopbodega.ConnectionMySQL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
Connection connection;
    public  Connection getConnection() throws SQLException {

        String connectionUrl = "jdbc:sqlserver://sqlserver02021.database.windows.net:1433;"
                + "database=Muebleria;"
                + "DashboardUserController=adminuser@sqlserver02021;"
                + "password=alexander#123A;"
                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "hostNameInCertificate=*.database.windows.net;"
                + "loginTimeout=30";
        try {

            connection =DriverManager.getConnection(connectionUrl);


        // Handle any errors that may have occurred.
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
