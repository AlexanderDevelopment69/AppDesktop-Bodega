package com.sfc.appdesktopbodega.ConnectionMySQL;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
       ConnectionMYSQL ConnectionClass =new ConnectionMYSQL();
        Connection connection=ConnectionClass.getConnection();

        //Conexion SQLDATABASE
//        ConnectionSQL ConnectionClass= new ConnectionSQL();
//        Connection connection=ConnectionClass.getConnection();


//        try( Connection connection=ConnectionClass.getConnection();){
//
//            JOptionPane.showMessageDialog(null,"Conexion Exitosa");
//        }catch (SQLException E){
//            JOptionPane.showMessageDialog(null,"Error");
//        }


    }


}
