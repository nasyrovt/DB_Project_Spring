package com.example.accessingdatajpa.repository.api;

import com.example.accessingdatajpa.AllEnums;
import com.example.accessingdatajpa.entity.Bornette;
import com.example.accessingdatajpa.entity.Station;
import com.example.accessingdatajpa.entity.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BornetteRepository extends JpaRepository<Bornette, Long> {

    Bornette findByCurrentVelo(Velo currentVelo);
    List<Bornette> findByStationMereAndCurrentVelo_EtatV(Station stationMere, AllEnums.Etat currentVelo_etatV);
    Bornette findFirstByStationMereAndCurrentVelo_ModeleDeVelo_ModeleName(Station stationMere, String currentVelo_modeleDeVeloModeleName);

}
