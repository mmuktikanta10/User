package com.shopping.user.service;

import com.shopping.user.entity.UserEntity;
import com.shopping.user.model.request.UserRequestModel;
import com.shopping.user.model.request.UserUpdateRequest;
import com.shopping.user.model.response.UserResponseModel;

import java.util.Optional;

public interface UserService {

    Optional<UserResponseModel> registerUser(UserRequestModel request);
    Optional<UserResponseModel> searchUser(String email);

    Optional<UserResponseModel> updateUser(int id, UserUpdateRequest request);
}
