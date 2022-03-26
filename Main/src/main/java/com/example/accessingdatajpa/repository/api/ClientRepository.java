package com.example.accessingdatajpa.repository.api;

import com.example.accessingdatajpa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByCodeSecret(String codeSecret);
}
