package com.dbcon;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String dbUrl = "jdbc:mysql://localhost:3306/iti";
        String user = "root";
        String pass = "root";

        try (Connection connection = DriverManager.getConnection(dbUrl, user, pass)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, name from user");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}