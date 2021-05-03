/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author ts1sio
 */
public class Professionnel extends Pompier {
    private int matricule;
    private String indiceTraitement;
    private String dateObtention;
    
    
    // Constructeur Vide
    public Professionnel(){
        super();
    }
    
    public Professionnel(int pMatricule, String pindiceTraitement, String pdateObtention){
        super();
        this.matricule = pMatricule;
        this.indiceTraitement = pindiceTraitement;
        this.dateObtention = pdateObtention;
    }
    
    
    //GETTERS
    public int getMatricule() {
        return matricule;
    }

    public String getIndiceTraitement() {
        return indiceTraitement;
    }

    public String getDateObtention() {
        return dateObtention;
    }
    
    
    
    
    //SETTERS
    public void setLeMatricule(int pMatricule) {
        this.matricule = pMatricule;
    }

    public void setIndiceTraitement(String indiceTraitement) {
        this.indiceTraitement = indiceTraitement;
    }

    public void setDateObtention(String dateObtention) {
        this.dateObtention = dateObtention;
    }

    
    
    
    
}
