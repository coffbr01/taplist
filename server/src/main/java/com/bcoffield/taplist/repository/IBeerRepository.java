package com.bcoffield.taplist.repository;

import com.bcoffield.taplist.entity.EBeer;

import java.util.List;

/**
 * Created by coffbr01 on 6/24/15.
 */
public interface IBeerRepository {
    List<EBeer> findAll();
    List<EBeer> find(Integer count);
}
