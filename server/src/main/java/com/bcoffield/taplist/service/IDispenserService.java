package com.bcoffield.taplist.service;

import com.bcoffield.taplist.entity.Dispenser;
import org.springframework.data.domain.Page;


public interface IDispenserService {
    Page<Dispenser> getAll(Integer count);
    Dispenser findOne(Integer id);
    Dispenser create(String name);
}
