package com.dbcon;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(0);
        user.setUsername("mohamed");
        user.setPassword("12345678");
        user.setPhone("+201060819139");
        UserService.addUser(user);
        List<User> res = UserService.getAllUser();
        for (User u: res) {
            System.out.println(u.getId() + u.getUsername() + u.getBirthdate() + u.getPassword() + u.getPhone());
        }
        Optional<User> optUser = UserService.getUserByPhone("+201060819139");
        System.out.println(optUser);

        UserService.deleteUser(1);
    }
}