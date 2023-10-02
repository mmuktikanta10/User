package com.shopping.user.service;

import com.shopping.user.entity.UserEntity;
import com.shopping.user.exception.UserNotFoundException;
import com.shopping.user.model.request.UserRequestModel;
import com.shopping.user.model.request.UserUpdateRequest;
import com.shopping.user.model.response.UserResponseModel;
import com.shopping.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<UserResponseModel> registerUser(UserRequestModel request) {
        UserEntity userEntity = modelMapper.map(request, UserEntity.class);
        Optional<UserEntity> savedUser = Optional.of(userRepository.save(userEntity));
        return Optional.of(modelMapper.map(savedUser, UserResponseModel.class));
    }

    @Override
    public Optional<UserResponseModel> searchUser(String email) {
        Optional<UserEntity> userEntity=userRepository.findByEmail(email);
        if (userEntity.isPresent())
            return Optional.of(modelMapper.map(userEntity, UserResponseModel.class));
        else
            throw new UserNotFoundException("UserNotPresent");
    }

    @Override
    public Optional<UserResponseModel> updateUser(String email, UserUpdateRequest request) {
        if (userRepository.existsByEmail(email)){
           // userRepository.
        }
        return Optional.empty();
    }
}
