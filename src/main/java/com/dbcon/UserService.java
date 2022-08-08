package com.dbcon;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user) ;
    User updateUser(String id ,User user);
    boolean deleteUser(String id);
    User getUser(String id) ;
    List<User> getAllUser() ;
    Optional<User> getUserByPhone();

}