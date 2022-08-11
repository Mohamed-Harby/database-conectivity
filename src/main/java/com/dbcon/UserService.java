package com.dbcon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static Connection connection = Database.getDbConnection();

    public UserService() {
        this.connection = Database.getDbConnection();
    }

    public static User addUser(User user) {
        Connection connection = Database.getDbConnection();
        String query =
                "insert into user (id, username, password, phone) values (?, ?, ?, ?)";
        try (PreparedStatement addStmt = connection.prepareStatement(query)) {
            addStmt.setInt(1, user.getId());
            addStmt.setString(2, user.getUsername());
            addStmt.setString(3, user.getPassword());
//            addStmt.setDate(4, (Date) user.getBirthdate());
            addStmt.setString(4, user.getPhone());
            addStmt.executeUpdate();
//            connection.commit();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return user;
    }

    public static User updateUser(String id, User user) {
        String query =
                "update user set username=?, password=?, phone=? where id=?";
        try (PreparedStatement updateStmt = connection.prepareStatement(query)) {
            updateStmt.setString(1, user.getUsername());
            updateStmt.setString(2, user.getPassword());
//            updateStmt.setDate(3, (Date) user.getBirthdate());
            updateStmt.setString(3, user.getPhone());
            updateStmt.setInt(4, user.getId());
            updateStmt.executeUpdate();
//            connection.commit();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return user;
    }

    public static boolean deleteUser(int id) {
        String query =
                "delete from user where id=?";
        try (PreparedStatement deleteStmt = connection.prepareStatement(query)) {
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
//            connection.commit();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public static User getUser(int id) {
        User user = new User();
        String query =
                "select * from user where id=?";
        try (PreparedStatement getStmt = connection.prepareStatement(query)) {
            getStmt.setInt(1, id);
            ResultSet resultSet = getStmt.executeQuery();

            while (resultSet.next()) {
                user.setId(id);
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
//            user.setBirthdate(resultSet.getDate("birthdate"));
                user.setPhone(resultSet.getString("phone"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return user;
    }

    public static List<User> getAllUser() {
        String query =
                "select id from user";
        List<User> users = new ArrayList<>();
        try (PreparedStatement selectStmt = connection.prepareStatement(query)) {
            ResultSet resultSet = selectStmt.executeQuery();
//            connection.commit();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                users.add(getUser(id));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return users;
    }

    public static Optional<User> getUserByPhone(String phone) {
        User user = new User();
        String query =
                "select * from user where phone=?";
        try (PreparedStatement getStmt = connection.prepareStatement(query)) {
            getStmt.setString(1, phone);
            ResultSet resultSet = getStmt.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt(("id")));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
//            user.setBirthdate(resultSet.getDate("birthdate"));
                user.setPhone(resultSet.getString("phone"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        Optional<User> checkNull = Optional.ofNullable(user);
        if (checkNull.isPresent()) {
            return checkNull;
        } else {
            return Optional.empty();
        }
    }
}
