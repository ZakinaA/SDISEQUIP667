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
import modele.Professionnel;



/**
 *
 * @author ts1sio
 */
public class ProfessionnelDAO {
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    
    public static Professionnel getProfessionnel(Connection connection, int matricule){
        Professionnel leProfessionnel = new Professionnel();
            try {
                requete=connection.prepareStatement("SELECT * FROM professionnel WHERE pom_id = ?");
                requete.setString(1, String.valueOf(matricule));
                

                rs=requete.executeQuery();
                if(rs.next()){               
                    
                    leProfessionnel.setLeMatricule(Integer.valueOf(rs.getString("pom_id")));
                    leProfessionnel.setDateObtention(rs.getString("pro_indicetraitement"));
                    leProfessionnel.setIndiceTraitement(rs.getString("pro_dateobtentionindice"));
                    
                }
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return leProfessionnel;
    
    }
    
}
