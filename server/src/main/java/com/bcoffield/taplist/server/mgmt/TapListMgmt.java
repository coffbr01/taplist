package com.bcoffield.taplist.server.mgmt;

import com.bcoffield.taplist.api.ITapListMgmt;
import com.bcoffield.taplist.entity.EBeer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TapListMgmt implements ITapListMgmt {
    @Inject
    private EntityManager em;

    public List<EBeer> getTapList(Integer count) {
        Query query = em.createNamedQuery(EBeer.FIND_ALL);
        query.setMaxResults(count);
        return query.getResultList();
    }
}
