package nasyrov.takhir.spring.boot.db.project;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Velo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Embedded
    private Modele modeleVelo;
    private AllEnums.Etat etatV;
    private LocalDateTime miseEnService; //2022-03-14T13:24:48.371918
    private int puce;

    //exists only for JPA sakes and that's why it is protected
    protected Velo() {}

    public Velo(Modele modeleVelo, AllEnums.Etat etatV, LocalDateTime miseEnService, int puce) {
        this.modeleVelo = modeleVelo;
        this.etatV = etatV;
        this.miseEnService = miseEnService;
        this.puce = puce;
    }

    @Override
    public String toString() {
        return String.format("Velo [id=%d, modele='%d', etat='%s']",
                id, modeleVelo, etatV.toString());
    }

    public Long getId(){
        return this.id;
    }
    public Modele getIdModele(){
        return this.modeleVelo;
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

    public void seModel(Modele modele){
        this.modeleVelo = modele;
    }
    public void setEtat(AllEnums.Etat etat){
        this.etatV=etat;
    }
    public void setPuce(int puce){
        this.puce=puce;
    }
    public void setTime(){
        this.miseEnService=LocalDateTime.now();
    }
}