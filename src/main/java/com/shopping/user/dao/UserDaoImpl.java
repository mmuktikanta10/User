package com.shopping.user.dao;

import com.shopping.user.model.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao{
    private final EntityManager entityManager;
    @Override
    public void updateUserData(UserUpdateRequest request) {

    }
}
