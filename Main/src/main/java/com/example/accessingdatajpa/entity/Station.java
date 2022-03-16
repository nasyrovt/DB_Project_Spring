package com.example.accessingdatajpa.entity;

import com.example.accessingdatajpa.AllEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Station {

    @Id
    @SequenceGenerator(
            name="STATION_SEQ",
            sequenceName = "STATION_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="STATION_SEQ"
    )
    private Long stationId;

    private String adresse;
    private AllEnums.Classification classification;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(
//            name="station_id",
//            referencedColumnName = "stationId"
//    )
//    private List<Bornette> bornette;
//    private AllEnums.TempJournee status;
}
