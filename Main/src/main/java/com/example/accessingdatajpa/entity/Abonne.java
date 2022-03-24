package com.example.accessingdatajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="tbl_abonne")
@NamedQueries(
        @NamedQuery(name = "get-all-abonne", query = "select a from Abonne a")
)
public class Abonne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long abonneId;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="dateDeN")
    private LocalDateTime dateDeN;

    @Column(name="sexe")
    private int sexe;

    @Column(name="adresse")
    private String adresse;

    @Column(name="final_reduction")
    private final float finalReduction = 0.3f;

    @Column(name="date_debut_abonnement")
    private LocalDateTime dateDebutAbonne;

    @Column(name="date_end_abonnement")
    private LocalDateTime dateFinAbonne;

    @Column(name="prime")
    private float prime;


    public Long getAbonneId() {
        return abonneId;
    }

    public void setAbonneId(Long id) {
        this.abonneId = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDateTime getDateDeN() {
        return dateDeN;
    }

    public void setDateDeN(LocalDateTime dateDeN) {
        this.dateDeN = dateDeN;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public float getFinalReduction() {
        return finalReduction;
    }

    public LocalDateTime getDateDebutAbonne() {
        return dateDebutAbonne;
    }

    public void setDateDebutAbonne(LocalDateTime dateDebutAbonne) {
        this.dateDebutAbonne = dateDebutAbonne;
    }

    public LocalDateTime getDateFinAbonne() {
        return dateFinAbonne;
    }

    public void setDateFinAbonne(LocalDateTime dateFinAbonne) {
        this.dateFinAbonne = dateFinAbonne;
    }

    public float getPrime() {
        return prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }
}
