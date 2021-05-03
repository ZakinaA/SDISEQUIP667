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
public class Volontaire extends Pompier {
    private int matricule;
    private int professionId;
    private Profession laProfession;
    
    // Constructeur Vide
    public Volontaire(){
        super();
    }
    
    public Volontaire(int pMatricule, int pProfessionId){
        super();
        this.matricule = pMatricule;
        this.professionId = pProfessionId;
    }
    
    
    
    //GETTERS
    public int getMatricule() {
        return matricule;
    }
    
    public int getProfessionId() {
        return professionId;
    }
    
    public Profession getLaProfession() {
        return laProfession;
    }
    
    
    
    //SETTERS
    public void setLaProfession(Profession laProfession) {
        this.laProfession = laProfession;
    }
    public void setLeMatricule(int pMatricule) {
        this.matricule = pMatricule;
    }
    public void setLeProfessionId(int pProfessionId) {
        this.professionId = pProfessionId;
    }
    
    
    
}
