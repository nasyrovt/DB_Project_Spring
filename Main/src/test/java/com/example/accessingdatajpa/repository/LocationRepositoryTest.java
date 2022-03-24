package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.repository.api.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocationRepositoryTest {

    @Autowired
    LocationRepository locationRepository;
}