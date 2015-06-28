package com.bcoffield.taplist.repository;

import com.bcoffield.taplist.entity.Beer;
import com.bcoffield.taplist.repository.common.IRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BeerRepository implements IRepository<Beer> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Beer> findAll(Pageable page) {
        return em.createNamedQuery(Beer.FIND_ALL, Beer.class).getResultList();
    }

    @Override
    public Beer save(Beer entity) {
        em.persist(entity);
        em.flush();
        em.refresh(entity);
        return entity;
    }

    @Override
    public Beer findOne(Integer id) {
        return em.find(Beer.class, id);
    }

    @Override
    public Integer count() {
        return em.createNamedQuery(Beer.FIND_ALL).getMaxResults();
    }

    @Override
    public void delete(Integer id) {
        em.remove(findOne(id));
    }

    @Override
    public boolean exists(Integer id) {
        return findOne(id) != null;
    }
}
