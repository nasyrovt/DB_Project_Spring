package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.AllEnums;
import com.example.accessingdatajpa.entity.Bornette;
import com.example.accessingdatajpa.entity.Station;
import com.example.accessingdatajpa.entity.Velo;
import com.example.accessingdatajpa.repository.api.BornetteRepository;
import com.example.accessingdatajpa.repository.api.StationRepository;
import com.example.accessingdatajpa.repository.api.VeloRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StationRepositoryTest {

    @Autowired
    StationRepository stationRepository;

    @Autowired
    VeloRepository veloRepository;

    @Autowired
    BornetteRepository bornetteRepository;

    @Test
    @Order(1)
    public void saveStation(){
        Velo velo;
        Bornette bornette;
        Station station;
        boolean isSet = false;
        List<Bornette> bornettes = new ArrayList<>();
        for(long i =21;i<24;i++){
            velo = veloRepository.getById(i);
            bornette = Bornette.builder()
                    .bornetteId(i)
                    .currentVelo(null)
                    .etatB(AllEnums.Etat.ETAT_OK)
                    .build();
            bornettes.add(bornette);
        }
        station = stationRepository.getById(10L);
        for(Bornette born : bornettes){
            born.setStationMere(station);
        }
        bornetteRepository.saveAll(bornettes);

        stationRepository.save(station);
    }

    @Test
    @Order(2)
    public void printStations(){
        List<Station> stations = stationRepository.findAll();

        for (Station station : stations) {
            System.out.println(station);
        }
    }

}