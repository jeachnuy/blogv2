package com.cos.blogv2.domain.user.repository.springdata;

import com.cos.blogv2.domain.management.repository.SoftDeleteRepository;
import com.cos.blogv2.domain.user.entity.User;
import com.cos.blogv2.domain.user.repository.Queries;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface SpringDataUserRepository extends SoftDeleteRepository<User> {
    @Override
    @Transactional
    @Modifying
    @Query(Queries.DELETE_USER_BY_ID)
    void deleteById(Long id);

    @Override
    @Transactional
    default void delete(User user) {
        deleteById(user.getId());
    }

    @Override
    @Transactional
    default void deleteAll(Iterable<? extends User> entities) {
        entities.forEach(entity -> deleteById(entity.getId()));
    }

    Boolean existsEmail(String email);

    @Query("""
        select user from #{#entityName} user
        left join fetch user.roles
        where user.id = ?1
    """)
    Optional<User> findByIdFetchRoles(Long id);
}
