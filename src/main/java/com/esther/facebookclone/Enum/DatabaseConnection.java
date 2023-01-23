package com.esther.facebookclone.Enum;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public enum DatabaseConnection {
    INSTANCE;

    public DataSource getDatasource() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306" +
                        "/facebookdb", "root", "146");
        } catch ( SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (DataSource) connection;
    }

    public boolean connectionTest(){
        try (Connection connection = getDatasource().getConnection()){
            return connection.isValid(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(DatabaseConnection.INSTANCE.connectionTest());
    }
}
