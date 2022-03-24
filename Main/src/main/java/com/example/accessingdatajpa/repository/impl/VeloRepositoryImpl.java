package com.example.accessingdatajpa.repository.impl;

import com.example.accessingdatajpa.AllEnums;
import com.example.accessingdatajpa.entity.Station;
import com.example.accessingdatajpa.entity.Velo;
import com.example.accessingdatajpa.repository.api.VeloRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class VeloRepositoryImpl extends BaseRepository implements VeloRepository {


    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public VeloRepositoryImpl(EntityManager entityManager) {
        super(entityManager);

    }
    @Override
    public List<Velo> findAll() {
        return entityManager.createNamedQuery("get-all-velos", Velo.class)
                .getResultList();
    }

    @Override
    public void delete(Velo entity) {
        entityManager.remove(entity);
    }

    @Override
    public Velo getById(Long aLong) {
        return null;
    }

    //No need
    @Override
    public List<Velo> findByModeleDeVelo_ModeleNameIs(String modeleName) {
        return null;
    }

    @Override
    public List<Velo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Velo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Velo> findAllById(Iterable<Long> longs) {
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
    public void deleteAll(Iterable<? extends Velo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Velo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Velo> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Velo> findById(Long aLong) {
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
    public <S extends Velo> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Velo> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Velo> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Velo getOne(Long aLong) {
        return null;
    }


    @Override
    public <S extends Velo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Velo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Velo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Velo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Velo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Velo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Velo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Velo> findByVeloId(Long veloId) {
        return null;
    }

    @Override
    public List<Velo> findVelosByEtatV(AllEnums.Etat etatV) {
        return null;
    }
}
