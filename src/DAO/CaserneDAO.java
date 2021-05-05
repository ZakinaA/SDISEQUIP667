/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Caserne;
import modele.Engin;
import modele.Intervention;
import modele.Pompier;

/**
 *
 * @author ts1sio
 */
public class CaserneDAO {
    
    

    
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;

    public static int AddCaserne(Connection connection, Caserne caserne){
            //Caserne uneCaserne = new Caserne();
            //ArrayList<Intervention> lesInterventions = null;
            
            int resultatUpdate = -1;
            try {
                requete=connection.prepareStatement("INSERT INTO CASERNE ( CAS_NOM, CAS_RUE, CAS_CP, CAS_VILLE) VALUES ( ?, ?, ?, ?)");
                requete.setString(1, String.valueOf(caserne.getNom()));
                requete.setString(2, String.valueOf(caserne.getRue()));
                requete.setString(3, String.valueOf(caserne.getCp()));
                requete.setString(4, String.valueOf(caserne.getVille()));

                //executer la reguete
                resultatUpdate = requete.executeUpdate();
                
                ConnexionBdd.fermerConnexion(rs);
                ConnexionBdd.fermerConnexion(requete); 
                
            }catch (SQLException e){
                e.printStackTrace();
            }

            return resultatUpdate; 
        }    
        
    public static Caserne getCaserneById(Connection connection, int pCode){
            Caserne uneCaserne = new Caserne();
            ArrayList<Pompier> lesPompiers = null;
            ArrayList<Engin> lesEngins = null;
            ArrayList<Intervention> lesInterventions = null;

            try {
                requete=connection.prepareStatement("SELECT * FROM CASERNE WHERE CAS_ID = ?");
                requete.setString(1, String.valueOf(pCode));

                //executer la reguete
                rs=requete.executeQuery();
                if (rs.next()){
                    uneCaserne.setId(Integer.parseInt(rs.getString("CAS_ID")));
                    uneCaserne.setNom(rs.getString("CAS_NOM"));
                    uneCaserne.setRue(rs.getString("CAS_RUE"));
                    uneCaserne.setCp(rs.getString("CAS_CP"));
                    uneCaserne.setVille(rs.getString("CAS_VILLE"));
                    

                    
                }
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return uneCaserne; 
        }
        

        public static ArrayList<Caserne> getLesCasernes(Connection connection){
        
            ArrayList<Caserne> lesCasernes = null;


            try {
                requete=connection.prepareStatement("SELECT * FROM CASERNE");

                //executer la reguete
                rs=requete.executeQuery();
                while(rs.next()){
                    Caserne uneCaserne = new Caserne();
                    uneCaserne.setId(Integer.parseInt(rs.getString("CAS_ID")));
                    uneCaserne.setNom(rs.getString("CAS_NOM"));
                    uneCaserne.setRue(rs.getString("CAS_RUE"));
                    uneCaserne.setCp(rs.getString("CAS_CP"));
                    uneCaserne.setVille(rs.getString("CAS_VILLE"));
                    

                    lesCasernes.add(uneCaserne);
                }
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return lesCasernes; 
        }
        
}