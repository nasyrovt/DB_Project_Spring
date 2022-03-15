package nasyrov.takhir.spring.boot.db.project;


import javax.persistence.*;


@Embeddable
public class Modele {

    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String modeleVelo;
    private float prix;

    public Modele(){}

    public Modele(String modele, float prix){
        this.modeleVelo = modele;
        this.prix = prix;
    }

    public String getModele(){
        return this.modeleVelo;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
