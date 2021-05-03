/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author Florian ROUSSEAU
 * Crée le 10/03/2021
 * Modifié le 10/03/2021
 */
public class Fonction {
    
    //définition des propriétés de la classe
    private int id;
    private String libelle;
    
    private ArrayList<Pompier> lesPompiers ;

    //constructeur de la classe vide
    public Fonction() {
    }

    //Constructeur principal
    public Fonction(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    //getter ID de la fonction
    public int getId() {
        return id;
    }

    //getter Libelle de la fonction
    public String getLibelle() {
        return libelle;
    }

    //Récupérer les pompiers de la fonction
    public ArrayList<Pompier> getLesPompiers() {
        return lesPompiers;
    }
    
    
    public void setLesPompiers(ArrayList<Pompier> lesPompiers) {
        this.lesPompiers = lesPompiers;
    }

    
   //Ajouter un salarié à l'ArrayList lesPompiers
    public void addUnPompier(Pompier pUnPompier){
        if(lesPompiers == null){
            lesPompiers = new ArrayList<Pompier>();
        }
        lesPompiers.add(pUnPompier);
    }
    
    
    
    
    
    
    
    
    

    //setter ID de la fonction
    public void setId(int id) {
        this.id = id;
    }

    //setter Libelle de la fonction
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
