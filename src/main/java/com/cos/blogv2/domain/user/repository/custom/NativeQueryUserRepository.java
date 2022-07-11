package com.cos.blogv2.domain.user.repository.custom;

import com.cos.blogv2.domain.pagination.model.Page;
import com.cos.blogv2.domain.user.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NativeQueryUserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    Page<User>  findAll(Pageable pageable);
}
