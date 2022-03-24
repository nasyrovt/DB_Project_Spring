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

        Velo velo = veloRepository.getById(1L);

        Bornette bornette = Bornette.builder()
                .etatB(AllEnums.Etat.ETAT_HS)
                .build();

        Station station = Station.builder()
                .bornettes(Collections.singletonList(bornette))
                .adresse("28 avenue Felix Vialet, 38000 Grenoble")
                .classification(AllEnums.Classification.vNul)
                .build();

        bornette.setStationMere(station);

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