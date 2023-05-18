package com.sfc.appdesktopbodega.Model;

import com.sfc.appdesktopbodega.ConnectionMySQL.ConnectionMYSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class Product {

    PreparedStatement pst;
    ConnectionMYSQL ConnectionClass = new ConnectionMYSQL();


    String code,codeProduct, product, category, brand;
    double cost, price;
    int stock;

    String imageReference;
    Image image;
    String categoryDescription;

    public Product(String codeProduct, String product, String category, String brand, double cost, double price, int stock, String imageReference) {
        this.codeProduct = codeProduct;
        this.product = product;
        this.category = category;
        this.brand = brand;
        this.cost = cost;
        this.price = price;
        this.stock = stock;
        this.imageReference = imageReference;
    }
    public Product(String code,String codeProduct, String product, String category, String brand, double cost, double price, int stock, Image image) {
        this.code=code;
        this.codeProduct = codeProduct;
        this.product = product;
        this.category = category;
        this.brand = brand;
        this.cost = cost;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }

    public Product() {

    }
    public Product(String category,String categoryDescription) {
        this.category=category;
        this.categoryDescription=categoryDescription;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;

    }

    public String getImageReference() {
        return imageReference;
    }

    public void setImageReference(String imageReference) {
        this.imageReference = imageReference;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public String toString() {
        return category;
    }

    public boolean AddProduct() throws SQLException, FileNotFoundException {


        Connection connection = ConnectionClass.getConnection();

        try {
            pst = connection.prepareStatement("INSERT INTO producto(producto_codigo,producto_nombre,producto_categoria,producto_marca,producto_costo,producto_precio,producto_stock,producto_imagen) values(?,?,?,?,?,?,?,?)");
            pst.setString(1, getCodeProduct());
            pst.setString(2, getProduct());
            pst.setString(3, getCategory());
            pst.setString(4, getBrand());
            pst.setDouble(5, getCost());
            pst.setDouble(6, getPrice());
            pst.setInt(7, getStock());
            //Obtener archivo de imagen desde la ubicacion del archivo
            File image = new File(getImageReference());
            FileInputStream fileInputStream = new FileInputStream(image);
            pst.setBinaryStream(8, fileInputStream,(int)image.length());

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
            pst = connection.prepareStatement("ALTER TABLE producto AUTO_INCREMENT = 1");
            pst.executeUpdate();
            connection.close();
//            System.out.println(e);

        }
        return false;
    }





    //Obtiene los datos del producto para una tabla
    public ObservableList<Product> GetDataProduct() throws SQLException {
        ObservableList<Product> obs = FXCollections.observableArrayList();
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("select producto_id, producto_codigo,producto_nombre,categoria_nombre,producto_marca,producto_costo,producto_precio,producto_stock,producto_imagen from producto inner join categoria on categoria_id=producto_categoria ORDER BY producto_id");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.code = rs.getString("producto_id");
                this.codeProduct = rs.getString("producto_codigo");
                this.product = rs.getString("producto_nombre");
                this.category = rs.getString("categoria_nombre");
                this.brand = rs.getString("producto_marca");
                this.cost = rs.getDouble("producto_costo");
                this.price = rs.getDouble("producto_precio");
//                Blob blob = rs.getBlob("PHOTO");
//                this.images=new Image(blob.getBinaryStream());
                Product products = new Product(code,codeProduct, product, category, brand, cost, price, stock, image);
                obs.add(products);

            }
            connection.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
        return obs;
    }


    //Actualizar los productos
    public void UpdateProduct(String nameProduct) throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("update producto set producto_nombre=? where producto_codigo=?");
            pst.setString(1,nameProduct);
            pst.setString(2,getCodeProduct());
            pst.executeUpdate();
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }


    }

    public void DeleteProduct() throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("delete from producto where producto_codigo=?");
            pst.setString(1, getCodeProduct());
            pst.executeUpdate();
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }



    }

    public ObservableList<Product> Search (String valor) throws SQLException {
        ObservableList<Product> obs = FXCollections.observableArrayList();
        Connection connection = ConnectionClass.getConnection();
        try {

            pst = connection.prepareStatement("SELECT producto_id, producto_codigo,producto_nombre,categoria_nombre,producto_marca,producto_costo,producto_precio,producto_stock,producto_imagen from producto inner join categoria on categoria_id=producto_categoria where producto_id like '%"+valor+"%' or categoria_nombre like '%"+valor+"%' or producto_nombre like '%"+valor+"%' or producto_marca like '%"+valor+"%'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.code = rs.getString("producto_id");
                this.codeProduct = rs.getString("producto_codigo");
                this.product = rs.getString("producto_nombre");
                this.category = rs.getString("categoria_nombre");
                this.brand = rs.getString("producto_marca");
                this.cost = rs.getDouble("producto_costo");
                this.price = rs.getDouble("producto_precio");
                Product products = new Product(code,codeProduct, product, category, brand, cost, price, stock, image);
                obs.add(products);

            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
        return obs;
    }





    public boolean AddCategory() throws SQLException{
//        User DashboardUserController= new User(Dni,Password,Names,LastNames);
        Connection connection = ConnectionClass.getConnection();


        try {
            pst = connection.prepareStatement("INSERT INTO categoria(categoria_nombre,categoria_descripcion) values(?,?)");
            pst.setString(1, getCategory());
            pst.setString(2, getCategoryDescription());
//        connection.close();
            int row = pst.executeUpdate();

            if (row > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;

            }

        }
        catch (SQLException e) {
            // print SQL exception information
            pst = connection.prepareStatement("ALTER TABLE categoria AUTO_INCREMENT = 1");
            pst.executeUpdate();
            connection.close();
//            Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
//            System.out.println(e);

        }

        return false;
    }



        //Obtener el id de una categoria + 1
        public String GetCategoryID() throws SQLException {

            Connection connection = ConnectionClass.getConnection();
            try {
                pst=connection.prepareStatement("SELECT MAX(categoria.categoria_id) AS ID FROM categoria");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    this.category= String.valueOf((rs.getInt("ID"))+1);

                }
                connection.close();

            }catch (SQLException e){
                JOptionPane.showMessageDialog(null,e);
            }
            return this.category;
        }

    //Obtener la descripcion de categoria por el ID de categoria
    public void GetCategoryDescription(String id) throws SQLException {

        Connection connection = ConnectionClass.getConnection();
        try {
            pst=connection.prepareStatement("SELECT categoria_descripcion AS DESCRIPCION FROM categoria WHERE categoria_id= ?");
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.categoryDescription=rs.getString("DESCRIPCION");

            }
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }

        //Obtener la data de categoria para un listView
    public ObservableList<String> GetDataCategory() throws SQLException {
        ObservableList<String> obs = FXCollections.observableArrayList();
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement(
                    "SELECT CONCAT(categoria_id,'                    ',categoria_nombre) AS CATEGORIA from categoria ORDER BY categoria_id");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obs.add(rs.getString("CATEGORIA"));
            }
            connection.close();
        }catch (Exception e){
            System.out.println("" + e);
        }
        return obs;
    }

    //Actualizar categorias de productos
    public boolean UpdateCategory(String id) throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("update categoria set categoria_nombre=?,categoria_descripcion=? where categoria_id=?");
            pst.setString(1,getCategory());
            pst.setString(2,getCategoryDescription());
            pst.setString(3,id);
            pst.executeUpdate();
            int row = pst.executeUpdate();
            if(row>0){
                connection.close();
                return true;
            }else{
                connection.close();
                return false;
            }

        }catch (SQLException e){
            connection.close();

        }
        return false;
    }


    //Buscar categorias para el listview de Categoria
    public ObservableList<String> SearchCategory (String valor) throws SQLException {
        ObservableList<String> obs = FXCollections.observableArrayList();
        Connection connection = ConnectionClass.getConnection();
        try {

            pst = connection.prepareStatement("SELECT CONCAT(categoria_id,'                    ',categoria_nombre) AS CATEGORIA FROM categoria where categoria_id like '%"+valor+"%' or categoria_nombre like '%"+valor+"%' ORDER BY categoria_id");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
//                this.category = rs.getString("categoria_id");
//                this.categoryDescription = rs.getString("categoria_nombre");
                obs.add(rs.getString("CATEGORIA"));
//                obs.add(rs.getString("categoria_nombre"));

//                Product products = new Product(category,categoryDescription);
//                obs.add(products);

            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
        return obs;
    }


//OBTENER LOS NOMBRES DE CATEGORIAS
    public ObservableList<String> GetCategoryName()  {
        ObservableList<String> obs = FXCollections.observableArrayList();
        try {
            Connection connection = ConnectionClass.getConnection();
            pst= connection.prepareStatement("SELECT categoria_nombre as CATEGORIA from categoria ORDER BY categoria_nombre ASC");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.category=rs.getString("CATEGORIA");
                Product products=new Product(category,categoryDescription);
                obs.add(String.valueOf(products));
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
        return obs;
    }

//Obtener el id de categoria por el nombre de categoria en el COMBOBOX
    public void GetICMB(String categoryName) throws SQLException {

        Connection connection = ConnectionClass.getConnection();
        try {
            pst=connection.prepareStatement("SELECT categoria_id AS ID from categoria where categoria_nombre=?");
            pst.setString(1, categoryName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.category=rs.getString("ID");
            }
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }


    //Obtener la iamgen del producto
    public void GetPhotoProduct(String categoryCode) throws SQLException {

        Connection connection = ConnectionClass.getConnection();
        try {
            pst=connection.prepareStatement("SELECT producto_imagen AS PHOTO from producto where producto_codigo=?");
            pst.setString(1, categoryCode);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Blob blob = rs.getBlob("PHOTO");
                this.image=new Image(blob.getBinaryStream());

            }
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }


}


