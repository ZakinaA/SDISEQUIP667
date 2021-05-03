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
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Compte;
import modele.Grade;
import modele.Pompier;
import modele.Caserne;


/**
 *
 * @author ts1sio
 */
public class CompteDAO {
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    
    public static Compte getCompte(Connection connection, int matricule, String mdp){
        Compte leCompte = new Compte();
            try {
                requete=connection.prepareStatement("SELECT * FROM COMPTE, GRADE, POMPIER, CASERNE WHERE compte.pom_id = ? and pompier.pom_id = ? and compte.com_mdp = ? ORDER BY compte.pom_id LIMIT 1");
                requete.setString(1, String.valueOf(matricule));
                requete.setString(2, String.valueOf(matricule));
                requete.setString(3, mdp);
                              
                rs=requete.executeQuery();
                
                if(rs.next()){
                    Pompier lePompier = new Pompier();
                    Grade leGrade = new Grade();
                    Caserne laCaserne = new Caserne();
                    
                    //SET COMPTE 
                    leCompte.setId(Integer.valueOf(rs.getString("pom_id")));
                    leCompte.setLePompier(lePompier);
                    leCompte.setMdp(rs.getString("com_mdp"));
                    leCompte.setLeType(rs.getString("com_type"));
                    
                    //SET POMPIER         
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
                    leCompte.setLePompier(lePompier);
                    lePompier.setLeGrade(leGrade);
                    lePompier.setLaCaserne(laCaserne);

                }

                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return leCompte;
    
    }
    
    
        public static int AddCompte(Connection connection, Compte pCompte){

            int resultInsert = -1;
            try {
                requete=connection.prepareStatement("INSERT INTO COMPTE (POM_ID, COM_MDP, COM_ISADMIN) VALUES (?, ?, ?)" );
                requete.setString(1, String.valueOf(pCompte.getLePompier().getPom_id()));
                requete.setString(2, pCompte.getMdp());
                
                Pompier lePompier = new Pompier();
                 String leType = pCompte.getLeType();
                requete.setString(3, leType);
                
                
                resultInsert = requete.executeUpdate();
                    
                   
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return resultInsert;
    
    }
    
    
}
