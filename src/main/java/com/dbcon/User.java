package com.dbcon;

import javax.xml.crypto.Data;

public class User {
    static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static Data getBirthdate() {
        return birthdate;
    }

    public static void setBirthdate(Data birthdate) {
        User.birthdate = birthdate;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        User.phone = phone;
    }

    static String username;
    static String password;
    static Data birthdate;
    static String phone;
}
