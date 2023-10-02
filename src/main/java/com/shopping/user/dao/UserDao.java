package com.shopping.user.dao;

import com.shopping.user.model.request.UserUpdateRequest;

import java.util.Map;

public interface UserDao {
    void updateUserData(UserUpdateRequest request);
}
