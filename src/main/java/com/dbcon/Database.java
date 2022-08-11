package com.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection DbConnection = null;

    public Database() {
        try {
            DbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iti", "root", "root");
            DbConnection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public static Connection getDbConnection() {
        return DbConnection;
    }
}
