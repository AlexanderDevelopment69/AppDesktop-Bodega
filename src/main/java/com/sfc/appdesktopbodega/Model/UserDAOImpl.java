package com.sfc.appdesktopbodega.Model;

import com.sfc.appdesktopbodega.ConnectionMySQL.ConnectionMYSQL;
import javafx.collections.ObservableList;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl  implements UserDAO<User>{

    PreparedStatement pst;
    ConnectionMYSQL ConnectionClass =new ConnectionMYSQL();
    User user=new User();

    @Override
    public boolean ValidarUser(String IDROL) throws SQLException {
        Connection connection= ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("select*from users where user_dni=?  and user_password=? and user_rol=? ");
            pst.setString(1, user.getDni());
            pst.setString(2, DigestUtils.sha512Hex(user.getPassword()));
            pst.setString(3, IDROL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                connection.close();
                return true;

            } else {
                connection.close();
                return false;
            }

        } catch (SQLException e) {
            // print SQL exception information
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean RegistrarUser(User user) throws SQLException {

        Connection connection= ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("insert into users (user_dni,user_password,user_nombres,user_apellidos,user_rol) values (?,?,?,?,?)");
            pst.setString(1, user.getDni());
            pst.setString(2, DigestUtils.sha512Hex(user.getPassword()));
            pst.setString(3, user.getNames());
            pst.setString(4, user.getLastNames());
            pst.setString(5, user.getIdRol());

//        connection.close();
            int row = pst.executeUpdate();
            if(row>0){
                connection.close();
                return true;
            }else{
                connection.close();
                return false;

            }

        } catch (SQLException e) {
            // print SQL exception information
            connection.close();
            JOptionPane.showMessageDialog(null,e);

        }
        return  false;
    }

    @Override
    public ObservableList<User> GetDataUser() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void DeleteUser() throws SQLException {

    }

    @Override
    public void UpdateUser(String names, String lastnames) throws SQLException {

    }

    @Override
    public void dashboardKPI() throws SQLException {

    }

    @Override
    public void updateROl(int idROL) throws SQLException {

    }

    @Override
    public void recoveryPassword(String password, String dni) throws SQLException {

    }

    @Override
    public int addUserAttemptFailed() throws SQLException {
        int intentos =0;
        Connection connection= ConnectionClass.getConnection();

        try {
            pst = connection.prepareStatement("select users.iduser as idDeUsuario from users where user_dni=?");
            pst.setString(1, user.getDni());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user.idUser=rs.getString("idDeUsuario");
                System.out.println(user.idUser);
                pst = connection.prepareStatement("insert into userAttempt values (?,?)");
                pst.setString(1, user.idUser);
                pst.setInt(2,1);
                pst.executeUpdate();
                pst = connection.prepareStatement("select count(userAttempt_number) as Intentos from userAttempt where id=?");
                pst.setString(1, user.idUser);
                ResultSet rss = pst.executeQuery();
                while (rss.next()) {
                    intentos = rss.getInt("Intentos");
                    System.out.println(intentos);
                }
            }
            connection.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return intentos;
    }

    @Override
    public void deleteAttemptFailed() throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("delete from userAttempt where id=?");
            pst.setString(1, user.getIdUser());
//            System.out.println(getIdUser());
            pst.executeUpdate();
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    @Override
    public ObservableList<User> GetDataBlockedUser() throws ClassNotFoundException, SQLException {
        return null;
    }
}
