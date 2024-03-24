package com.example.demo.user.service;

import com.example.demo.user.dto.UserRequest;
import com.example.demo.user.dto.UserResponse;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import static com.example.demo.user.service.mapping.UserMapping.*;

@Service
@Slf4j  //dunfng log
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse create(UserRequest request) {
        log.info(" === Start api create new user === ");
        log.info(" === RequestBody : {} ===", request);
        UserEntity entity = convertDtoToEntity(request);
        entity = userRepository.save(entity);
        UserResponse response = convertEntityToUserResponse(entity);
        log.info(" === Finish api create new user ,User id : {} ===", response.getId());
        return response;


    }


    @Override
    public List<UserResponse> getAllUser() {
        return null;
    }

    @Override
    public UserResponse getUserById(String id) {
       log.info(" === Start api get user by id : {} === ",id);
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);{

            if(optionalUserEntity.isPresent()){
                UserResponse response = convertEntityToUserResponse(optionalUserEntity.get());
                log.info(" === finish api get user by id : {}, User : {} === ",id,response);
                return response ;
            }else {
                log.info(" === finish api get user by id : {}, User : {} === ",id);
                return null;
            }
        }
    }

    @Override
    public UserResponse updateUser(String id, UserRequest request) {
        log.info(" === Start api update user with id : {} === ", id);
        Optional<UserEntity> optionalEntity = userRepository.findById(id);
        if (optionalEntity.isPresent()) {
           UserEntity entity = optionalEntity.get();
            entity.setName(request.getName());
            entity.setPassword(request.getPassword());
            entity.setPhoneNumber(request.getPhoneNumber());
            UserResponse response = convertEntityToUserResponse(entity);
            log.info(" === Finish api update user with id : {}, Updated student : {} === ", id, response);
            return response;
        } else {
            log.info(" === Finish api update user with id : {}, Student not found === ", id);
            return null;
        }
    }

    @Override
    public void deleteUser(String id) {
        log.info(" === Start api delete user with id : {} === ",id);
        userRepository.deleteById(id);
        log.info(" === Finsish api delete user :{}",id);

    }
}
