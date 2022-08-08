package com.dbcon;

import java.util.List;
import java.util.Optional;

public class UserServiceImp implements UserService {
    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(String id, User user) {
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

    @Override
    public User getUser(String id) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public Optional<User> getUserByPhone() {
        return Optional.empty();
    }
}
