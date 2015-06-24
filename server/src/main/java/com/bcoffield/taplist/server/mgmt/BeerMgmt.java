package com.bcoffield.taplist.server.mgmt;

import com.bcoffield.taplist.server.entity.EBeer;

public class BeerMgmt {
    @Override
    public EBeer createBeer(Float abv, String description, Float fg, String name, Float og, Integer srm) {
        EBeer result = new EBeer();
        result.setAbv(abv);
        result.setDescription(description);
        result.setFg(fg);
        result.setName(name);
        result.setOg(og);
        result.setSrm(srm);
        em.persist(result);
        return result;
    }
}
