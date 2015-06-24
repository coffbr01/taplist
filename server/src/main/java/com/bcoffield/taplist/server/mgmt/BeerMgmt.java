package com.bcoffield.taplist.server.mgmt;

import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.server.util.SRMUtil;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class BeerMgmt {
    @Inject
    private EntityManager em;

    public EBeer createBeer(Float abv, String description, Float fg, String name, Float og, String srm) {
        EBeer result = new EBeer();
        result.setAbv(abv);
        result.setDescription(description);
        result.setName(name);
        result.setOg(og);
        result.setSrm(SRMUtil.toSrm(srm));
        em.persist(result);
        return result;
    }
}
