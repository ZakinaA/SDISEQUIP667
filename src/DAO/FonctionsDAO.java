/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.EnginDAO.requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Fonction;
import modele.Grade;
import modele.Volontaire;



/**
 *
 * @author ts1sio
 */
public class FonctionsDAO {
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    
    public static ArrayList<Fonction> getFonctions(Connection connection, int matricule){
            
        ArrayList<Fonction> lesFonctions = new ArrayList<Fonction>();
            try {
                requete=connection.prepareStatement("SELECT * from assumer, fonction where assumer.pom_id = ? and assumer.FON_ID = fonction.FON_ID ");
                requete.setString(1, String.valueOf(matricule));
                
                rs=requete.executeQuery();
                while(rs.next()){               
                    Fonction laFonction = new Fonction();
                    laFonction.setId(Integer.valueOf(rs.getString("fon_id")));
                    laFonction.setLibelle(rs.getString("fon_libelle"));

                    lesFonctions.add(laFonction);
                }
                
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return lesFonctions;
    
    }
    
}
