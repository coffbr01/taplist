package com.bcoffield.taplist.service.impl;

import com.bcoffield.taplist.entity.EBeer;
import com.bcoffield.taplist.repository.IBeerRepository;
import com.bcoffield.taplist.service.ITapListService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TapListService implements ITapListService {
    @Inject
    private IBeerRepository beerRepository;

    @Override
    public List<EBeer> getTapList(Integer count) {
        return beerRepository.find(count);
    }
}
