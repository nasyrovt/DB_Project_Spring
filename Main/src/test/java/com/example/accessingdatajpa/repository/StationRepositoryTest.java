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

        Velo velo = veloRepository.getById(1L);
        Velo velo2 = veloRepository.getById(2L);
        Velo velo3 = veloRepository.getById(3L);
        Velo velo4 = veloRepository.getById(4L);

        Bornette bornette = Bornette.builder()
                .currentVelo(velo)
                .etatB(AllEnums.Etat.ETAT_OK)
                .build();
        Bornette bornette4 = Bornette.builder()
                .etatB(AllEnums.Etat.ETAT_OK)
                .build();
        Bornette bornette5 = Bornette.builder()
                .etatB(AllEnums.Etat.ETAT_OK)
                .build();
        Bornette bornette6 = Bornette.builder()
                .etatB(AllEnums.Etat.ETAT_OK)
                .build();

        Bornette bornette2 = Bornette.builder()
                .currentVelo(velo2)
                .etatB(AllEnums.Etat.ETAT_OK)
                .build();

        Bornette bornette3 = Bornette.builder()
                .currentVelo(velo4)
                .etatB(AllEnums.Etat.ETAT_OK)
                .build();

        List<Bornette> borenttes = Arrays.asList(bornette, bornette2, bornette3,bornette4, bornette5,bornette6);

        Station station = Station.builder()
                .bornettes(borenttes)
                .adresse("28 avenue Felix Vialet, 38000 Grenoble")
                .classification(AllEnums.Classification.vNul)
                .build();

        bornette2.setStationMere(station);
        bornette3.setStationMere(station);
        bornette.setStationMere(station);
        bornette4.setStationMere(station);
        bornette5.setStationMere(station);
        bornette6.setStationMere(station);

        bornetteRepository.saveAll(borenttes);


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