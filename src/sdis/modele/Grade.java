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
public class Grade {
    private int id;
    private String libelle;
    private ArrayList<Pompier> lesPompiers ;

    //constructeur vide
    public Grade() {
    }

    //constructeur de la classe avec paramètres
    public Grade(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    
    
    
    
        //Récupérer les pompiers équivalent au grade
    public ArrayList<Pompier> getLesPompiers() {
        return lesPompiers;
    }
    
    
    public void setLesPompiers(ArrayList<Pompier> lesPompiers) {
        this.lesPompiers = lesPompiers;
    }

    
   //Ajouter un pompier à l'ArrayList lesPompiers
    public void addUnPompier(Pompier pUnPompier){
        if(lesPompiers == null){
            lesPompiers = new ArrayList<Pompier>();
        }
        lesPompiers.add(pUnPompier);
    }
    
    
    
    
    
    
    
    
    

    //getter de l'identifiant du grade
    public int getId() {
        return id;
    }

    //getter du libelle du grade
    public String getLibelle() {
        return libelle;
    }

    
    
    
    
    //setter de l'identifiant du grade
    public void setId(int id) {
        this.id = id;
    }

    //setter du libelle du grade
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
    
    
}
