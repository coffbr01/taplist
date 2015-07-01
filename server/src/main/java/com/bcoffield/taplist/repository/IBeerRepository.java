package com.bcoffield.taplist.repository;

import com.bcoffield.taplist.entity.Beer;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBeerRepository {
    List<Beer> findAll(Pageable page);
    Beer save(Beer entity);
    Beer findOne(Integer id);
    Integer count();
    void delete(Integer id);
    boolean exists(Integer id);
}
