package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.AllEnums;
import com.example.accessingdatajpa.entity.Bornette;
import com.example.accessingdatajpa.entity.Modele;
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

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BornetteRepositoryTest {

    @Autowired
    BornetteRepository bornetteRepository;

    @Autowired
    VeloRepository veloRepository;

    @Autowired
    StationRepository stationRepository;

    @Test
    @Order(1)
    public void saveBornette(){

        Velo velo = veloRepository.getById(2L);

        Station station = stationRepository.getById(1L);

        Bornette bornette = Bornette.builder()
                .etatB(AllEnums.Etat.ETAT_HS)
                .stationMere(station)
                .currentVelo(velo)
                .build();

        bornetteRepository.save(bornette);
    }

    @Test
    @Order(2)
    public void printAllBornettes(){
        List<Bornette> bornettes = bornetteRepository.findAll();

        for (Bornette bornette : bornettes) {
            System.out.println(bornette);
        }
    }

    @Test
    @Order(1)
    public void reloadBornettes(){
        Velo velo;
        Station station = stationRepository.getById(1L);
        Bornette bornette;
        for(long i=1;i<7;i++){
            velo = veloRepository.getById(i);

            bornette = Bornette.builder()
                    .bornetteId(i)
                    .etatB(AllEnums.Etat.ETAT_HS)
                    .stationMere(station)
                    .currentVelo(velo)
                    .build();

            bornetteRepository.save(bornette);
        }

    }
}