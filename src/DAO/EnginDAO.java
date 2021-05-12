/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.CaserneDAO.requete;
import static DAO.EnginTypeDAO.requete;
import static DAO.interventionDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import modele.Caserne;
import modele.Engin;
import modele.EnginType;
import modele.Intervention;

/**
 *
 * @author ts1sio
 */
public class EnginDAO {

    
    Connection connection=null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;

        public static Engin getEnginById(Connection connection, int pCode){
            Engin unEngin = new Engin();
            ArrayList<Intervention> lesInterventions = null;

            try {
                requete=connection.prepareStatement("SELECT * FROM ENGIN WHERE ENG_ID = ENGTYP_ID"
                        + "AND CAS_ID = CAS_ID"
                        + "AND ENG_ID = ?");
                requete.setString(1, String.valueOf(pCode));

                //executer la reguete
                rs=requete.executeQuery();
                if (rs.next()){
                    unEngin.setId(Integer.parseInt(rs.getString("ENG_ID")));
                    unEngin.setLibelle(rs.getString("ENG_LIBELLE"));
                    
                    Caserne laCaserne = new Caserne();
                    laCaserne.setId(Integer.parseInt(rs.getString("cas_id")));
                                       
                    EnginType enginType = new EnginType();
                    enginType.setId(Integer.parseInt(rs.getString("engtyp_id")));
                    enginType.setLibelle(rs.getString("engtyp_libelle"));
                    
                    
                    unEngin.setLaCaserne(laCaserne);
                    unEngin.setLeTypeEngin(enginType);
                    
                    

                    requete=connection.prepareStatement("SELECT * FROM INTERVENTION, NECESSITER, ENGIN, type WHERE INT_ID = NEC_INT_ID"
                        + "AND NEC_ENG_ID = ENG_ID"
                        + "AND INT_TYP_ID = TYP_ID"
                        + "AND ENG_ID = ?");
                       
                   requete.setString(1, String.valueOf(pCode));
                   
                   rs=requete.executeQuery();
                   
                   if(rs.next()){
                       Intervention uneIntervention = new Intervention();
                       uneIntervention.setId(Integer.parseInt(rs.getString("int_id")));
                       uneIntervention.setDuree(rs.getTime("int_duree"));
                       uneIntervention.setAdresse(rs.getString("int_lieu"));
                       uneIntervention.setCp(rs.getString("int_cp"));
                       uneIntervention.setVille(rs.getString("int_ville"));
                       uneIntervention.setHeureAppel(rs.getTime("int_heureappel"));
                       uneIntervention.setDate(rs.getDate("int_date"));
                       
                       
                       lesInterventions.add(uneIntervention);
                   }
                    
                }
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return unEngin; 
        }
        
        
        
        
        public static int RemoveEnginById(Connection connection, int pCode){
            Engin unEngin = new Engin();
            ArrayList<Intervention> lesInterventions = null;

            
            int resultatUpdate = -1;
            try {
                requete=connection.prepareStatement("DELETE FROM ENGIN WHERE ENG_ID = ?");
                requete.setString(1, String.valueOf(pCode));

                //executer la reguete
                resultatUpdate = requete.executeUpdate();
                
                    
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return resultatUpdate; 
        }
        
    public static int AddEngin(Connection connection, Engin engin){
            Engin unEngin = new Engin();
            ArrayList<Intervention> lesInterventions = null;

            
            int resultatUpdate = -1;
            try {
                requete=connection.prepareStatement("INSERT INTO ENGIN (ENGTYP_ID, CAS_ID, ENG_LIBELLE) VALUES (?, ?, ?)");
                requete.setString(1, String.valueOf(engin.getLeTypeEngin().getId()));
                requete.setString(2, String.valueOf(engin.getLaCaserne().getId()));
                requete.setString(3, String.valueOf(engin.getLibelle()));

                //executer la reguete
                resultatUpdate = requete.executeUpdate();
                
                    
                
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return resultatUpdate; 
        }    
        
        public static ArrayList<Engin> getLesEngins(Connection connection){
        
            ArrayList<Engin> lesEngins = new ArrayList<Engin>();


            try {
                requete=connection.prepareStatement("SELECT * FROM ENGIN");

                //executer la reguete
                rs=requete.executeQuery();
                while(rs.next()){
                    Engin unEngin = new Engin();
                    EnginType unType = new EnginType();
                    Caserne uneCaserne = new Caserne();
                    
                    unType.setId(Integer.valueOf(rs.getString("ENGTYP_ID")));
                    uneCaserne.setId(Integer.valueOf(rs.getString("CAS_ID")));
                    
                    unEngin.setId(Integer.parseInt(rs.getString("ENG_ID")));
                    unEngin.setLeTypeEngin(unType);
                    unEngin.setLaCaserne(uneCaserne);
                    unEngin.setLibelle(rs.getString("ENG_LIBELLE"));

                    
                    System.out.println(unEngin.getId());
                    

                    lesEngins.add(unEngin);
                }
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return lesEngins; 
        }
        
        public static ArrayList<Engin> getLesEnginsByIdCaserne(Connection connection, int CaserneId){
        
            ArrayList<Engin> lesEngins = new ArrayList<Engin>();


            try {
                requete=connection.prepareStatement("SELECT * FROM ENGIN, CASERNE WHERE engin.CAS_ID = caserne.CAS_ID AND CAS_ID = ?");
                
                requete.setString(1, String.valueOf(CaserneId));

                //executer la reguete
                rs=requete.executeQuery();
                while(rs.next()){
                    Engin unEngin = new Engin();
                    EnginType unType = new EnginType();
                    Caserne uneCaserne = new Caserne();
                    
                    unType.setId(Integer.valueOf(rs.getString("ENGTYP_ID")));
                    uneCaserne.setId(Integer.valueOf(rs.getString("CAS_ID")));
                    
                    unEngin.setId(Integer.parseInt(rs.getString("ENG_ID")));
                    unEngin.setLeTypeEngin(unType);
                    unEngin.setLaCaserne(uneCaserne);
                    unEngin.setLibelle(rs.getString("ENG_LIBELLE"));

                    
                    System.out.println(unEngin.getId());
                    

                    lesEngins.add(unEngin);
                }
                    ConnexionBdd.fermerConnexion(rs);
                    ConnexionBdd.fermerConnexion(requete); 
            }catch (SQLException e){
                e.printStackTrace();
            }

            return lesEngins; 
        }
}
