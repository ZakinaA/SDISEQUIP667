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
public class Engin {
    //déclaration des propriétés
    private int id;
    private String libelle;
    private Caserne laCaserne;
    private EnginType leTypeEngin;
    
    private ArrayList<Intervention> lesInterventions;

    
    //constructeur vide
    public Engin() {
    }

    //constructeur de la classe
    public Engin(int id, String libelle, Caserne laCaserne) {
        this.id = id;
        this.libelle = libelle;
        this.laCaserne = laCaserne;
    }

    //Récupérer l'ID de l'engin
    public int getId() {
        return id;
    }

    //Récupérer le libellé de l'engin
    public String getLibelle() {
        return libelle;
    }

    
    //Récupérer la caserne respective
    public Caserne getLaCaserne() {
        return laCaserne;
    }

    //Récupérer le type d'engin
    public EnginType getLeTypeEngin() {
        return leTypeEngin;
    }

    //récupérer les interventions liées à l'engin
    public ArrayList<Intervention> getLesInterventions() {
        return lesInterventions;
    }

    
    
    
    
    
    //Setter de l'ID de l'engin
    public void setId(int id) {
        this.id = id;
    }

    //setter du libellé de l'engin
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    //setter de la caserne de l'engin
    public void setLaCaserne(Caserne laCaserne) {
        this.laCaserne = laCaserne;
    }

    //setter du type d'engin de l'engin
    public void setLeTypeEngin(EnginType leTypeEngin) {
        this.leTypeEngin = leTypeEngin;
    }

    //setter des interventions sur l'engin
    public void setLesInterventions(ArrayList<Intervention> lesInterventions) {
        this.lesInterventions = lesInterventions;
    }
    
    
    public void addUneIntervention(Intervention uneIntervention){
        if(lesInterventions == null){
            lesInterventions = new ArrayList<Intervention>();
        }
        
        lesInterventions.add(uneIntervention);
    }
    
}
