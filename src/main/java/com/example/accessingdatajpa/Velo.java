package com.example.accessingdatajpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import com.example.accessingdatajpa.AllEnums.Etat;

@Entity
public class Velo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long idModeleVelo;
    private AllEnums.Etat etatV;
    private LocalDateTime miseEnService; //2022-03-14T13:24:48.371918
    private int puce;

    //exists only for JPA sakes and that's why it is protected
    protected Velo() {}

    public Velo(Long idModeleVelo, AllEnums.Etat etatV, LocalDateTime miseEnService, int puce) {
        this.idModeleVelo=idModeleVelo;
        this.etatV = etatV;
        this.miseEnService = miseEnService;
        this.puce = puce;
    }

    @Override
    public String toString() {
        return String.format("Velo [id=%d, modele='%d', etat='%s']",
                id, idModeleVelo, etatV.toString());
    }

    public Long getId(){
        return this.id;
    }
    public Long getIdModele(){
        return this.idModeleVelo;
    }
    public AllEnums.Etat getEtat(){
        return this.etatV;
    }
    public int getPuce(){
        return this.puce;
    }

    public LocalDateTime getCurrentTime(){
        return this.miseEnService;
    }

    public void seModel(Long model){
        this.idModeleVelo=model;
    }
    public void setEtat(Etat etat){
        this.etatV=etat;
    }
    public void setPuce(int puce){
        this.puce=puce;
    }
    public void setTime(){
        this.miseEnService=LocalDateTime.now();
    }
}