package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.entity.Location;
import com.example.accessingdatajpa.entity.Station;
import com.example.accessingdatajpa.repository.api.LocationRepository;
import com.example.accessingdatajpa.repository.api.StationRepository;
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

    @Test
    void saveLocation(){
        Station station = stationRepository.getById(3L);
        Station arrive = stationRepository.getById(4L);
        Location location = Location.builder()
                .locationId(2L)
                .stationDepart(station)
                .stationArrivee(arrive)
                .startDate(LocalDateTime.now())
                .build();

        locationRepository.save(location);
    }
}