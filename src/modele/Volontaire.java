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
    
    private Profession laProfession;
    
    // Constructeur Vide
    public Volontaire(){
        super();
    }
    
    
    
    //GETTERS
    public Profession getLaProfession() {
        return laProfession;
    }
    
    
    
    //SETTERS
    public void setLaProfession(Profession laProfession) {
        this.laProfession = laProfession;
    }
    
    
    
}
