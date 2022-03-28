package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.AllEnums;
import com.example.accessingdatajpa.entity.Modele;
import com.example.accessingdatajpa.entity.Velo;
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
class VeloRepositoryTest {

    @Autowired
    private VeloRepository veloRepository;


    @Test
    @Order(1)
    public void saveVelos(){

        Modele sportModele = Modele.builder()
                .modeleName("Sport")
                .prix(2.2f)
                .build();

        Modele vttModele = Modele.builder()
                .modeleName("Tourist")
                .prix(2.5f)
                .build();

        Velo veloVTT = Velo.builder()
                .modeleDeVelo(vttModele)
                .puceId(5)
                .etatV(AllEnums.Etat.ETAT_OK)
                .miseEnService(LocalDateTime.now())
                .build();

        Velo veloSport = Velo.builder()
                .modeleDeVelo(sportModele)
                .puceId(6)
                .etatV(AllEnums.Etat.ETAT_OK)
                .miseEnService(LocalDateTime.now())
                .build();

        veloRepository.save(veloVTT);
        veloRepository.save(veloSport);
    }

    @Test
    @Order(2)
    public void printAllVelo(){
        List<Velo> veloList=
                veloRepository.findAll();

        for (Velo velo : veloList) {
            System.out.println(velo);
        }
    }

    @Test
    @Order(3)
    public void printVeloById(){
        List<Velo> velos = veloRepository.findByVeloId(1L);
        

        System.out.println(velos);
    }

    @Test
    @Order(4)
    public void printVeloByEtat(){
        List<Velo> velosOK = veloRepository.findVelosByEtatV(AllEnums.Etat.ETAT_OK);

        System.out.println("Velos ids of working velos: ");
        for (Velo velo: velosOK) {
            System.out.println(velo.getVeloId());
        }
    }

    @Test
    @Order(5)
    public void printVeloByModelName(){
        List<Velo> velosVTT = veloRepository.findByModeleDeVelo_ModeleNameIs("VTT");

        System.out.println("VTT-Velos ids: ");
        for (Velo velo: velosVTT) {
            System.out.println(velo.getVeloId());
        }
    }

    @Test
    @Order(5)
    public void saveMoreVelos(){

        Modele modele1 = Modele.builder()
                .modeleName("BMX")
                .prix(1.5f)
                .build();

        Modele modele2 = Modele.builder()
                .modeleName("Giant")
                .prix(3.0f)
                .build();

        Modele sportModele = Modele.builder()
                .modeleName("Sport")
                .prix(2.2f)
                .build();

        Modele vttModele = Modele.builder()
                .modeleName("VTT")
                .prix(2.5f)
                .build();

        Modele modele3 = Modele.builder()
                .modeleName("Tourist")
                .prix(2.2f)
                .build();

        Modele modele4 = Modele.builder()
                .modeleName("VTX")
                .prix(2.5f)
                .build();

        for(int i = 8; i<=11; i++){
            Velo velo1 = Velo.builder()
                    .modeleDeVelo(modele2)
                    .puceId(i)
                    .etatV(AllEnums.Etat.ETAT_OK)
                    .miseEnService(LocalDateTime.now())
                    .build();

            Velo velo2 = Velo.builder()
                    .modeleDeVelo(modele1)
                    .puceId(i+300)
                    .etatV(AllEnums.Etat.ETAT_OK)
                    .miseEnService(LocalDateTime.now())
                    .build();

            Velo veloVTT = Velo.builder()
                    .modeleDeVelo(vttModele)
                    .puceId(i+100)
                    .etatV(AllEnums.Etat.ETAT_OK)
                    .miseEnService(LocalDateTime.now())
                    .build();

            Velo veloSport = Velo.builder()
                    .modeleDeVelo(sportModele)
                    .puceId(i+200)
                    .etatV(AllEnums.Etat.ETAT_OK)
                    .miseEnService(LocalDateTime.now())
                    .build();

            Velo veloVTX = Velo.builder()
                    .modeleDeVelo(modele3)
                    .puceId(i+400)
                    .etatV(AllEnums.Etat.ETAT_OK)
                    .miseEnService(LocalDateTime.now())
                    .build();

            Velo velo3 = Velo.builder()
                    .modeleDeVelo(modele4)
                    .puceId(i+500)
                    .etatV(AllEnums.Etat.ETAT_OK)
                    .miseEnService(LocalDateTime.now())
                    .build();

            veloRepository.save(velo1);
            veloRepository.save(velo2);
            veloRepository.save(veloVTT);
            veloRepository.save(veloSport);
            veloRepository.save(veloVTX);
            veloRepository.save(velo3);
        }
    }

}