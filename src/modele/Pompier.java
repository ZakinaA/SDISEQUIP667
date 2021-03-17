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
public class Pompier {
    private int pom_id;
    private String pom_nom;
    private String pom_prenom;
    private String pom_dateNaissance;
    private int pom_numeroBip;
    private String pom_sexe;
    private String pom_telephone;
    private Pompier leResponsable;
    private Grade leGrade;
    
    
    private ArrayList<Fonction> lesFonctions ;
    private ArrayList<Compte> lesComptes ;
 

    
    //constructeur vide
    public Pompier() {
    }

    //constructeur de la classe pompier avec paramètres
    public Pompier(int pom_id, String pom_nom, String pom_prenom, String pom_dateNaissance, int pom_numeroBip, String pom_sexe, String pom_telephone) {
        this.pom_id = pom_id;
        this.pom_nom = pom_nom;
        this.pom_prenom = pom_prenom;
        this.pom_dateNaissance = pom_dateNaissance;
        this.pom_numeroBip = pom_numeroBip;
        this.pom_sexe = pom_sexe;
        this.pom_telephone = pom_telephone;
    }

    //getter ID du pompier
    public int getPom_id() {
        return pom_id;
    }

    //getter nom du pompier
    public String getPom_nom() {
        return pom_nom;
    }

    //getter prenom du pompier
    public String getPom_prenom() {
        return pom_prenom;
    }

    //getter date de naissance du pompier
    public String getPom_dateNaissance() {
        return pom_dateNaissance;
    }

    //getter numéro de bip du pompier
    public int getPom_numeroBip() {
        return pom_numeroBip;
    }

    //getter sexe du pompier
    public String getPom_sexe() {
        return pom_sexe;
    }
    
    //getter telephone du pompier
    public String getPom_telephone() {
        return pom_telephone;
    }

    //Récupérer le responsable du pompier en question
    public Pompier getLeResponsable() {
        return leResponsable;
    }

    //Récupérer le grade du pompier
    public Grade getLeGrade() {
        return leGrade;
    }
    

    
    
    
    

    //récupérer les fonctions d'un pompier
    public ArrayList<Fonction> getLesFonctions() {
        return lesFonctions;
    }

    public void setLesFonctions(ArrayList<Fonction> lesFonctions) {
        this.lesFonctions = lesFonctions;
    }
    
    //Ajouter une fonction à un pompier
    public void addUneFonction(Fonction pLaFonction){
        if(lesFonctions == null){
            lesFonctions = new ArrayList<Fonction>();
        }
    }
    
    
    
    
        //récupérer les comptes d'un pompier
    public ArrayList<Compte> getLesComptes() {
        return lesComptes;
    }

    public void setLesComptes(ArrayList<Compte> lesComptes) {
        this.lesComptes = lesComptes;
    }
    
    //Ajouter une fonction à un pompier
    public void addUnCompte(Compte pLeCompte){
        if(lesComptes == null){
            lesComptes = new ArrayList<Compte>();
        }
    }
    

    
    
    
    
    //setter id du pompier
    public void setPom_id(int pom_id) {
        this.pom_id = pom_id;
    }

    //setter nom du pompier
    public void setPom_nom(String pom_nom) {
        this.pom_nom = pom_nom;
    }

    //setter prenom du pompier
    public void setPom_prenom(String pom_prenom) {
        this.pom_prenom = pom_prenom;
    }

    //setter date de naissance du pompier
    public void setPom_dateNaissance(String pom_dateNaissance) {
        this.pom_dateNaissance = pom_dateNaissance;
    }

    //setter numéro de bip du pompier
    public void setPom_numeroBip(int pom_numeroBip) {
        this.pom_numeroBip = pom_numeroBip;
    }

    //setter sexe du pompier
    public void setPom_sexe(String pom_sexe) {
        this.pom_sexe = pom_sexe;
    }

    //setter telephone du pompier
    public void setPom_telephone(String pom_telephone) {
        this.pom_telephone = pom_telephone;
    }

    //setter responsable du pompier
    public void setLeResponsable(Pompier leResponsable) {
        this.leResponsable = leResponsable;
    }

    //setter du grade du pompier
    public void setLeGrade(Grade leGrade) {
        this.leGrade = leGrade;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
