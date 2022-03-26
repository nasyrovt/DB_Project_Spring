package com.example.accessingdatajpa.repository.api;

import com.example.accessingdatajpa.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

}
