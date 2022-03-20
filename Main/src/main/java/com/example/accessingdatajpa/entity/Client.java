package com.example.accessingdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
public class Client {

    @Id
    @SequenceGenerator(
            name="LOCATION_SEQ",
            sequenceName = "LOCATION_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="LOCATION_SEQ"
    )
    private Long clientId;

    @Column(name = "numero_carte_bancaire")
    private int numeroCarteBancaire;

    @Column(name = "code_secret")
    private int codeSecret;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long id) {
        this.clientId = id;
    }
}
