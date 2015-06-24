package com.bcoffield.taplist.server.mgmt;

import com.bcoffield.taplist.api.mgmt.ITapListMgmt;
import com.bcoffield.taplist.entity.EBeer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class TapListMgmt implements ITapListMgmt {
    @Inject
    private EntityManager em;

    @Override
    public List<EBeer> getTapList(Integer count) {
        return em.createNamedQuery(EBeer.FIND_ALL, EBeer.class).setMaxResults(count).getResultList();
    }
}
