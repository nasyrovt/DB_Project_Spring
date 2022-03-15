package JavaClasses;

import java.time.LocalDateTime;

class Location{
    private LocalDateTime heureDepart;
    private LocalDateTime heureArivee;
    private int idStationA;
    private int idStationB;
    private LocalDateTime dateLocation;//date de location d'un velo par une personne (pas besoin)


    Location(LocalDateTime heureDepart,LocalDateTime heureArivee,int idStationA,int idStationB,LocalDateTime dateLocation){
        this.heureDepart=heureDepart;
        this.heureArivee=heureArivee;
        this.dateLocation=dateLocation;
        this.idStationA=idStationA;
        this.idStationB=idStationB;

    }
    public LocalDateTime getHeureDepart(){
        return this.heureDepart;
    }
    public LocalDateTime getHeureArivee(){
        return this.heureArivee;
    }
    public LocalDateTime getDateLocation(){
        return this.dateLocation;
    }
    public int getIdStationA(){
        return this.idStationA;
    }
    public int getIdStationB(){
        return this.idStationB;
    }
    public void setIdStationA(int idA){
        this.idStationA=idA;
    }
    public void setIdStationB(int idB){
        this.idStationB=idB;
    }
    public void setDateLocation(LocalDateTime date){
        this.dateLocation=date;
    }
    public void setHeureDepart(LocalDateTime date){
        this.heureDepart=date;
    }
    public void setHeureArivee(LocalDateTime date){
        this.heureArivee=date;
    }
    
}