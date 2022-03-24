package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.AllEnums;
import com.example.accessingdatajpa.entity.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VeloRepository  extends JpaRepository<Velo, Long> {


    // Fetching Data
    public List<Velo> findAll();
    public List<Velo> findByVeloId(Long veloId);

    public List<Velo> findVelosByEtatV(AllEnums.Etat etatV);

//    @Query("select v from Velo v where v.puceId =?1") //JPQL Query
//    Velo getVeloByPuceId(int puceId);
//
//    @Query("select v.modeleDeVelo.modeleName from Velo v where v.veloId =?1") //JPQL Query
//    String getVeloModeleVeloByVeloId(Long veloId);
}
