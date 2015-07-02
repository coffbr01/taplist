package com.bcoffield.taplist.service;

import com.bcoffield.taplist.entity.Beer;

import java.util.List;

public interface IBeerService {
    Beer createBeer(Float abv, String description, Float fg, String name, Float og, Integer srm);

    List<Beer> findAll(Integer count);

    Beer findOne(Integer id);
}
