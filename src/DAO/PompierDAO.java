/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.EnginDAO.requete;
import static DAO.FonctionsDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Pompier;
import modele.Pompier;


/**
 *
 * @author ts1sio
 */
public class PompierDAO {
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    
    public static Pompier getPompier(Connection connection, int matricule){
        Pompier lePompier = new Pompier();
            try {
                requete=connection.prepareStatement("SELECT * FROM Pompier WHERE pom_id = ?");
                requete.setString(1, String.valueOf(matricule));
                

                rs=requete.executeQuery();
                if(rs.next()){
                   
                    lePompier.setPom_id(Integer.valueOf(rs.getString("pom_id")));
                    lePompier.setPom_prenom(rs.getString("pom_prenom"));
                    lePompier.setPom_nom(rs.getString("pom_nom"));
                    lePompier.setPom_dateNaissance(rs.getString("pom_datenaissance"));
                    lePompier.setPom_numeroBip(Integer.valueOf(rs.getString("pom_numerobip")));
                    lePompier.setPom_sexe(rs.getString("pom_sexe"));
                    lePompier.setPom_telephone(rs.getString("pom_telephone"));
                    
                }

                
                    
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return lePompier;
    
    }
    
    
    public static ArrayList<Pompier> getPompierByCaserne(Connection connection, int caserne){
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
            try {
                requete=connection.prepareStatement("SELECT * FROM Pompier WHERE cas_id = ?");
                requete.setString(1, String.valueOf(caserne));
                

                rs=requete.executeQuery();
                while(rs.next()){  
                    Pompier lePompier = new Pompier(); 
                    
                    lePompier.setPom_id(Integer.valueOf(rs.getString("pom_id")));
                    lePompier.setPom_prenom(rs.getString("pom_prenom"));
                    lePompier.setPom_nom(rs.getString("pom_nom"));
                    lePompier.setPom_dateNaissance(rs.getString("pom_datenaissance"));
                    lePompier.setPom_numeroBip(Integer.valueOf(rs.getString("pom_numerobip")));
                    lePompier.setPom_sexe(rs.getString("pom_sexe"));
                    lePompier.setPom_telephone(rs.getString("pom_telephone"));
                    
                    lesPompiers.add(lePompier);
                    
                }

                
                    
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return lesPompiers;
    
    }
    
    
        public static ArrayList<Pompier> getAllPompiers(Connection connection){
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
            try {
                requete=connection.prepareStatement("SELECT * FROM Pompier");
               
                rs=requete.executeQuery();
                while(rs.next()){  
                    Pompier lePompier = new Pompier(); 
                    
                    lePompier.setPom_id(Integer.valueOf(rs.getString("pom_id")));
                    lePompier.setPom_prenom(rs.getString("pom_prenom"));
                    lePompier.setPom_nom(rs.getString("pom_nom"));
                    lePompier.setPom_dateNaissance(rs.getString("pom_datenaissance"));
                    lePompier.setPom_numeroBip(Integer.valueOf(rs.getString("pom_numerobip")));
                    lePompier.setPom_sexe(rs.getString("pom_sexe"));
                    lePompier.setPom_telephone(rs.getString("pom_telephone"));
                    
                    lesPompiers.add(lePompier);
                    
                }

                
                    
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return lesPompiers;
    
    }
    
}
