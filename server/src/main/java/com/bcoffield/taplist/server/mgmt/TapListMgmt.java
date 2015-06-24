package com.bcoffield.taplist.server.mgmt;

import com.bcoffield.taplist.server.entity.EBeer;

import javax.persistence.EntityManager;
import java.util.List;

public class TapListMgmt {
    @Override
    public List<EBeer> getTapList(Integer count) {
        return em.createNamedQuery(EBeer.FIND_ALL, EBeer.class).setMaxResults(count).getResultList();
    }
}
