package com.example.accessingdatajpa.entity;

import com.example.accessingdatajpa.AllEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl_bornette")
@ToString
@NamedQueries(
        @NamedQuery(name = "get-all-bornettes", query = "select b from Bornette b")
)
public class Bornette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bornetteId;

    @Column(name = "etat_bornette")
    private AllEnums.Etat etatB;

    //References Station, because it can not exist without it
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_mere")
    private Station stationMere;

    @OneToOne
    @JoinColumn(name = "current_velo")
    private Velo currentVelo;

    public Velo getCurrentVelo() {
        return currentVelo;
    }

    public void setCurrentVelo(Velo currentVelo) {
        this.currentVelo = currentVelo;
    }

    public Long getBornetteId() {
        return bornetteId;
    }

    public void setBornetteId(Long bornetteId) {
        this.bornetteId = bornetteId;
    }

    public AllEnums.Etat getEtatB() {
        return etatB;
    }

    public void setEtatB(AllEnums.Etat etatB) {
        this.etatB = etatB;
    }

    public Station getStationMere() {
        return stationMere;
    }

    public void setStationMere(Station stationMere) {
        this.stationMere = stationMere;
    }
}
