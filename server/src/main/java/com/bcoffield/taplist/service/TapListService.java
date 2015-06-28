package com.bcoffield.taplist.service;

import com.bcoffield.taplist.entity.Beer;
import com.bcoffield.taplist.repository.BeerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TapListService implements ITapListService {
    @Inject
    private BeerRepository beerRepository;

    @Override
    public List<Beer> getTapList(Integer count) {
        Pageable page = new PageRequest(0, count);
        return beerRepository.findAll(page);
    }
}
