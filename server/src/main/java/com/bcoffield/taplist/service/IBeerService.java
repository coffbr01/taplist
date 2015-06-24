package com.bcoffield.taplist.service;

import com.bcoffield.taplist.entity.EBeer;

public interface IBeerService {
    EBeer createBeer(Float abv, String description, Float fg, String name, Float og, Integer srm);
}
