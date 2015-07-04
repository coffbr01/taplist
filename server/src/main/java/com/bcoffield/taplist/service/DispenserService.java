package com.bcoffield.taplist.service;

import com.bcoffield.taplist.entity.Dispenser;
import com.bcoffield.taplist.repository.BeerRepository;
import com.bcoffield.taplist.repository.DispenserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class DispenserService implements IDispenserService {
    @Inject
    private DispenserRepository dispenserRepository;
    @Inject
    private BeerRepository beerRepository;

    @Override
    public Page<Dispenser> getAll(Integer count) {
        return dispenserRepository.findAll(new PageRequest(0, count));
    }

    @Override
    public Dispenser findOne(Integer id) {
        return dispenserRepository.findOne(id);
    }

    @Override
    public Dispenser create(String name) {
        Dispenser dispenser = new Dispenser(null, name, null);
        return dispenserRepository.save(dispenser);
    }
}
