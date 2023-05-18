package com.sfc.appdesktopbodega.Model;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface UserDAO<t>{

    public boolean ValidarUser(String IDROL) throws SQLException;
    public boolean RegistrarUser(User user) throws SQLException;
    public ObservableList<User> GetDataUser() throws ClassNotFoundException, SQLException;
    public void DeleteUser() throws SQLException;
    public void UpdateUser(String names,String lastnames) throws SQLException;
    public void dashboardKPI() throws SQLException;
    public void updateROl(int idROL) throws SQLException;
    public void recoveryPassword(String password,String dni) throws SQLException;
    public int addUserAttemptFailed() throws SQLException;
    public void deleteAttemptFailed() throws SQLException;
    public ObservableList<User> GetDataBlockedUser() throws ClassNotFoundException, SQLException;


}
