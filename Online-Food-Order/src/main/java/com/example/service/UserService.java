package com.example.service;

import java.util.List;

import com.example.payloads.UserPayload;
import com.example.entities.User.Role;

public interface UserService {
    List<UserPayload> getAllUsers();
    UserPayload getUserById(int userId);
    UserPayload createUser(UserPayload userPayload);
    void deleteUser(int userId);

    List<UserPayload> getUsersByRole(Role role);
}
