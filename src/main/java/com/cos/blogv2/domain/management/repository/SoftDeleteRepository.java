package com.cos.blogv2.domain.management.repository;

import com.cos.blogv2.domain.management.entity.Auditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SoftDeleteRepository<T extends Auditable> extends JpaRepository<T, Long> {

    @Override
    @Modifying //@Query 에서 작성된 쿼리문 사용할 때 사용
    @Transactional
    @Query(Queries.DELETE_BY_ID)
    void deleteById(Long id);

    @Override
    @Transactional
    default void delete(T entity) {
        deleteById(entity.getId());
    }

    @Override
    @Transactional
    default void deleteAll(Iterable<? extends T> entities) {
        entities.forEach(entity -> deleteById(entity.getId()));
    }

    @Override
    @Modifying //@Query 에서 작성된 쿼리문 사용할 때 사용
    @Transactional
    @Query(Queries.DELETE_ALL)
    void deleteAll();
}
