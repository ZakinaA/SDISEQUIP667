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
    
        public static Grade getGradeByLibelle(Connection connection, String grade){
        Grade leGrade = new Grade();
            try {
                requete=connection.prepareStatement("SELECT * FROM grade WHERE gra_libelle = ?");
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
    
     public static ArrayList<Grade> getLesGrades(Connection connection){
        
            ArrayList<Grade> lesGrades = new ArrayList<Grade>();


            try {
                requete=connection.prepareStatement("SELECT * FROM Grade");

                //executer la reguete
                rs=requete.executeQuery();
                while(rs.next()){
                    Grade unGrade = new Grade();
                    unGrade.setId(Integer.parseInt(rs.getString("GRA_ID")));
                    unGrade.setLibelle(rs.getString("GRA_LIBELLE"));
                    

                    lesGrades.add(unGrade);
                }
                    ConnexionBdd.fermerConnexion(rs);
            }catch (SQLException e){
                e.printStackTrace();
            }

            return lesGrades; 
        }
    
}
