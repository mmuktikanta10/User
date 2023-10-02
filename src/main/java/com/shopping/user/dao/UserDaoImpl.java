package com.shopping.user.dao;

import com.shopping.user.entity.UserEntity;
import com.shopping.user.model.request.UserUpdateRequest;
import com.shopping.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao{
    private final EntityManager entityManager;
    private final UserRepository userRepository;
    @Override
    @Transactional
    public UserEntity updateUserData(int id,UserUpdateRequest request) {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaUpdate<UserEntity> criteriaUpdate= criteriaBuilder.createCriteriaUpdate(UserEntity.class);
        Root<UserEntity> root=criteriaUpdate.from(UserEntity.class);
        for (Map.Entry<String,String> field:request.getUpdateFields().entrySet()){
            criteriaUpdate.set(root.get(field.getKey()),field.getValue());
        }
        Predicate whereUserIdEquals=criteriaBuilder.equal(root.get("id"),id);
        criteriaUpdate.where(whereUserIdEquals);
        entityManager.createQuery(criteriaUpdate).executeUpdate();
        return userRepository.findById(id).get();
    }
}
