package com.example.demo.user.dto;

public class UserResponse extends UserRequest {
    private String id;

    public UserResponse() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", name= " + getName() + '\'' +
                ", phoneNumber= " + getPhoneNumber() + '\'' +
                ", passWord= " + getPassword() + '\'' +
                '}';
    }
}
