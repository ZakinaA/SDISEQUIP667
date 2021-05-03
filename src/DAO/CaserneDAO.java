/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Caserne;
import modele.Engin;
import modele.Pompier;

/**
 *
 * @author ts1sio
 */
public class CaserneDAO {

    
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;

    public static int AddCaserne(Connection connection, Caserne caserne){
            //Caserne uneCaserne = new Caserne();
            //ArrayList<Intervention> lesInterventions = null;
            
            int resultatUpdate = -1;
            try {
                requete=connection.prepareStatement("INSERT INTO CASERNE ( CAS_NOM, CAS_RUE, CAS_CP, CAS_VILLE) VALUES ( ?, ?, ?, ?)");
                requete.setString(1, String.valueOf(caserne.getNom()));
                requete.setString(2, String.valueOf(caserne.getRue()));
                requete.setString(3, String.valueOf(caserne.getCp()));
                requete.setString(4, String.valueOf(caserne.getVille()));

                //executer la reguete
                resultatUpdate = requete.executeUpdate();
                
                ConnexionBdd.fermerConnexion(rs);
                ConnexionBdd.fermerConnexion(requete); 
                
            }catch (SQLException e){
                e.printStackTrace();
            }

            return resultatUpdate; 
        }    
        
        
        
}
