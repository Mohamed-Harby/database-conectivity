package com.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection = null;

    private DbConnection() {
    }

    public Connection getDbConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iti", "root", "root");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return connection;
    }
}
