package com.bcoffield.taplist.service.impl;

import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.service.ITapListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TapListService implements ITapListService {
    @Override
    public List<EBeer> getTapList(Integer count) {
        return null;
//        return em.createNamedQuery(EBeer.FIND_ALL, EBeer.class).setMaxResults(count).getResultList();
    }
}
