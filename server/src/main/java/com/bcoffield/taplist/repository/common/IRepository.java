package com.bcoffield.taplist.repository.common;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;

@NoRepositoryBean
public interface IRepository<T> extends Repository<T, Long> {
    List<T> findAll(Pageable page);
    T save(T entity);
    T findOne(Integer id);
    Integer count();
    void delete(Integer id);
    boolean exists(Integer id);
}
