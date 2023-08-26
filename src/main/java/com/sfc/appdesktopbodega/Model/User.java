package com.sfc.appdesktopbodega.Model;

import com.sfc.appdesktopbodega.ConnectionMySQL.ConnectionMYSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.sql.*;

import static java.sql.Types.NULL;


public class User {
    PreparedStatement pst;
    ConnectionMYSQL ConnectionClass =new ConnectionMYSQL();
//    ConnectionSQL ConnectionClass = new ConnectionSQL();

    String dni,password,names,email,lastNames,idRol;
    String idUser;
    String fecha,estado;

    String imageReference;
    Image image;

    String totalUsers,totalUsersActivate,totalUsersDesactivate,blockedUsers;
    int usuarioIntentos;
    String idAudit,dniNew,userName,rolNew,auditAction,auditHost;
    String token;


    public User(String idAudit,String idUser,String dni, String dniNew,String password,String names,String userName,
                String fecha,String idRol,String rolNEW,String auditAction,String auditHost)
    {
        this.idAudit=idAudit;
        this.idUser = idUser;
        this.dni = dni;
        this.password = password;
        this.names = names;
        this.userName=userName;
        this.idRol=idRol;
        this.rolNew=rolNEW;
        this.fecha=fecha;
        this.dniNew=dniNew;
        this.auditAction=auditAction;
        this.auditHost=auditHost;

    }


    //Tabla de usuarios
    public User(String idUser, String dni, String email, String names, String lastNames, String idRol, String fecha,String estado) {
        this.idUser = idUser;
        this.dni = dni;
        this.email=email;
        this.names = names;
        this.lastNames = lastNames;
        this.idRol=idRol;
        this.fecha=fecha;
        this.estado=estado;

    }
    //login
    public User(String dni, String password) {
        this.dni = dni;
        this.password = password;

    }

    //Registrar usuario
    public User(String dni, String password, String names, String lastNames,String email, String idrol,String imageReference) {
        this.dni = dni;
        this.password = password;
        this.names = names;
        this.lastNames = lastNames;
        this.email=email;
        this.idRol=idrol;
        this.imageReference=imageReference;
    }

    public User(String dni, String password, String names, String lastNames,String email, String idrol) {
        this.dni = dni;
        this.password = password;
        this.names = names;
        this.lastNames = lastNames;
        this.email=email;
        this.idRol=idrol;

    }

    public User() {

    }

