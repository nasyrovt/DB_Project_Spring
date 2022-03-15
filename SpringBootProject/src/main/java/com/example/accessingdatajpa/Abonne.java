package JavaClasses;

import JavaClasses.AllEnums.Sexe;
import java.time.LocalDateTime;

public class Abonne extends Client{
    
    private String nom;
    private String prenom;
    private LocalDateTime dateDeN;
    private int numRue;
    private Sexe sexe;
    private String rue;
    private int codePostal;
    private String ville;
    private Double finalReduction;
    private LocalDateTime debutDateAbonne;
    private LocalDateTime finDateAbonne;
    private int prime;

    Abonne(int id,int codeSecret,String numCB,String nom,String prenom,LocalDateTime dateDeN,int numRue,Sexe sexe,String rue,int codePostal,String ville,Double finalReduction,LocalDateTime finDateTime){
        super(id, codeSecret, numCB);
        this.nom=nom;
        this.prenom=nom;
        this.dateDeN=dateDeN;
        this.numRue=numRue;
        this.sexe=sexe;
        this.rue=rue;
        this.codePostal=codePostal;
        this.ville=ville;
        this.finalReduction=finalReduction;
        this.finDateAbonne=finDateTime;
        this.debutDateAbonne=LocalDateTime.now();
        
    }
    
    public int getNumRue(){
        return this.numRue;
    }
    public int getCodePostal(){
        return this.codePostal;
    }
    public int getPrime(){
        return this.prime;
    }
    public Sexe getSexe(){
        return this.sexe;
    }
    public String getVille(){
        return this.ville;
    }
    public String getNome(){
        return this.nom;
    }
    public LocalDateTime getDateDeN(){
        return this.dateDeN;
    }
    public LocalDateTime getFinalDateAbonnee(){
        return this.finDateAbonne;
    }
    public LocalDateTime getDebutDateAbonnee(){
        return this.debutDateAbonne;
    }
     
    public void setNom(String nom){
        this.nom=nom;
    }  
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void setVille(String v){
        this.ville=v;
    }  
    public void setDateDeN(LocalDateTime date){
        this.dateDeN=date;
    }
    public void setDateDebut(LocalDateTime date){
        this.debutDateAbonne=date;
    }
    public void setDateFin(LocalDateTime date){
        this.finDateAbonne=date;
    }
    public void setNumRue(int numRue){
        this.numRue=numRue;
    }
    public void setSexe(Sexe sexe){
        this.sexe=sexe;
    }
    public void setCodePostal(int codePostal){
        this.codePostal=codePostal;
    }
    public void setPrime(int prime){
        this.prime=prime;
    }
    
   
}
