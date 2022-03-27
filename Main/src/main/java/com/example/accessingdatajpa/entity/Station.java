package com.example.accessingdatajpa.entity;

import com.example.accessingdatajpa.AllEnums;
import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TBL_STATION")
@NamedQueries(
        @NamedQuery(name = "get-all-stations", query = "select s from Station s")
)
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stationId;

    @Column(name="adresse")
    private String adresse;

    @Column(name="classification")
    private AllEnums.Classification classification;


    @OneToMany(mappedBy = "stationMere", fetch = FetchType.EAGER)
    private List<Bornette> bornettes;

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public AllEnums.Classification getClassification() {
        return classification;
    }

    public void setClassification(AllEnums.Classification classification) {
        this.classification = classification;
    }

    public List<Bornette> getBornettes() {
        return bornettes;
    }

    public void setBornettes(List<Bornette> bornettes) {
        this.bornettes = bornettes;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", classification=" + classification +
                '}';
    }
}