    public User(String dni, String names, int usuarioIntentos) {

        this.dni = dni;
        this.names=names;
        this.usuarioIntentos=usuarioIntentos;
    }



//    public User(String dni, String password, String names, String lastNames) {
//        Dni = dni;
//        Password = password;
//        Names = names;
//        LastNames = lastNames;
//
//    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(String totalUsers) {
        this.totalUsers = totalUsers;
    }

    public String getTotalUsersActivate() {
        return totalUsersActivate;
    }

    public void setTotalUsersActivate(String totalUsersActivate) {
        this.totalUsersActivate = totalUsersActivate;
    }

    public String getTotalUsersDesactivate() {
        return totalUsersDesactivate;
    }

    public void setTotalUsersDesactivate(String totalUsersDesactivate) {
        this.totalUsersDesactivate = totalUsersDesactivate;
    }

    public String getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(String blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public int getUsuarioIntentos() {
        return usuarioIntentos;
    }

    public void setUsuarioIntentos(int usuarioIntentos) {
        this.usuarioIntentos = usuarioIntentos;
    }

    public String getIdAudit() {
        return idAudit;
    }

    public void setIdAudit(String idAudit) {
        this.idAudit = idAudit;
    }

    public String getDniNew() {
        return dniNew;
    }

    public void setDniNew(String dniNew) {
        this.dniNew = dniNew;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRolNew() {
        return rolNew;
    }

    public void setRolNew(String rolNew) {
        this.rolNew = rolNew;
    }

    public String getAuditAction() {
        return auditAction;
    }

    public void setAuditAction(String auditAction) {
        this.auditAction = auditAction;
    }

    public String getAuditHost() {
        return auditHost;
    }

    public void setAuditHost(String auditHost) {
        this.auditHost = auditHost;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getImageReference() {
        return imageReference;
    }

    public void setImageReference(String imageReference) {
        this.imageReference = imageReference;
    }

    //CRUD USER//
    public boolean ValidarUser(String IDROL) throws SQLException {
        Connection connection= ConnectionClass.getConnection();
        try {
            //Consulta a tabla configuracion, obtencion de cantidad de intentos de sesion de configuracion //
            pst = connection.prepareStatement("select*from configuracion where id=?");
            pst.setInt(1, 1);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.usuarioIntentos=rs.getInt("conf_valor");
//                System.out.println(usuarioIntentos);
                //
                pst = connection.prepareStatement("select * from users where user_dni=? and user_password=? and user_rol=?");
                pst.setString(1, getDni());
                pst.setString(2, DigestUtils.sha512Hex(getPassword()));
                pst.setString(3, IDROL);


                ResultSet rss = pst.executeQuery();
                if (rss.next()) {

                    try {
                        pst = connection.prepareStatement("update users set user_online=? where user_dni=?");
                        pst.setInt(1,1);
                        pst.setString(2,getDni());
                        pst.executeUpdate();
                        connection.close();

                    }catch (SQLException e){
                        JOptionPane.showMessageDialog(null,e);
                    }


                    connection.close();
                    return true;

                } else {
                    connection.close();
                    return false;
                }
            }




////            pst = connection.prepareStatement("select * from users where user_dni=?  and user_password=? and user_rol=?");
//            pst = connection.prepareStatement("select * from users inner join configuracion on id_user=iduser where user_dni=? and user_password=? and user_rol=?");
//            pst.setString(1, getDni());
//            pst.setString(2, DigestUtils.sha512Hex(getPassword()));
//            pst.setString(3, IDROL);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                connection.close();
//                return true;
//
//            } else {
//                connection.close();
//                return false;
//            }

        } catch (SQLException e) {
            // print SQL exception information
            System.out.println(e);
        }

        return false;
    }

    public boolean AddUser() throws SQLException, FileNotFoundException {
//        User DashboardUserController= new User(Dni,Password,Names,LastNames);
        Connection connection= ConnectionClass.getConnection();
        try {
        pst = connection.prepareStatement("insert into users (user_dni,user_password,user_nombres,user_apellidos,user_rol,user_email,user_imagen) values (?,?,?,?,?,?,?)");
        pst.setString(1, getDni());
        pst.setString(2, DigestUtils.sha512Hex(getPassword()));
        pst.setString(3, getNames());
        pst.setString(4, getLastNames());
        pst.setString(5, getIdRol());
        pst.setString(6, getEmail());
        pst.setNull(7,NULL);
            //Obtener archivo de imagen desde la ubicacion del archivo
//            File image = new File(getImageReference());
//            FileInputStream fileInputStream = new FileInputStream(image);
//            pst.setBinaryStream(7, fileInputStream,(int)image.length());

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
            System.out.println("" + e);
            pst = connection.prepareStatement("ALTER TABLE users AUTO_INCREMENT = 1");
            pst.executeUpdate();
            connection.close();

        JOptionPane.showMessageDialog(null,"Registro Correcto");
        }
        return  false;
    }

    //Obtiene los datos del usuario para una tabla
        public ObservableList<User> GetDataUser() throws SQLException {
            ObservableList<User> obs = FXCollections.observableArrayList();
            Connection connection = ConnectionClass.getConnection();
            try {
                pst = connection.prepareStatement("select *,rol.rol_cargo as rolCargo,rol.rol_estado as userEstado,DATE_FORMAT(users.user_fecha,'%d/%m/%Y  %r')as userFecha from users inner join rol on rol.idRol=users.user_rol order by iduser asc");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    this.idUser = rs.getString("iduser");
                    this.dni = rs.getString("user_dni");
                    this.email = rs.getString("user_email");
                    this.names = rs.getString("user_nombres");
                    this.lastNames = rs.getString("user_apellidos");
                    this.idRol=rs.getString("rolCargo");
                    this.fecha=rs.getString("userFecha");
                    this.estado=rs.getString("userEstado");
                    User user = new User(idUser, dni, email, names, lastNames,idRol,fecha,estado);
                    obs.add(user);

                }
                connection.close();
            }catch (Exception e){
                System.out.println("" + e);
            }
            return obs;
        }

        public void DeleteUser() throws SQLException {
            Connection connection = ConnectionClass.getConnection();
            try {
                pst = connection.prepareStatement("delete from users where iduser=?");
                pst.setString(1, getIdUser());
                pst.executeUpdate();
                connection.close();

            }catch (SQLException e){
                JOptionPane.showMessageDialog(null,e);
            }



        }

        //Actualizar usuarios Nombres,Apellidos en el sistema
    public void UpdateUser(String names,String lastnames) throws SQLException {
         Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("update users set user_nombres=?,user_apellidos=? where iduser=?");
            pst.setString(1,names);
            pst.setString(2,lastnames);
            pst.setString(3,getIdUser());
            pst.executeUpdate();
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }

    public ObservableList<User> search (String valor) throws SQLException {
        ObservableList<User> obs = FXCollections.observableArrayList();
        Connection connection = ConnectionClass.getConnection();
        try {

            pst = connection.prepareStatement("select users.iduser,users.user_dni,users.user_password,users.user_nombres,users.user_apellidos,rol.rol_cargo as ROL,rol.rol_estado as ESTADO,DATE_FORMAT(users.user_fecha,'%d/%m/%Y  %r') as FECHA from users inner join rol on rol.idRol=user_rol  where users.user_dni like '%"+valor+"%' or user_nombres like '%"+valor+"%' or user_apellidos like '%"+valor+"%' or rol_cargo like '%"+valor+"%' or rol_estado like '%"+valor+"%' ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                this.idUser = rs.getString("iduser");
                this.dni = rs.getString("user_dni");
                this.password = rs.getString("user_password");
                this.names = rs.getString("user_nombres");
                this.lastNames = rs.getString("user_apellidos");
                this.idRol=rs.getString("ROL");
                this.fecha=rs.getString("FECHA");
                this.estado=rs.getString("ESTADO");
                User user = new User(idUser, dni, password, names, lastNames,idRol,fecha,estado);
                obs.add(user);

            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
        return obs;
    }




    //KPI de Cantidad de usuarios registrados en el sistema
    public void dashboardKPI() throws SQLException {

         Connection connection = ConnectionClass.getConnection();
        try {
//     contar ototal usuarios ,desactivados y activados
            pst=connection.prepareStatement("SELECT COUNT(idUser) as TOTAL_USUARIOS," +
                    "COUNT(IF((user_rol =3 or user_rol=4),1,null)) as TOTAL_DESACTIVADOS, " +
                    "COUNT(IF((user_rol =1 or user_rol=2),1,null)) as TOTAL_ACTIVADOS " +
                    "from users");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.totalUsers=rs.getString("TOTAL_USUARIOS");
                this.totalUsersActivate=rs.getString("TOTAL_ACTIVADOS");
                this.totalUsersDesactivate=rs.getString("TOTAL_DESACTIVADOS");

            }
            //contar usuarios bloqueados
            pst = connection.prepareStatement("select count(distinct id) as USUARIOS_BLOQUEADOS from userAttempt");
            ResultSet rss = pst.executeQuery();
            while (rss.next()) {
                this.blockedUsers=rss.getString("USUARIOS_BLOQUEADOS");
            }


            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }
        //Actualizar Rol de usuario
    public void updateROl(int idROL) throws SQLException{
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("update users set user_rol=? where iduser=?");
            pst.setInt(1,idROL);
            pst.setString(2,getIdUser());
            pst.executeUpdate();
            connection.close();


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }


    }


    //Actualizar Contraseñá nueva, metodo de recuperacion
    public void recoveryPassword(String password,String dni) throws SQLException {
        Connection connection = ConnectionClass.getConnection();

        try {
            pst = connection.prepareStatement("update users set user_password=? where user_dni=?");
            pst.setString(1,DigestUtils.sha512Hex(password));
            pst.setString(2,dni);
            pst.executeUpdate();
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }

    //Enviar token de restablecimiento de contraseña
    public void sendEmailToken(String token,String email) throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("update users set user_token=? where user_email=?");
            pst.setString(1,token);
            pst.setString(2,email);
            pst.executeUpdate();
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }

    //Enviar token de restablecimiento de contraseña
    public void recoveryPasswordToken(String password,String token,String email) throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("update users set user_password=? where user_token=? and user_email=?");
            pst.setString(1,DigestUtils.sha512Hex(password));
            pst.setString(2,token);
            pst.setString(3,email);
            pst.executeUpdate();
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }


    //Validacion del token para recuperar contraseña
    public boolean validatedToken(String token) throws SQLException {
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("select*from users where user_token=?");
            pst.setString(1,token);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
                return false;
            }





    //Buscar ID , iNSERTAR EN EL ID DE UUARIO 1 INTENTO FALLIDO Y LUEGO SELECCIONAR LA CANTIDAD DE INTENTOS POR USUARIO Y CAPTURAR LA CANTIDAD DE INTENTOS
    public int addUserAttemptFailed() throws SQLException {
        int intentos =0;
        Connection connection= ConnectionClass.getConnection();

        try {
            pst = connection.prepareStatement("select users.iduser as idDeUsuario from users where user_dni=?");
            pst.setString(1, getDni());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.idUser=rs.getString("idDeUsuario");
                System.out.println(this.idUser);
                pst = connection.prepareStatement("insert into userAttempt values (?,?)");
                pst.setString(1, this.idUser);
                pst.setInt(2,1);
                pst.executeUpdate();
                pst = connection.prepareStatement("select count(userAttempt_number) as Intentos from userAttempt where id=?");
                pst.setString(1, this.idUser);
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

    //Eliminar intentos fallidos de usuarios al ingresar al sistema
    public void deleteAttemptFailed() throws SQLException {

        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("delete from userAttempt where id=?");
            pst.setString(1, getIdUser());
//            System.out.println(getIdUser());
            pst.executeUpdate();
            connection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }

    }


    //Extraer Datos de usuarios bloqueados
    public ObservableList<User> GetDataBlockedUser() throws ClassNotFoundException, SQLException {
        ObservableList<User> obs = FXCollections.observableArrayList();
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement(
                    "select users.user_dni as DNI, concat(users.user_apellidos,' ',users.user_nombres) as NOMBRES, COUNT(userAttempt.userAttempt_number) as INTENTOS from users inner join userAttempt on userAttempt.id=users.iduser  group by iduser");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.dni = rs.getString("DNI");
                this.names = rs.getString("NOMBRES");
                this.usuarioIntentos =rs.getInt("INTENTOS");
                User user = new User(dni, names,usuarioIntentos);
                obs.add(user);

            }
            connection.close();
        }catch (Exception e){
            System.out.println("" + e);
        }
        return obs;
    }


    //USER AUDITORIA DE CAMBIOS
    //Obtiene los datos de la tabla de auditoria
    public ObservableList<User> GetDataUserAudit() throws ClassNotFoundException, SQLException {
        ObservableList<User> obs = FXCollections.observableArrayList();
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement("select auditUser.idAuditoria,auditUser.audit_idUser,auditUser.auditOLD_dni,auditUser.auditNEW_dni, if(auditUser.auditOLD_password != auditUser.auditNEW_password, \"SI\", \"NO\") as CambioPassword ,concat(auditOLD_nombres,' ',auditOLD_apellidos) as Nombres,concat(auditNEW_nombres,' ',auditNEW_apellidos) as NombresNuevos,(select rol.rol_cargo from rol where rol.idRol=auditOLD_rol) as rolOLD,(select rol.rol_cargo from rol where rol.idRol=auditNEW_rol) as rolNEW ,DATE_FORMAT(auditUser.fecha,'%d/%m/%Y  %r')as Fecha, auditUser.audit_action,auditUser.audit_host from auditUser  order by idAuditoria asc;");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.idAudit=rs.getString("idAuditoria");
                this.idUser = rs.getString("auditOLD_dni");
                this.dni = rs.getString("auditOLD_dni");
                this.password=rs.getString("CambioPassword");
                this.dniNew=rs.getString("auditNEW_dni");
                this.names = rs.getString("nombres");
                this.userName=rs.getString("nombresNuevos");
                this.fecha=rs.getString("fecha");
                this.idRol=rs.getString("rolOLD");
                this.rolNew=rs.getString("rolNEW");
                this.auditAction=rs.getString("audit_action");
                this.auditHost=rs.getString("audit_host");

                User user = new User(idAudit,idUser,dni,dniNew,password,names,userName,fecha,idRol,rolNew,auditAction,auditHost);
                obs.add(user);




            }
            connection.close();
        }catch (Exception e){
            System.out.println("" + e);
        }
        return obs;
    }


