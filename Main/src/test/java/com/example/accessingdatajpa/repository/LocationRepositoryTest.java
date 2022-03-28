package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.entity.Client;
import com.example.accessingdatajpa.entity.Location;
import com.example.accessingdatajpa.entity.Station;
import com.example.accessingdatajpa.entity.Velo;
import com.example.accessingdatajpa.repository.api.ClientRepository;
import com.example.accessingdatajpa.repository.api.LocationRepository;
import com.example.accessingdatajpa.repository.api.StationRepository;
import com.example.accessingdatajpa.repository.api.VeloRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class LocationRepositoryTest {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    StationRepository stationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    VeloRepository veloRepository;

    @Test
    void saveLocation(){
        Station station = stationRepository.getById(1L);
        Station arrive = stationRepository.getById(1L);
        Velo velo = veloRepository.getById(1L);
        Client client = clientRepository.getById(1L);

        long size = Long.parseLong(String.valueOf(locationRepository.findAll().size()));

        Location location = Location.builder()
                .locationId(size+1)
                .client(client)
                .velo(velo)
                .stationDepart(station)
                .startDate(LocalDateTime.now())
                .build();

        locationRepository.save(location);
    }
}