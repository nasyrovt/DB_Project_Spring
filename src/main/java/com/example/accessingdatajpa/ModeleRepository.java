package com.example.accessingdatajpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ModeleRepository extends CrudRepository<Velo, Long> {

    Modele findById(long id);

}