package com.example.accessingdatajpa.repository.impl;

import com.example.accessingdatajpa.entity.Abonne;
import com.example.accessingdatajpa.entity.Bornette;
import com.example.accessingdatajpa.repository.api.BornetteRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class BornetteRepositoryImpl extends BaseRepository implements BornetteRepository {


    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public BornetteRepositoryImpl(EntityManager entityManager) {
        super(entityManager);

    }
    @Override
    public List<Bornette> findAll() {
        return entityManager.createNamedQuery("get-all-bornettes", Bornette.class)
                .getResultList();
    }

    @Override
    public void delete(Bornette entity) {
        entityManager.remove(entity);
    }

    @Override
    public Bornette getById(Long aLong) {
        return null;
    }

    //No need

    @Override
    public List<Bornette> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Bornette> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Bornette> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }



    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Bornette> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Bornette> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Bornette> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Bornette> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Bornette> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Bornette> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Bornette> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Bornette getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Bornette> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Bornette> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Bornette> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Bornette> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Bornette> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Bornette> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Bornette, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
