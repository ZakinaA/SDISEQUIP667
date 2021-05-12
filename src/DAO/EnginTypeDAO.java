/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.EnginType;

/**
 *
 * @author ts1sio
 */
public class EnginTypeDAO {
     Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    

        public static EnginType getEnginById(Connection connection, int matricule){
            EnginType unEnginType = new EnginType();
            try {
                requete=connection.prepareStatement("SELECT * FROM ENFINTYPE WHERE ENGTYP_ID = ?");
                requete.setString(1, String.valueOf(matricule));

                //executer la reguete
                rs=requete.executeQuery();
                if (rs.next()){
                    unEnginType.setId(Integer.parseInt(rs.getString("ENGTYP_ID")));
                    unEnginType.setLibelle(rs.getString("ENGTYP_LIBELLE"));
                  
                }
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return unEnginType; 
        }
        
        public static String getEnginByLibelle(Connection connection, String name){
            EnginType unEnginType = new EnginType();
            try {
                requete=connection.prepareStatement("SELECT * FROM ENFINTYPE WHERE ENGTYP_LIBELLE = ?");
                requete.setString(1, String.valueOf(name));

                //executer la reguete
                rs=requete.executeQuery();
                if (rs.next()){
                    unEnginType.setId(Integer.parseInt(rs.getString("ENGTYP_ID")));
                    unEnginType.setLibelle(rs.getString("ENGTYP_LIBELLE"));
                  
                }
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return unEnginType.getLibelle(); 
        }   
        
        
        public static int AddTypeEngin(Connection connection, String libelle){
            int resultatUpdate = -1;
            try {
                requete = connection.prepareStatement("INSERT INTO ENGINTYPE(ENGTYP_LIBELLE) VALUES (?)");
                
                requete.setString(1, libelle);

                
                resultatUpdate = requete.executeUpdate();
                
                ConnexionBdd.fermerConnexion(rs);
                ConnexionBdd.fermerConnexion(requete);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultatUpdate;
        }
        
    
        
        
        
        
        
        public static int RemoveTypeEngin(Connection connection, int pPode){
            int resultatUpdate = -1;
            try {
                requete = connection.prepareStatement("DELETE FROM ENGINTYPE WHERE ENGTYP_ID = ?");
                
                requete.setString(1, String.valueOf(pPode));

                
                resultatUpdate = requete.executeUpdate();
                
                ConnexionBdd.fermerConnexion(rs);
                ConnexionBdd.fermerConnexion(requete);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultatUpdate;
        }
        
    public static ArrayList<EnginType> getLesTypes(Connection connection){
        
            ArrayList<EnginType> lesTypes = new ArrayList<EnginType>();


            try {
                requete=connection.prepareStatement("SELECT * FROM engintype");

                //executer la reguete
                rs=requete.executeQuery();
                while(rs.next()){
                    EnginType unType = new EnginType();
                    unType.setId(Integer.parseInt(rs.getString("ENGTYP_ID")));
                    unType.setLibelle(rs.getString("ENGTYP_LIBELLE"));
                    

                    lesTypes.add(unType);
                }
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return lesTypes; 
        }
        
        
}
