/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Engin;
import modele.Intervention;
import modele.Pompier;

/**
 *
 * @author ts1sio
 */
public class interventionDAO {
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    
    
    public static ArrayList<Intervention> getIntervention(Connection connection){

        ArrayList<Intervention> lesInterventions = null;
        ArrayList<Pompier> lesPompiers = null;
        ArrayList<Engin> lesEngins = null;
        try {
            requete=connection.prepareStatement("SELECT * FROM INTERVENTION" );
                

            
                
                    
                   
                    
                   
                   
                    
                

                
                    
                
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete); 
        }catch (SQLException e){
            e.printStackTrace();
        }

        return lesInterventions;
    
    }
    
    
}
