package com.cos.blogv2.domain.user.repository;

import com.cos.blogv2.domain.pagination.model.Page;
import com.cos.blogv2.domain.user.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByIdFetchRoles(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Collection<User> saveAll(Collection<User> users) {
        return null;
    }
}
