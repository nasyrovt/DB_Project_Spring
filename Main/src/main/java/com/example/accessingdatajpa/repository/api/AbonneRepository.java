package com.example.accessingdatajpa.repository.api;

import com.example.accessingdatajpa.entity.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonneRepository extends JpaRepository<Abonne, Long> {
    Abonne findByAbonneId(Long abonneId);
}
