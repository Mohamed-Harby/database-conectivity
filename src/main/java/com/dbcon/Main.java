package com.dbcon;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String dbUrl = "jdbc:mysql://localhost:3306/iti", user = "root", pass = "root";
        try {
            Connection connection = DriverManager.getConnection(dbUrl, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, name from user");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.print("user with id: "+ id + " {\n" + "\tname: " + name + "\n}\n\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}