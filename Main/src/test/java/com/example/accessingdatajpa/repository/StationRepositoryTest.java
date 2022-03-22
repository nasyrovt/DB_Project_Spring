package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.AllEnums;
import com.example.accessingdatajpa.entity.Bornette;
import com.example.accessingdatajpa.entity.Station;
import com.example.accessingdatajpa.entity.Velo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StationRepositoryTest {

    @Autowired
    StationRepository stationRepository;

    @Autowired
    VeloRepository veloRepository;

    @Autowired
    BornetteRepository bornetteRepository;

    @Test
    public void testSaveStation(){

        Velo velo = veloRepository.getVeloByPuceId(1);

        Bornette bornette = Bornette.builder()
                .etatB(AllEnums.Etat.ETAT_HS)
//                .velo(velo)
                .build();

//        List<Bornette> bornettes = bornetteRepository.findAll();

        Station station = Station.builder()
//                .bornette(Collections.singletonList(bornette))
                .adresse("28 avenue Felix Vialet, 38000 Grenoble")
                .classification(AllEnums.Classification.vNul)
                .build();

        stationRepository.save(station);
    }

}