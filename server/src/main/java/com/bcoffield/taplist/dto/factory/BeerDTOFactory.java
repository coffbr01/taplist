package com.bcoffield.taplist.dto.factory;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.entity.Beer;

public class BeerDTOFactory {
    public static DTOBeer build(Beer entityBeer) {
        DTOBeer result = new DTOBeer();
        result.setId(entityBeer.getId());
        result.setAbv(entityBeer.getAbv());
        result.setDescription(entityBeer.getDescription());
        result.setFg(entityBeer.getFg());
        result.setName(entityBeer.getName());
        result.setOg(entityBeer.getOg());
        result.setSrm(entityBeer.getSrm());
        return result;
    }
}
