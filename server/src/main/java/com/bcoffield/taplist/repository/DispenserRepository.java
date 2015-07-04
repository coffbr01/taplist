package com.bcoffield.taplist.repository;

import com.bcoffield.taplist.entity.Dispenser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispenserRepository extends JpaRepository<Dispenser, Integer> {
}
