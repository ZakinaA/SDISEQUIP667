/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.EnginDAO.requete;
import static DAO.ProfessionnelDAO.requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Profession;
import modele.Volontaire;



/**
 *
 * @author ts1sio
 */
public class VolontaireDAO {
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    
    public static Volontaire getVolontaire(Connection connection, int matricule){
        Volontaire leVolontaire = new Volontaire();
            try {
                requete=connection.prepareStatement("SELECT * FROM volontaire WHERE pom_id = ?");
                requete.setString(1, String.valueOf(matricule));
                

                rs=requete.executeQuery();
                if(rs.next()){               
                    
                    leVolontaire.setLeMatricule(Integer.valueOf(rs.getString("pom_id")));
                    leVolontaire.setLeProfessionId(Integer.valueOf(rs.getString("pro_id"))); 
                    
                }
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return leVolontaire;
    
    }
    
        public static int isVolontaire(Connection connection, int matricule){
        Volontaire leVolontaire = new Volontaire();
        int laRep = 0;
            try {
                requete=connection.prepareStatement("SELECT * FROM volontaire WHERE pom_id = ?");
                requete.setString(1, String.valueOf(matricule));
                

                rs=requete.executeQuery();
                if(rs.next()){                        
                   laRep = 1;         
                }
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return laRep;
    
    }
        
    public static int AddVolontaire(Connection connection, Profession profession, int id){
            //Caserne uneCaserne = new Caserne();
            //ArrayList<Intervention> lesInterventions = null;
            
            int resultatUpdate = -1;
            try {
                requete=connection.prepareStatement("INSERT INTO profession(PRO_LIBELLE, PRO_VILLE) VALUES ( ?, ?) INSERT INTO volontaire (POM_ID, PRO_ID) VALUES ( ?, LAST_INSERT_ID() )");
                requete.setString(1, String.valueOf(profession.getPro_libelle()));
                requete.setString(2, String.valueOf(profession.getPro_ville()));
                requete.setInt(3, id);


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
