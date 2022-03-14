package com.example.accessingdatajpa;
import com.example.accessingdatajpa.AllEnums.Etat;

public class Bornette {
    
    private int numero;
    private Etat etatB;

    Bornette(int numero,Etat etat){
        this.numero=numero;
        this.etatB=etat;
    }

    public void setNumero(int numero){
        this.numero=numero;
    }
    public void setEtat(Etat etatB){
        this.etatB=etatB;
    }

    public int getNumero(){
        return this.numero;
    }

    public Etat getEtat(){
        return this.etatB;
    }

    
}
