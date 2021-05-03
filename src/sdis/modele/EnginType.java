/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 * @author Florian ROUSSEAU
 * Crée le 10/03/2021
 * Modifié le 10/03/2021
 */
public class EnginType {
    private int id;
    private String libelle;
    
    private ArrayList<Engin> lesEngins;

    public EnginType() {
    }

    public EnginType(int id, String libelle, ArrayList<Engin> lesEngins) {
        this.id = id;
        this.libelle = libelle;
        this.lesEngins = lesEngins;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public ArrayList<Engin> getLesEngins() {
        return lesEngins;
    }

    
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLesEngins(ArrayList<Engin> lesEngins) {
        this.lesEngins = lesEngins;
    }
    
    
    
    public void addUnEngin(Engin unEngin){
        if(lesEngins == null){
            lesEngins = new ArrayList<Engin>();
        }
        lesEngins.add(unEngin);
    }
    
    
}
