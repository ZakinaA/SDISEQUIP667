/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.PompierDAO.requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import modele.Engin;
import modele.Intervention;
import modele.Pompier;
import modele.Type;

/**
 *
 * @author ts1sio
 */
public class interventionDAO {

    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    
    public static ArrayList<Intervention> getLesInterventions(Connection cnt) {
        ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
        
        try{
            requete=cnt.prepareStatement("SELECT * FROM INTERVENTION, type where type.typ_id = intervention.typ_id");    
            
                //executer la reguete
                rs=requete.executeQuery();
                while (rs.next()){
                    
                    Intervention uneIntervention = new Intervention ();
                    uneIntervention.setId(rs.getInt("INT_ID"));
                    uneIntervention.setAdresse(rs.getString("INT_LIEU"));
                    uneIntervention.setDuree(rs.getTime("INT_DUREE"));
                    uneIntervention.setHeureAppel(rs.getTime("INT_HEUREAPPEL"));
                    uneIntervention.setDate(rs.getDate("INT_DATE"));
                    lesInterventions.add(uneIntervention);
                    
                    Type unTypeIntervention = new Type ();
                    unTypeIntervention.setId(rs.getInt ("TYP_ID"));
                    unTypeIntervention.setLibelle(rs.getString ("TYP_LIBELLE"));
                    
                    uneIntervention.setUnTypeIntervention(unTypeIntervention);
                    
                    
                }
                
                
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete); 
            
        }catch (SQLException e){
            
            e.printStackTrace();
        }

        return lesInterventions;
    }


   



    

    public static Intervention getUneIntervention(Connection connection, int id){
        Intervention lesInterventions = new Intervention();
        
        try{
            requete=connection.prepareStatement("SELECT * FROM INTERVENTION WHERE INT_ID = ?" );    
            requete.setString(1, String.valueOf(id));
            
                //executer la reguete
                rs=requete.executeQuery();
                if (rs.next()){
                    lesInterventions.setId(Integer.parseInt(rs.getString("INT_ID")));
                    lesInterventions.setAdresse(rs.getString("INT_LIEU"));
                    lesInterventions.setCp(rs.getString("INT_CP"));
                    lesInterventions.setVille(rs.getString("INT_VILLE"));
                    lesInterventions.setDate(rs.getDate("INT_DATE"));
                    lesInterventions.setHeureAppel(rs.getTime("INT_HEUREAPPEL"));
                    lesInterventions.setDuree(rs.getTime("INT_DUREE"));
                    
                }
                
                
            ConnexionBdd.fermerConnexion(rs);
            ConnexionBdd.fermerConnexion(requete); 
        }catch (SQLException e){
            e.printStackTrace();
        }

        return lesInterventions;
    
    }
    
    public static Intervention AddIntervention(Connection connection, int id){
        Intervention uneIntervention = new Intervention();
        
        try{
            requete=connection.prepareStatement("INSERT INTO `intervention` (`INT_VILLE`, `INT_DATE`, `INT_HEUREAPPEL`, `INT_DUREE`, `INT_Adresse`, `INT_CP`) VALUES ('?', '?', '?', '?', '?', '?', '?', '?'); " );    
            requete.setString(1, String.valueOf(id));
            
        
                   
        ConnexionBdd.fermerConnexion(rs);
        ConnexionBdd.fermerConnexion(requete); 
        }catch (SQLException e){
            e.printStackTrace();
        }

        return uneIntervention;
    }
    
        public static ArrayList<Intervention> getLesInterventionsByPompierID(Connection connection, int matricule){
        ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
            try {
                requete=connection.prepareStatement("SELECT * FROM intervenir, intervention, type WHERE intervenir.pom_id = ? and intervenir.int_id = intervention.int_id and type.TYP_ID = intervention.TYP_ID");
                requete.setString(1, String.valueOf(matricule));
                //executer la reguete
                rs=requete.executeQuery();
                while (rs.next()){
                    
                    Intervention uneIntervention = new Intervention ();
                    uneIntervention.setId(rs.getInt("INT_ID"));
                    uneIntervention.setAdresse(rs.getString("INT_LIEU"));
                    uneIntervention.setDuree(rs.getTime("INT_DUREE"));
                    uneIntervention.setHeureAppel(rs.getTime("INT_HEUREAPPEL"));
                    uneIntervention.setDate(rs.getDate("INT_DATE"));
                    lesInterventions.add(uneIntervention);
                    
                    Type unTypeIntervention = new Type();
                    unTypeIntervention.setId(rs.getInt ("TYP_ID"));
                    unTypeIntervention.setLibelle(rs.getString ("TYP_LIBELLE"));
                    
                    uneIntervention.setUnTypeIntervention(unTypeIntervention);
                    
                    
                }
                
                
            ConnexionBdd.fermerConnexion(rs);
            
        }catch (SQLException e){
            
            e.printStackTrace();
        }

        return lesInterventions;
        }
}


    
    
    

