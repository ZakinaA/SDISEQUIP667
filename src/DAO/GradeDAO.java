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
import modele.Grade;
import modele.Volontaire;



/**
 *
 * @author ts1sio
 */
public class GradeDAO {
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    
    public static Grade getGrade(Connection connection, int grade){
        Grade leGrade = new Grade();
            try {
                requete=connection.prepareStatement("SELECT * FROM grade WHERE gra_id = ?");
                System.out.print(grade);
                requete.setString(1, String.valueOf(grade));
                

                rs=requete.executeQuery();
                if(rs.next()){               
                    
                    leGrade.setId(Integer.valueOf(rs.getString("gra_id")));
                    leGrade.setLibelle(rs.getString("gra_libelle")); 
                    
                }
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return leGrade;
    
    }
    
}
