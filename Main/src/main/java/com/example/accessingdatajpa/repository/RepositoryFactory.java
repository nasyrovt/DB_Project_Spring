package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.repository.api.*;
import com.example.accessingdatajpa.repository.impl.*;

import javax.persistence.EntityManager;

public class RepositoryFactory {

    public AbonneRepository abonneRepository;
    public BornetteRepository bornetteRepository;
    public ClientRepository clientRepository;
    public LocationRepository locationRepository;
    public StationRepository stationRepository;
    public VeloRepository veloRepository;

    public RepositoryFactory(EntityManager entityManager){
        abonneRepository = abonneRepository(entityManager);
        bornetteRepository = bornetteRepository(entityManager);
        clientRepository = clientRepository(entityManager);
        locationRepository = locationRepository(entityManager);
        stationRepository = stationRepository(entityManager);
        veloRepository = veloRepository(entityManager);

    }

    public AbonneRepository abonneRepository(EntityManager entityManager) {
        return new AbonneRepositoryImpl(entityManager);
    }

    public BornetteRepository bornetteRepository(EntityManager entityManager) {
        return new BornetteRepositoryImpl(entityManager);
    }

    public ClientRepository clientRepository(EntityManager entityManager) {
        return new ClientRepositoryImpl(entityManager);
    }

    public LocationRepository locationRepository(EntityManager entityManager) {
        return new LocationRepositoryImpl(entityManager);
    }

    public StationRepository stationRepository(EntityManager entityManager) {
        return new StationRepositoryImpl(entityManager);
    }

    public VeloRepository veloRepository(EntityManager entityManager) {
        return new VeloRepositoryImpl(entityManager);
    }

}