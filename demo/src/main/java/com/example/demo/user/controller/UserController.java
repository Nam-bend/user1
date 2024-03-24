package com.example.demo.user.controller;

import com.example.demo.user.dto.UserRequest;
import com.example.demo.user.dto.UserResponse;
import com.example.demo.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        log.info(" === Starting API to create a new user === ");
        log.info(" === Request Body: {} === ", request);

        UserResponse response = userService.create(request);

        log.info(" === Finished API to create a new user, User ID: {} === ", response.getId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        log.info(" === Starting API to get user by ID: {} === ", id);
        UserResponse user = userService.getUserById(id);
        if (user != null) {
            log.info(" === Finished API to get user by ID: {}, User: {} === ", id, user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            log.info(" === Finished API to get user by ID: {}, User not found === ", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        log.info(" === Starting API to delete user with ID: {} === ", id);
        userService.deleteUser(id);
        log.info(" === Finished API to delete user: {} === ", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest request) {
        log.info(" === Starting API to update user with ID: {} === ", id);
        UserResponse updatedUser = userService.updateUser(id, request);
        if (updatedUser != null) {
            log.info(" === Finished API to update user with ID: {}, Updated user: {} === ", id, updatedUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            log.info(" === Finished API to update user with ID: {}, User not found === ", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
