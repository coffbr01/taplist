package com.bcoffield.taplist.server.orm.scan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class ORMConfig {

    private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE = new ThreadLocal<>();

    public void configure() {
    }

    public EntityManagerFactory provideEntityManagerFactory() {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        properties.put("hibernate.connection.url", "jdbc:h2:test");
        properties.put("hibernate.connection.username", "test");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.connection.pool_size", "1");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create");
        return Persistence.createEntityManagerFactory("db-manager", properties);
    }

    public EntityManager provideEntityManager(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = ENTITY_MANAGER_CACHE.get();
        if (entityManager == null) {
            ENTITY_MANAGER_CACHE.set(entityManager = entityManagerFactory.createEntityManager());
        }
        return entityManager;
    }

}