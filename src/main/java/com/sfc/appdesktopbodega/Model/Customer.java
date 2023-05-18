package com.sfc.appdesktopbodega.Model;

import com.sfc.appdesktopbodega.ConnectionMySQL.ConnectionMYSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Types.NULL;

public class Customer {

    String code,dni,ruc,names,lastNames,email,age,home,phoneNumber;


    public Customer(String dni, String ruc, String names, String lastNames, String email, String age, String home, String phoneNumber) {
        this.dni = dni;
        this.ruc = ruc;
        this.names = names;
        this.lastNames = lastNames;
        this.email = email;
        this.age = age;
        this.home = home;
        this.phoneNumber = phoneNumber;
    }
    public Customer(String code, String dni, String ruc, String names, String lastNames, String email, String age, String home, String phoneNumber) {
        this.code = code;
        this.dni = dni;
        this.ruc = ruc;
        this.names = names;
        this.lastNames = lastNames;
        this.email = email;
        this.age = age;
        this.home = home;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    PreparedStatement pst;
    ConnectionMYSQL ConnectionClass = new ConnectionMYSQL();

    public boolean AddCustomer() throws SQLException, FileNotFoundException {


        Connection connection = ConnectionClass.getConnection();

        try {
            pst = connection.prepareStatement("INSERT INTO cliente(cliente_dni,cliente_ruc,cliente_nombres,cliente_apellidos,cliente_correo,cliente_edad,cliente_domicilio,cliente_telefono) VALUES (?,?,?,?,?,?,?,?)");
            pst.setString(1, getDni());
            pst.setString(2, getRuc());
            if (getRuc()==null ||getRuc().isBlank()) {
                pst.setNull(2, NULL);
            } else {
                pst.setString(2, getRuc());
            }
            pst.setString(3, getNames());
            pst.setString(4, getLastNames());
            pst.setString(5, getEmail());
            pst.setString(6, getAge());
            pst.setString(7, getHome());
            pst.setString(8, getPhoneNumber());


            int row = pst.executeUpdate();
            if (row > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;

            }

        } catch (SQLException e) {
            // print SQL exception information
            // Restablecer el siguiente id autoincrementable si fallara la consulta
            pst = connection.prepareStatement("ALTER TABLE cliente AUTO_INCREMENT = 1");
            pst.executeUpdate();
            connection.close();
//            System.out.println(e);

        }
        return false;
    }
    //Obtiene los datos del producto para una tabla
    public ObservableList<Customer> GetDataCustomer() throws SQLException {
        ObservableList<Customer> obs = FXCollections.observableArrayList();
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("select cliente_id,cliente_dni,cliente_ruc,cliente_nombres,cliente_apellidos,cliente_correo,cliente_edad,cliente_domicilio,cliente_telefono from cliente ORDER BY cliente_id");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.code = rs.getString("cliente_id");
                this.dni = rs.getString("cliente_dni");
                this.ruc = rs.getString("cliente_ruc");
                this.names = rs.getString("cliente_nombres");
                this.lastNames = rs.getString("cliente_apellidos");
                this.email= rs.getString("cliente_correo");
                this.age = rs.getString("cliente_edad");
                this.home = rs.getString("cliente_domicilio");
                this.phoneNumber = rs.getString("cliente_telefono");

                Customer customer = new Customer(code,dni,ruc,names,lastNames,email,age,home,phoneNumber);
                obs.add(customer);

            }
            connection.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
        return obs;
    }





    public void DeleteCustomer() throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("delete from cliente where cliente_id=?");
            pst.setString(1, getCode());
            pst.executeUpdate();
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }



    }

    //Actualizar usuarios Nombres,Apellidos en el sistema
    public void UpdateCustomer(String dni, String ruc,String names,String lastnames,String phoneNumber) throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("update cliente set cliente_dni=?, cliente_ruc=?, cliente_nombres=?,cliente_apellidos=?,cliente_telefono=?  where cliente_id=?");
            pst.setString(1,dni);
            pst.setString(2,ruc);
            pst.setString(3,names);
            pst.setString(4,lastnames);
            pst.setString(5,phoneNumber);
            pst.setString(6,getCode());
            pst.executeUpdate();
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }

    public ObservableList<Customer> search (String valor) throws SQLException {
        ObservableList<Customer> obs = FXCollections.observableArrayList();
        Connection connection = ConnectionClass.getConnection();
        try {

            pst = connection.prepareStatement("select * from cliente  where cliente_dni like '%"+valor+"%' or cliente_ruc like '%"+valor+"%' or cliente_apellidos like '%"+valor+"%' or cliente_nombres like '%"+valor+"%' or cliente_telefono like '%"+valor+"%' ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.code = rs.getString("cliente_id");
                this.dni = rs.getString("cliente_dni");
                this.ruc = rs.getString("cliente_ruc");
                this.names = rs.getString("cliente_nombres");
                this.lastNames = rs.getString("cliente_apellidos");
                this.email= rs.getString("cliente_correo");
                this.age = rs.getString("cliente_edad");
                this.home = rs.getString("cliente_domicilio");
                this.phoneNumber = rs.getString("cliente_telefono");
                Customer customer = new Customer(code,dni,ruc,names,lastNames,email,age,home,phoneNumber);
                obs.add(customer);

            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
        return obs;
    }








}
