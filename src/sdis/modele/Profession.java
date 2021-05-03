/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class Profession {
  
    // déclaration des propriétés
    private int pro_id;
    private String pro_libelle;
    private String pro_ville;
    private ArrayList<Volontaire> lesVolontaires ;
    
    
    // Constructeur Vide
    public Profession(){
    }
    // Constructeur
    public Profession(int pro_id, String pro_libelle, String pro_ville) {
        this.pro_id = pro_id;
        this.pro_libelle = pro_libelle;
        this.pro_ville = pro_ville;
    }
    
    
    
    
    // Getter de l'I
    public int getPro_id() {
        return pro_id;
    }

    public String getPro_libelle() {
        return pro_libelle;
    }

    public String getPro_ville() {
        return pro_ville;
    }
    public ArrayList<Volontaire> getLesVolontaires() {
        return lesVolontaires;
    }
    
    
    
    
    
    
    // Setter
    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public void setPro_libelle(String pro_libelle) {
        this.pro_libelle = pro_libelle;
    }

    public void setPro_ville(String pro_ville) {
        this.pro_ville = pro_ville;
    }
    
    public void setLesVolontaires(ArrayList<Volontaire> lesVolontaires) {
        this.lesVolontaires = lesVolontaires;
    }
    
    
    
    
    //Fonctions Additionnelles :
    public void addUnVolontaire(Volontaire pUnVolontaire){
        if(lesVolontaires == null){
            lesVolontaires = new ArrayList<Volontaire>();
        }
        lesVolontaires.add(pUnVolontaire);
    }
    
}
