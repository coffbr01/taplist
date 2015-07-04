package com.bcoffield.taplist.service;

import com.bcoffield.taplist.entity.Beer;
import com.bcoffield.taplist.entity.Dispenser;
import com.bcoffield.taplist.repository.BeerRepository;
import com.bcoffield.taplist.repository.DispenserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BeerService implements IBeerService {
    @Inject
    private BeerRepository beerRepository;
    @Inject
    private DispenserRepository dispenserRepository;

    @Override
    public Beer create(Float abv, String description, Float fg, String name, Float og, Integer srm) {
        Beer beer = new Beer(null, abv, description, fg, name, og, srm);
        return beerRepository.saveAndFlush(beer);
    }

    @Override
    public Page<Beer> findAll(Integer count) {
        return beerRepository.findAll(new PageRequest(0, count));
    }

    @Override
    public Beer findOne(Integer id) {
        return beerRepository.findOne(id);
    }

    @Override
    public Beer setDispenser(Integer beerId, Integer dispenserId) {
        Beer beer = beerRepository.findOne(beerId);
        Dispenser dispenser = dispenserRepository.findOne(dispenserId);
        beer.setDispenser(dispenser);
        return beerRepository.saveAndFlush(beer);
    }
}
