package com.example.accessingdatajpa;

import com.example.accessingdatajpa.AllEnums.Classification;
import com.example.accessingdatajpa.AllEnums.TempJournee;
public class Station {
    
    private int id;
    private String rue;
    private String ville;
    private int cp;
    private Classification classification;
    private TempJournee jounree;



    Station(int id ,String rue,String ville,int cp,Classification classification,TempJournee jounree){
        this.id=id;
        this.rue=rue;
        this.ville=ville;
        this.cp=cp;
        this.classification=classification;
        this.jounree=jounree;
    }

    
    
    public int getId(){
        return this.id;
    }
    public TempJournee gTempJournee(){
        return this.jounree;
    }
    public String getRue(){
        return this.rue;
    }
    public String getVille(){
        return this.ville;
    }
    public int getCp(){
        return this.cp;
    }
    public Classification getClassification(){
        return this.classification;
    }

    public void setJournee(TempJournee journee){
        this.jounree=journee;
    }
    public void setRue(String rue){
        this.rue=rue;
    }
    public void setVille(String ville){
        this.ville=ville;
    }
    public void setCp(int cp){
        this.cp=cp;
    }
    public void setClassification(Classification c){
        this.classification=c;
    }

}
