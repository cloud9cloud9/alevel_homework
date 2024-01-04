package org.example.hw20.HibernatePartTwo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("PostgresPU");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
