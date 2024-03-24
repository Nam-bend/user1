package com.example.demo.user.service;

import com.example.demo.user.dto.UserRequest;
import com.example.demo.user.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserRequest request);

    List<UserResponse> getAllUser();

    UserResponse getUserById(String id);

    UserResponse updateUser(String id, UserRequest request);

    void deleteUser(String id);

}
