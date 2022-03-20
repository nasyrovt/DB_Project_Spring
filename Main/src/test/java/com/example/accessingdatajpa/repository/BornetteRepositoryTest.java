package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.AllEnums;
import com.example.accessingdatajpa.entity.Bornette;
import com.example.accessingdatajpa.entity.Modele;
import com.example.accessingdatajpa.entity.Station;
import com.example.accessingdatajpa.entity.Velo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class BornetteRepositoryTest {

    @Autowired
    BornetteRepository bornetteRepository;


    @Test
    public void saveBornette(){

        Modele modeleSport = Modele.builder()
                .modeleName("Sport")
                .prix(2.2f)
                .build();

        Velo velo = Velo.builder()
                .modeleDeVelo(modeleSport)
                .etatV(AllEnums.Etat.ETAT_OK)
                .miseEnService(LocalDateTime.now())
                .puceId(3)
                .build();

        Station station = Station.builder()
                .adresse("1, cours Jean Jaures, 38000 Grenoble")
                .classification(AllEnums.Classification.vNul)
                .build();

        Bornette bornette = Bornette.builder()
                .etatB(AllEnums.Etat.ETAT_OK)
                .station(station)
                .velo(velo)
                .build();

        bornetteRepository.save(bornette);
    }

    @Test
    public void printAllBornettes(){
        List<Bornette> bornettes = bornetteRepository.findAll();

        for (Bornette bornette : bornettes) {
            System.out.println(bornette);
        }
    }
}