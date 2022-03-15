package com.example.accessingdatajpa.entity;

import com.example.accessingdatajpa.AllEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bornette {

    @Id
    @SequenceGenerator(
            name="BORNETTE_SEQ",
            sequenceName = "BORNETTE_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="BORNETTE_SEQ"
    )
    private Long bornetteId;

    @Column(name = "etat_dela_bornette")
    private AllEnums.Etat etatB;

    //References Station, because it can not exist without it
    @ManyToOne
    @JoinColumn(
            name="station_id",
            referencedColumnName = "stationId"
    )
    private Station station;
}