//    public ObservableList<User> GetDataOnlineUsers() throws ClassNotFoundException, SQLException {
//        ObservableList<User> obs = FXCollections.observableArrayList();
//        Connection connection = ConnectionClass.getConnection();
//        try {
//            pst = connection.prepareStatement(
//                    "SELECT CONCAT(users.user_apellidos,' ',users.user_nombres ) AS NOMBRES from users WHERE user_online=1");
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                this.lastNames = rs.getString("NOMBRES");
//                User DashboardUserController = new User(dni, lastNames);
//                obs.add(DashboardUserController);
//
//            }
//            connection.close();
//        }catch (Exception e){
//            System.out.println("" + e);
//        }
//        return obs;
//    }



    public ObservableList<String> GetDataOnlineUsers() throws SQLException {
        ObservableList<String> obs = FXCollections.observableArrayList();
        Connection connection = ConnectionClass.getConnection();
        try {
            pst = connection.prepareStatement(
                    "SELECT CONCAT(users.user_apellidos,' ',users.user_nombres ) AS NOMBRES from users WHERE user_online=1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obs.add(rs.getString("NOMBRES"));
            }
            connection.close();
        }catch (Exception e){
            System.out.println("" + e);
        }
        return obs;
    }





    //Obtener la iamgen del producto
    public void GetPhotoUser(String idUser) throws SQLException {

        Connection connection = ConnectionClass.getConnection();
        try {
            pst=connection.prepareStatement("SELECT user_imagen AS PHOTO from users where idUser=?");
            pst.setString(1, idUser);

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





