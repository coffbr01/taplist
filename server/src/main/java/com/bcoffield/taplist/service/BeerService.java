package com.bcoffield.taplist.service;

import com.bcoffield.taplist.entity.Beer;
import com.bcoffield.taplist.repository.IBeerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BeerService implements IBeerService {
    @Inject
    private IBeerRepository beerRepository;

    @Override
    public Beer createBeer(Float abv, String description, Float fg, String name, Float og, Integer srm) {
        Beer beer = new Beer(abv, description, fg, name, og, srm);
        return beerRepository.save(beer);
    }

    @Override
    public List<Beer> findAll(Integer count) {
        Pageable page = new PageRequest(0, count);
        return beerRepository.findAll(page);
    }

    @Override
    public Beer findOne(Integer id) {
        return beerRepository.findOne(id);
    }
}
