package com.example.accessingdatajpa;
import com.example.accessingdatajpa.AllEnums;

import javax.persistence.*;


@Entity
public class Modele {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String modeleVelo;
    private float prix;

    public Modele(){}

    public Modele(String modele, float prix){
        this.modeleVelo = modele;
        this.prix = prix;
    }

    public String getModele(){
        return this.modeleVelo;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
