package com.example.accessingdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="TBL_CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "numero_CB")
    private int numeroCarteBancaire;

    @Column(name = "code_secret")
    private String codeSecret;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long id) {
        this.clientId = id;
    }

    public int getNumeroCarteBancaire() {
        return numeroCarteBancaire;
    }

    public void setNumeroCarteBancaire(int numero){ this.numeroCarteBancaire = numero;}

    public String getCodeSecret(){ return this.codeSecret;}

    public void setCodeSecret(String code){ this.codeSecret = code;}
}
