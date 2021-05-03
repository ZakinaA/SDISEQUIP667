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
import modele.Profession;
import modele.Professionnel;



/**
 *
 * @author ts1sio
 */
public class ProfessionDAO {
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    
    public static Profession getProfession(Connection connection, int professionId){
        Profession laProfession = new Profession();
            try {
                requete=connection.prepareStatement("SELECT * FROM profession WHERE pro_id = ?");
                requete.setString(1, String.valueOf(professionId));
                

                rs=requete.executeQuery();
                if(rs.next()){               
                    
                    laProfession.setPro_id(Integer.valueOf(rs.getString("pro_id")));
                    laProfession.setPro_libelle(rs.getString("pro_libelle"));
                    laProfession.setPro_ville(rs.getString("pro_ville"));
                    
                }
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return laProfession;
    
    }
    
}
