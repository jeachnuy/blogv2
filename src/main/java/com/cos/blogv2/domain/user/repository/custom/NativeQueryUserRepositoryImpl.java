package com.cos.blogv2.domain.user.repository.custom;

import com.cos.blogv2.domain.pagination.model.Page;
import com.cos.blogv2.domain.user.entity.User;
import com.cos.blogv2.domain.user.repository.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import java.util.Optional;

public class NativeQueryUserRepositoryImpl implements NativeQueryUserRepository {
    @Autowired
    EntityManager manager;

    @Override
    public Optional<User> findById(Long id) {
        var query = manager
                .createNativeQuery(String.format(Queries.FIND_BY_FIELD_FETCH_ROLES, "u.id = :user_id"), Tuple.class)
                .setParameter("user_id", id);
        try {
            var tuple = (Tuple)query.getSingleResult();
            return Optional.of(User.from(tuple));
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }
}
