package com.bcoffield.taplist.service;

import com.bcoffield.taplist.entity.Beer;

import java.util.List;

public interface ITapListService {
    List<Beer> getTapList(Integer count);
}
