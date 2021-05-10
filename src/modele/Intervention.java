/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Florian ROUSSEAU
 * Crée le 10/03/2021
 * Modifié le 10/03/2021
 */
public class Intervention {
    private int id;
    private String adresse;
    private String cp;
    private String ville;
    private Date date;
    private Time heureAppel;
    private Time duree;
    private Type unTypeIntervention; 
    
    
    private ArrayList<Engin> lesEngins;
    private ArrayList<Pompier> lesPompiers;
    
    


    public Intervention() {
    }

    public Intervention(int id, String adresse, String cp, String ville, Date date, Time heureAppel, Time duree) {
        this.id = id;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.date = date;
        this.heureAppel = heureAppel;
        this.duree = duree;
    }

    public int getId() {
        return id;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCp() {
        return cp;
    }

    public String getVille() {
        return ville;
    }

    public Date getDate() {
        return date;
    }

    public Time getHeureAppel() {
        return heureAppel;
    }

    public Time getDuree() {
        return duree;
    }

    public ArrayList<Engin> getLesEngins() {
        return lesEngins;
    }

    public Type getUnTypeIntervention() {
        return unTypeIntervention;
    }
    
   
    
    
    
    
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeureAppel(Time heureAppel) {
        this.heureAppel = heureAppel;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public void setLesEngins(ArrayList<Engin> lesEngins) {
        this.lesEngins = lesEngins;
    }

    public void setUnTypeIntervention(Type unTypeIntervention) {
        this.unTypeIntervention = unTypeIntervention;
    }
    
    
    
    
    
    
    
    public void addUnEngin(Engin unEngin){
        if(lesEngins == null){
            lesEngins = new ArrayList<Engin>();
        }
        lesEngins.add(unEngin);
    }
    
       public void addUnPompier(Pompier unPompier){
        if(lesPompiers == null){
            lesPompiers = new ArrayList<Pompier>();
        }
        lesPompiers.add(unPompier);
    }
    
}
