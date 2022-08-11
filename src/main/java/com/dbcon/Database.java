package com.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection DbConnection;

    static {
        try {
            DbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iti", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getDbConnection() {
        return DbConnection;
    }
}
