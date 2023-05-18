package com.sfc.appdesktopbodega.Model;


import com.sfc.appdesktopbodega.ConnectionMySQL.ConnectionMYSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sale {
    PreparedStatement pst;
    ConnectionMYSQL ConnectionClass = new ConnectionMYSQL();
    String idSale;
    String customer;
    String user;
    double totalSale;
    String codeProduct;
    String product;

    int units;
    double discount;
    double price;

    double subTotal;

    double priceSold;
    String  idSaleDetail;





        //CONSTRUCTOR DE AGREGAR PRODUCTOS A PILA DE TABLA DE VENTA
    public Sale(String product,int units, double discount,String codeProduct, double price) {
        this.product = product;
        this.units = units;
        this.discount = discount;
        this.codeProduct = codeProduct;
        this.price=price;

    }

    //CONSTRUCTOR DE PRODUCTOS DE CMBOX
    public Sale(String product) {
        this.product = product;
    }


    public Sale() {

    }

    //CONSTRUCTOR REGISTRAR VENTA
    public Sale(String customer, String user, double discount, double totalSale) {
        this.customer=customer;
        this.user=user;
        this.discount=discount;
        this.totalSale=totalSale;

    }
//CONSTRUCTOR DE REGISTRAR PRODUCTOS EN DETALLE DE VENTA A VENTA
    public Sale(String idSale, String codeProduct, int units, double priceSold,double discount) {
        this.idSale=idSale;
        this.codeProduct=codeProduct;
        this.units=units;
        this.priceSold=priceSold;
        this.discount=discount;
    }


    public String getIdSale() {
        return idSale;
    }

    public void setIdSale(String idSale) {
        this.idSale = idSale;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIdSaleDetail() {
        return idSaleDetail;
    }

    public void setIdSaleDetail(String idSaleDetail) {
        this.idSaleDetail = idSaleDetail;
    }

    public double getSubTotal() {
        subTotal=(units*price)-(discount);
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getPriceSold() {
        return priceSold;
    }

    public void setPriceSold(double priceSold) {
        this.priceSold = priceSold;
    }

    @Override
    public String toString() {
        return product;
    }






    //OBTENER EL NOMBRE DE PRODUCTO PARA EL COMBOBOX
    public ObservableList<String> GetProductName() {
        ObservableList<String> obs = FXCollections.observableArrayList();
        try {
            Connection connection = ConnectionClass.getConnection();
            pst = connection.prepareStatement("SELECT producto_nombre as PRODUCTO from producto ORDER BY producto_Nombre ASC");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.product = rs.getString("PRODUCTO");
                Sale sales = new Sale(product);
                obs.add(String.valueOf(sales));
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
        return obs;
    }




    //OBTENER LA DATA DEL PRODUCTO PARA LA TABLA DE VENTA
    public void GetDATAProduct(String valor) throws SQLException {

        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("SELECT producto_id,producto_precio  from producto where producto_nombre like '%" + valor + "%'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.codeProduct = rs.getString("producto_id");
                this.price = rs.getDouble("producto_precio");

            }
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }



    //OBTENER EL NOMBRE DEL CLIENTE POR EL DNI
    public void SearchCustomer(String valor) throws SQLException {

        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("SELECT CONCAT(cliente_nombres,' ',cliente_apellidos) as CLIENTE from cliente where cliente_dni like '"+valor+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.customer= rs.getString("CLIENTE");

            }
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public boolean GenerateSale() throws SQLException {
        Connection connection = ConnectionClass.getConnection();

        try {
            pst = connection.prepareStatement("INSERT INTO venta(venta_cliente,venta_usuario,venta_descuento,venta_total) values(?,?,?,?)");
            pst.setString(1,getCustomer());
            pst.setString(2, getUser());
            pst.setDouble(3, getDiscount());
            pst.setDouble(4, getTotalSale());

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
            pst = connection.prepareStatement("ALTER TABLE venta AUTO_INCREMENT = 1");
            pst.executeUpdate();
            connection.close();
//            System.out.println(e);

        }
        return false;
    }





    //OBTENER EL NOMBRE DEL CLIENTE POR EL DNI
    public int GetIdSale() throws SQLException {
        int IDSALE=0;
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("SELECT MAX(venta_id) as MAXID from venta");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
//                this.idSale=rs.getString("MAXID");
                this.idSale= String.valueOf((rs.getInt("MAXID"))+1);
                IDSALE= Integer.parseInt(idSale);
            }
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return IDSALE;
    }

    public boolean GenerateSaleDetail() throws SQLException {
        Connection connection = ConnectionClass.getConnection();

        try {
            pst = connection.prepareStatement("INSERT INTO detalleVenta(detalleVenta_id,detalleVenta_producto,detalleVenta_cantidad,detalleVenta_precio,detalleVenta_descuento) values(?,?,?,?,?)");
            pst.setString(1,getIdSale());
            pst.setString(2, getCodeProduct());
            pst.setInt(3, getUnits());
            pst.setDouble(4, getPriceSold());
            pst.setDouble(5, getDiscount());

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
            pst = connection.prepareStatement("ALTER TABLE detalleVenta AUTO_INCREMENT = 1");
            pst.executeUpdate();
            connection.close();
            System.out.println(e);

        }
        return false;
    }

}
