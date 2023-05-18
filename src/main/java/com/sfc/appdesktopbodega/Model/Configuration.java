package com.sfc.appdesktopbodega.Model;


import com.sfc.appdesktopbodega.ConnectionMySQL.ConnectionMYSQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Configuration {
    PreparedStatement pst;
    ConnectionMYSQL ConnectionClass =new ConnectionMYSQL();

    String  conf_id,
            conf_nombre,
            conf_valor,
            conf_estado,
            id_user;



//public Configuration(String conf_id,String conf_nombre,String conf_valor,String conf_estado,String id_user){
//    this.conf_id=conf_id;
//    this.conf_nombre=conf_nombre;
//    this.conf_valor=conf_valor;
//    this.id_user=id_user;
//
//
//}

    public Configuration() {

    }


    public String getConf_id() {
        return conf_id;
    }

    public void setConf_id(String conf_id) {
        this.conf_id = conf_id;
    }

    public String getConf_nombre() {
        return conf_nombre;
    }

    public void setConf_nombre(String conf_nombre) {
        this.conf_nombre = conf_nombre;
    }

    public String getConf_valor() {
        return conf_valor;
    }

    public void setConf_valor(String conf_valor) {
        this.conf_valor = conf_valor;
    }

    public String getConf_estado() {
        return conf_estado;
    }

    public void setConf_estado(String conf_estado) {
        this.conf_estado = conf_estado;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }



    public void GetDataConfiguration(int valor) throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst=connection.prepareStatement("SELECT id AS ID,conf_nombre AS NOMBRE,conf_valor AS VALOR,estado AS ESTADO,id_user AS IDUSER from configuracion WHERE ID=?");
            pst.setInt(1,valor);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.conf_id=rs.getString("ID");
                this.conf_nombre=rs.getString("NOMBRE");
                this.conf_valor=rs.getString("VALOR");
                this.conf_estado=rs.getString("ESTADO");
                this.id_user=rs.getString("IDUSER");
            }
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
        }
    }

    //Actualizar usuarios Nombres,Apellidos en el sistema
    public void UpdateConfiguration(String valor,int idParametro) throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("update configuracion set conf_valor=?  WHERE id=?");
            pst.setString(1,valor);
            pst.setInt(2,idParametro);
            pst.executeUpdate();
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }









    }





