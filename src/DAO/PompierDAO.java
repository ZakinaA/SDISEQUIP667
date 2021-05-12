/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.CaserneDAO.requete;
import static DAO.CompteDAO.rs;
import static DAO.EnginDAO.requete;
import static DAO.FonctionsDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Caserne;
import modele.Grade;
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
        Grade leGrade = new Grade();
        Caserne laCaserne = new Caserne();
            try {
                requete=connection.prepareStatement("SELECT * FROM GRADE, POMPIER, CASERNE WHERE pompier.pom_id = ? ORDER BY pompier.pom_id LIMIT 1");
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
                    
                    //SET CASERNE 
                    laCaserne.setId(Integer.valueOf(rs.getString("cas_id")));
                    laCaserne.setNom(rs.getString("cas_nom"));
                    laCaserne.setRue(rs.getString("cas_rue"));
                    laCaserne.setCp(rs.getString("cas_CP"));
                    laCaserne.setVille(rs.getString("cas_ville"));
                    
                    //SET GRADE
                    leGrade.setId(Integer.valueOf(rs.getString("gra_id")));
                    leGrade.setLibelle(rs.getString("gra_libelle"));

                    //SET ITEMS
                    lePompier.setLeGrade(leGrade);
                    lePompier.setLaCaserne(laCaserne);
                    
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
        
    public static int AddPompier(Connection connection, Pompier pompier){
            
            int resultatUpdate = -1;
            try {
                requete=connection.prepareStatement("INSERT INTO POMPIER ( POM_NOM,POM_PRENOM,POM_DATENAISSANCE, POM_NUMEROBIP, POM_SEXE, POM_TELEPHONE, GRA_ID, CAS_ID) VALUES ( ?, ?, ?, ?,?,?,?,?)");
                requete.setString(1, String.valueOf(pompier.getPom_nom()));
                requete.setString(2, String.valueOf(pompier.getPom_prenom()));
                requete.setString(3, String.valueOf(pompier.getPom_dateNaissance()));
                requete.setInt(4, pompier.getPom_numeroBip());
                requete.setString(5, String.valueOf(pompier.getPom_telephone()));
                requete.setString(6, String.valueOf(pompier.getPom_sexe()));
                requete.setInt(7, pompier.getLeGrade().getId());
                requete.setInt(8, pompier.getLaCaserne().getId());
                

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
