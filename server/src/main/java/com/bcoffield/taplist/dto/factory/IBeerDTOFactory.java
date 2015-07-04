package com.bcoffield.taplist.dto.factory;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.entity.Beer;

public interface IBeerDTOFactory {
    DTOBeer build(Beer entityBeer);
}
