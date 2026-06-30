package com.football.service;

import com.football.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    
    Optional<User> getUserById(Long id);
    
    List<User> getAllUsers();
    
    Optional<User> getUserByEmail(String email);
    
    List<User> getUsersByRole(User.UserRole role);
    
    User updateUser(Long id, User userDetails);
    
    void deleteUser(Long id);
}
