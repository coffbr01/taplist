package com.bcoffield.taplist.service;

import com.bcoffield.taplist.entity.Beer;
import com.bcoffield.taplist.entity.Dispenser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBeerService {
    Beer create(Float abv, String description, Float fg, String name, Float og, Integer srm);

    Page<Beer> findAll(Integer count);

    Beer findOne(Integer id);

    Beer setDispenser(Integer beerId, Integer dispenserId);
}
