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
class VeloRepositoryTest {

    @Autowired
    private VeloRepository veloRepository;


    @Test
    public void saveVelo(){

        Bornette bornette = Bornette.builder()
                .etatB(AllEnums.Etat.ETAT_OK)
                .build();

        Modele vttModele = Modele.builder()
                .modeleName("VTT")
                .prix(2.5f)
                .build();

        Velo veloVTT_2 = Velo.builder()
                .modeleDeVelo(vttModele)
                .puceId(2)
                .bornette(bornette)
                .etatV(AllEnums.Etat.ETAT_OK)
                .miseEnService(LocalDateTime.now())
                .build();

        veloRepository.save(veloVTT_2);
    }

    @Test
    public void printAllVelo(){
        List<Velo> veloList=
                veloRepository.findAll();

        System.out.println("veloList = " + veloList);
    }

    @Test
    public void printVeloById(){
        List<Velo> velos = veloRepository.findByVeloId(1L);

        System.out.println(velos);
    }

    @Test
    public void printVeloByModelName(){
        List<Velo> velosVTT = veloRepository.findByModeleDeVeloModeleName("VTT");

        System.out.println("VTT velos id's: ");
        for (Velo velo: velosVTT) {
            System.out.println(velo.getId());
        }
    }

    @Test
    public void printVeloPrixGreaterThan(){
        float price = 2f;
        List<Velo> velosGT2 = veloRepository.findByModeleDeVeloPrixGreaterThan(price);

        System.out.println("Velos with price greater than "+ price + ": " + velosGT2);
    }

    @Test
    public void printVeloByPuceId(){

        Velo veloByPuce = veloRepository.getVeloByPuceId(1);

        System.out.println(veloByPuce);
    }

    @Test
    public void printVeloByEtat(){
        List<Velo> velosOK = veloRepository.findVelosByEtatV(AllEnums.Etat.ETAT_OK);

        System.out.println("Velos ids of working velos: ");
        for (Velo velo: velosOK) {
            System.out.println(velo.getId());
        }
    }

    @Test
    public void printVeloModeleByVeloId(){
        String veloModele = veloRepository.getVeloModeleVeloByVeloId(1L);
        System.out.println(veloModele);

    }

    @Test
    public void updateVeloEtatVByVeloIdTest(){
        veloRepository.updateVeloEtatVByVeloId(AllEnums.Etat.ETAT_HS, 1l);
    }
}