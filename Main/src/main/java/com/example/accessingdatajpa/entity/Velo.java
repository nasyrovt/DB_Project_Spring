package com.example.accessingdatajpa.entity;

import com.example.accessingdatajpa.AllEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;



@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name="TBL_VELO",
        uniqueConstraints = @UniqueConstraint(
                name="puce_unique",
                columnNames = "numero_de_puce"
        )
)
@ToString
@NamedQueries(
        @NamedQuery(name = "get-all-velos", query = "select v from Velo v")
)
public class Velo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long veloId;

    @Embedded
    private Modele modeleDeVelo;

    @Column(name="etat_de_velo")
    private AllEnums.Etat etatV;

    @Column(name="date_de_mise_en_service")
    private LocalDateTime miseEnService; //2022-03-14T13:24:48.371918

    @Column(name="numero_de_puce", nullable = false)
    private int puceId;

    @Transient
    public void setModeleDeVeloModeleName(String name){
        this.modeleDeVelo.setModeleName(name);
    }

    public String getModeleDeVeloModeleName(){
        return this.modeleDeVelo.getModeleName();
    }

    @Transient
    public void setModeleDeVeloPrix(float prix){
        this.modeleDeVelo.setPrix(prix);
    }

    public float getModeleDeVeloPrix(){
        return this.modeleDeVelo.getPrix();
    }


    public LocalDateTime getMiseEnService() {
        return miseEnService;
    }

    public void setMiseEnService(LocalDateTime miseEnService) {
        this.miseEnService = miseEnService;
    }

    public AllEnums.Etat getEtatV() {
        return etatV;
    }

    public void setEtatV(AllEnums.Etat etatV) {
        this.etatV = etatV;
    }

    public Long getVeloId() {
        return veloId;
    }

    public void setVeloId(Long veloId) {
        this.veloId = veloId;
    }

    public int getPuceId() {
        return puceId;
    }

    public void setPuceId(int puceId) {
        this.puceId = puceId;
    }
}
