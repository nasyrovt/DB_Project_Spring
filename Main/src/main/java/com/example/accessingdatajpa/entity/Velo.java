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
        name="tbl_velo",
        uniqueConstraints = @UniqueConstraint(
                name="puce_unique",
                columnNames = "numero_de_puce"
        )
)
@ToString
public class Velo {

    @Id
    @SequenceGenerator(
            name="VELO_SEQ",
            sequenceName = "VELO_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "VELO_SEQ"
    )
    private Long veloId;

    @Embedded
    private Modele modeleDeVelo;

    @Column(name="etat_de_velo")
    private AllEnums.Etat etatV;

    @Column(name="date_de_mise_en_service")
    private LocalDateTime miseEnService; //2022-03-14T13:24:48.371918

    @Column(name="numero_de_puce", nullable = false)
    private int puceId;

//    @OneToOne(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    @JoinColumn(
//            name="bornette_id",
//            referencedColumnName = "bornetteId",
//            insertable=false,
//            updatable=false
//    )
//    @ToString.Exclude
//    private Bornette bornette;
//
//
//    public void setBornette(Bornette bornette) {
//        this.bornette = bornette;
//    }
//
//    public Bornette getBornette() {
//        return bornette;
//    }

    public Long getId() {
        return this.veloId;
    }
}
