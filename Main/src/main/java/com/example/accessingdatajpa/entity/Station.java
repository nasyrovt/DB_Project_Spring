package com.example.accessingdatajpa.entity;

import com.example.accessingdatajpa.AllEnums;
import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="TBL_STATION")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stationId;

    @Column(name="adresse")
    private String adresse;

    @Column(name="classification")
    private AllEnums.Classification classification;

//    @OneToMany(mappedBy = "stationDepart", fetch = FetchType.LAZY)
//    private List<Location> locationsDepart;
//
//    @OneToMany(mappedBy = "stationArrivee")
//    private List<Location> locationsArrivee;

    @OneToMany(mappedBy = "stationMere", fetch = FetchType.EAGER)
    private List<Bornette> bornettes;

}
