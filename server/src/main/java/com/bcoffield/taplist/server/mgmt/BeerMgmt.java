package com.bcoffield.taplist.server.mgmt;

import com.bcoffield.taplist.api.mgmt.IBeerMgmt;
import com.bcoffield.taplist.entity.EBeer;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class BeerMgmt implements IBeerMgmt {
    @Inject
    private EntityManager em;

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
