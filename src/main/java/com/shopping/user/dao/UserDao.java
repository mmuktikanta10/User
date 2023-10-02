package com.shopping.user.dao;

import com.shopping.user.entity.UserEntity;
import com.shopping.user.model.request.UserUpdateRequest;

import java.util.List;
import java.util.Map;

public interface UserDao {
    UserEntity updateUserData(int id,UserUpdateRequest request);
}
