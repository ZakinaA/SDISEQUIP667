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
import modele.Pompier;


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
                requete=connection.prepareStatement("SELECT * FROM COMPTE, POMPIER WHERE compte.pom_id = pom_id AND compte.pom_id = ? AND com_mdp = ?");
                requete.setString(1, String.valueOf(matricule));
                requete.setString(2, mdp);
                
                
                
                
                rs=requete.executeQuery();
                if(rs.next()){
                    Pompier lePompier = new Pompier();
                    
                    lePompier.setPom_id(Integer.valueOf(rs.getString("pom_id")));
                    leCompte.setId(Integer.valueOf(rs.getString("COM_ID")));
                    leCompte.setLePompier(lePompier);
                    leCompte.setMdp(rs.getString("com_mdp"));
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
                 boolean isAdmin = pCompte.isAdmin();
                requete.setString(3, String.valueOf(isAdmin));
                
                
                resultInsert = requete.executeUpdate();
                    
                   
                    
                   
                   
                    
                

                
                    
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return resultInsert;
    
    }
    
    
}
