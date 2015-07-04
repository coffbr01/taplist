package com.bcoffield.taplist.dto.factory;

import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.entity.Beer;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class BeerDTOFactory implements IBeerDTOFactory {
    @Inject
    private DispenserDTOFactory dispenserDTOFactory;

    @Override
    public DTOBeer build(Beer entityBeer) {
        if (entityBeer == null) {
            return null;
        }
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
