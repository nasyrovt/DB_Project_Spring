package com.example.accessingdatajpa.repository.impl;

import javax.persistence.EntityManager;

/**
 * Base class to derive when implementing a repository
 */
public abstract class BaseRepository {

    protected final EntityManager entityManager;

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    protected BaseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}