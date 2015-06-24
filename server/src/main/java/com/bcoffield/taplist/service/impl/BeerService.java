package com.bcoffield.taplist.service.impl;

import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.service.IBeerService;
import org.springframework.stereotype.Service;

@Service
public class BeerService implements IBeerService {
    @Override
    public EBeer createBeer(Float abv, String description, Float fg, String name, Float og, Integer srm) {
        return null;
        /*
        EBeer result = new EBeer();
        result.setAbv(abv);
        result.setDescription(description);
        result.setFg(fg);
        result.setName(name);
        result.setOg(og);
        result.setSrm(srm);
        em.persist(result);
        return result;
        */
    }
}
