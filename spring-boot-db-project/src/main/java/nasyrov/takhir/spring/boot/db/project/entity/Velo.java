package nasyrov.takhir.spring.boot.db.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nasyrov.takhir.spring.boot.db.project.AllEnums;
import nasyrov.takhir.spring.boot.db.project.Modele;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Velo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Embedded
    private Modele modeleVelo;
    private AllEnums.Etat etatV;
    private String miseEnService; //2022-03-14T13:24:48.371918
    private int puceId;
}
