package com.example.accessingdatajpa.repository.impl;

import com.example.accessingdatajpa.entity.Abonne;
import com.example.accessingdatajpa.repository.api.AbonneRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class AbonneRepositoryImpl extends BaseRepository implements AbonneRepository {


    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public AbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);

    }
    @Override
    public List<Abonne> findAll() {
        return entityManager.createNamedQuery("get-all-abonne", Abonne.class)
                .getResultList();
    }

    @Override
    public void delete(Abonne entity) {
        entityManager.remove(entity);
    }

    @Override
    public Abonne getById(Long aLong) {
        return null;
    }




    //No need

    @Override
    public Abonne getOne(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Abonne> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Abonne> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Abonne> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Abonne> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Abonne> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Abonne, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Abonne> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Abonne> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Abonne> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public List<Abonne> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Abonne> findAll(Pageable pageable) {
        return null;
    }
    @Override
    public <S extends Abonne> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Abonne> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Abonne> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Abonne> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Abonne> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Abonne> List<S> findAll(Example<S> example) {
        return null;
    }
}