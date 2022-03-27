package com.example.accessingdatajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="TBL_CLIENT")
@NamedQueries(
        @NamedQuery(name = "get-all-clients", query = "select c from Client c")
)
public class Client {

    @Id
    @SequenceGenerator(
            name="client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long clientId;

    @Column(name = "numero_CB")
    private Long numeroCarteBancaire;

    @Column(name = "code_secret")
    private String codeSecret;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long id) {
        this.clientId = id;
    }

    public Long getNumeroCarteBancaire() {
        return numeroCarteBancaire;
    }

    public void setNumeroCarteBancaire(Long numero){ this.numeroCarteBancaire = numero;}

    public String getCodeSecret(){ return this.codeSecret;}

    public void setCodeSecret(String code){ this.codeSecret = code;}
}
