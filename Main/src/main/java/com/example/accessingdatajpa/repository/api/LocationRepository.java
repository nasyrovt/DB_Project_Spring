package com.example.accessingdatajpa.repository.api;

import com.example.accessingdatajpa.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByClient_CodeSecret(String client_codeSecret);
    Location getByLocationId(Long locationId);
}
