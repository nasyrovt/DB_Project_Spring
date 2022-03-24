package com.example.accessingdatajpa.repository.api;

import com.example.accessingdatajpa.entity.Bornette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BornetteRepository extends JpaRepository<Bornette, Long> {

}
