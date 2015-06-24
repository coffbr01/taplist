package com.bcoffield.taplist.repository.impl;

import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.repository.IBeerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeerRepository implements IBeerRepository {
    @Override
    public List<EBeer> findAll() {
        return null;
    }

    @Override
    public List<EBeer> find(Integer count) {
        return null;
    }
}
