package com.example.accessingdatajpa.repository.api;

import com.example.accessingdatajpa.AllEnums;
import com.example.accessingdatajpa.entity.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface VeloRepository  extends JpaRepository<Velo, Long> {

    List<Velo> findByModeleDeVelo_ModeleNameIs(String modeleName);
    List<Velo> findByModeleDeVelo_ModeleNameAndEtatV(String modeleDeVeloModeleName, AllEnums.Etat etatV);


    // Fetching Data
    List<Velo> findAll();
    List<Velo> findByVeloId(Long veloId);

    List<Velo> findVelosByEtatV(AllEnums.Etat etatV);

//    @Query("select v from Velo v where v.puceId =?1") //JPQL Query
//    Velo getVeloByPuceId(int puceId);
//
//    @Query("select v.modeleDeVelo.modeleName from Velo v where v.veloId =?1") //JPQL Query
//    String getVeloModeleVeloByVeloId(Long veloId);
}
