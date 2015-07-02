package com.bcoffield.taplist.repository;

import com.bcoffield.taplist.entity.Beer;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BeerRepository implements IBeerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Beer> findAll(Pageable page) {
        return em.createNamedQuery(Beer.FIND_ALL, Beer.class).setMaxResults(page.getPageSize()).getResultList();
    }

    @Override
    @Transactional
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
