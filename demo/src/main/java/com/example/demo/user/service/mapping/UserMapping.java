package com.example.demo.user.service.mapping;

import com.example.demo.user.dto.UserRequest;
import com.example.demo.user.dto.UserResponse;
import com.example.demo.user.entity.UserEntity;

public class UserMapping {
    public static UserEntity convertDtoToEntity (UserRequest dto){
        UserEntity entity =new UserEntity();
        entity.setName(dto.getName());
        //entity.setName --- cấu hình thuộc tính và dto lấy cái tên đó (get) để hiển thị thong tin có thể công khai của User
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setPassword(dto.getPassword());
        return entity ;
    }
    public static UserResponse convertEntityToUserResponse (UserEntity entity){
        UserResponse dto = new UserResponse() ;
        // dto nhận dữ liệu của entity
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setPassword(entity.getPassword());
        return dto ;
    }

}
