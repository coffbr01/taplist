package com.bcoffield.taplist.api.mgmt;

import com.bcoffield.taplist.entity.EBeer;

public interface IBeerMgmt {
    EBeer createBeer(Float abv, String description, Float fg, String name, Float og, Integer srm);
}
