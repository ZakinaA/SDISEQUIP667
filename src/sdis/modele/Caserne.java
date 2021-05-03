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
public class Caserne {
    private int id;
    private String rue;
    private String nom;
    private String cp;
    private String ville;
    
    private ArrayList<Pompier> lesPompiersDelaCaserne;
    private ArrayList<Engin> lesEngins;

    
    //Constructeur de la classe avec paramètres
    public Caserne(int id, String rue, String nom, String cp, String ville, ArrayList<Pompier> lesPompiersDelaCaserne) {
        this.id = id;
        this.rue = rue;
        this.nom = nom;
        this.cp = cp;
        this.ville = ville;
        this.lesPompiersDelaCaserne = lesPompiersDelaCaserne;
    }

    public Caserne() {
    }
    
    
    

    //Récupérer l'ID de la caserne
    public int getId() {
        return id;
    }

    //Récupérer le nom de la caserne
    public String getRue() {
        return rue;
    }

    //Récupérer le prénom de la caserne
    public String getNom() {
        return nom;
    }

    //Récupérer le nom de la caserne
    public String getCp() {
        return cp;
    }

    //Récupérer la ville de la caserne
    public String getVille() {
        return ville;
    }

    //Récupérer les pompiers de la caserne
    public ArrayList<Pompier> getLesPompiersDelaCaserne() {
        return lesPompiersDelaCaserne;
    }

    //Récupérer les engins de la caserne
    public ArrayList<Engin> getLesEngins() {
        return lesEngins;
    }

    
    
    
    
    //Setter de l'ID de la caserne
    public void setId(int id) {
        this.id = id;
    }

    //Setter de la rue de la caserne
    public void setRue(String rue) {
        this.rue = rue;
    }

    
    //Setter du nom de la caserne
    public void setNom(String nom) {
        this.nom = nom;
    }

    //Setter du prénom de la caserne
    public void setCp(String cp) {
        this.cp = cp;
    }

    //Setter de la ville de la caserne
    public void setVille(String ville) {
        this.ville = ville;
    }

    //Setter des pompiers  de la caserne
    public void setLesPompiersDelaCaserne(ArrayList<Pompier> lesPompiersDelaCaserne) {
        this.lesPompiersDelaCaserne = lesPompiersDelaCaserne;
    }

    //Setter des engins de la caserne
    public void setLesEngins(ArrayList<Engin> lesEngins) {
        this.lesEngins = lesEngins;
    }
    
    
    
    
    
    //Ajouter un pompier à la caserne
    public void addUnPompier(Pompier lePompier){
        if(lesPompiersDelaCaserne == null){
            lesPompiersDelaCaserne = new ArrayList<Pompier>();
        }
        
        lesPompiersDelaCaserne.add(lePompier);
    }
    
    
    
    //Ajouter un engin à la caserne
    public void addUnEngin(Engin unEngin){
        if(lesEngins == null){
            lesEngins = new ArrayList<Engin>();
        }
        
        lesEngins.add(unEngin);
    }
    
    
    
    
    
    
    
}
