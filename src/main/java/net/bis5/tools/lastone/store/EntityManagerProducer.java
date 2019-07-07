package net.bis5.tools.lastone.store;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Dependent
public class EntityManagerProducer {
    @Produces @Dependent @PersistenceContext private EntityManager entityManager; 
}