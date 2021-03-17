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
public class Type {
    private int id;
    private String libelle;
    
    private ArrayList<Intervention> lesInterventions;

    public Type() {
    }

    public Type(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public ArrayList<Intervention> getLesInterventions() {
        return lesInterventions;
    }
    
    
    
    
    
    
    
    //Setter de l'ID

    public void setId(int id) {
        this.id = id;
    }
    
    //Setter du libellé
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    //Ajouter les intervention
    public void setLesInterventions(ArrayList<Intervention> lesInterventions) {
        this.lesInterventions = lesInterventions;
    }
    
    
    
    //Ajouter une intervention
    
    public void addUneIntervention(Intervention uneIntervention){
        if(lesInterventions == null){
            lesInterventions = new ArrayList<Intervention>();
        }
    }
    
    
    
    
}
