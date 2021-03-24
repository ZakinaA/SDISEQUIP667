/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


/**
 * @author Florian ROUSSEAU
 * Crée le 10/03/2021
 * Modifié le 10/03/2021
 */
public class Compte {
    
    private int id;
    private String mdp;
    private Pompier lePompier;
    private Boolean isAdmin;

    //constructeur de la classe avec paramètre
    public Compte(int id, String mdp) {
        this.id = id;
        this.mdp = mdp;
    }
    
    //constructeur vide
    public Compte() {

    }
    
    
    //getter de l'ID du compte
    public int getId() {
        return id;
    }
    
    //getter du mot de passe du compte
    public String getMdp() {
        return mdp;
    }

    //getter du pompier
    public Pompier getLePompier() {
        return lePompier;
    }

    
        //getter du pompier
    public Boolean isAdmin() {
        return isAdmin;
    }
    
    
    
    //setter de l'ID du compte
    public void setId(int id) {
        this.id = id;
    }

    //setter du mot de passe du compte
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    //setter du pompier
    public void setLePompier(Pompier lePompier) {
        this.lePompier = lePompier;
    }
    
    
    public void setAdmin(Boolean bool) {
        this.isAdmin = bool;
    }
    
    
    
    
}
