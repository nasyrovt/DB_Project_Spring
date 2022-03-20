package com.example.accessingdatajpa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    @Id
    @SequenceGenerator(
            name="LOCATION_SEQ",
            sequenceName = "LOCATION_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="LOCATION_SEQ"
    )
    private Long locationId;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name="end_date")
    private LocalDateTime endDate;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name="station_id",
            referencedColumnName = "stationId"
    )
    private Station stationDepart;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "station_id",
            referencedColumnName = "stationId"
    )
    private Station stationArriveId;

    public Station getStationArriveId() {
        return stationArriveId;
    }

    public Long getId() {
        return locationId;
    }

    public void setId(Long id) {
        this.locationId = id;
    }
}
