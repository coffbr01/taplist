package com.bcoffield.taplist.service;

import com.bcoffield.taplist.entity.EBeer;

import java.util.List;

public interface ITapListService {
    List<EBeer> getTapList(Integer count);
}
