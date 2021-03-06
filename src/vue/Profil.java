/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import DAO.ConnexionBdd;
import DAO.FonctionsDAO;
import java.sql.Connection;
import java.util.ArrayList;
import modele.Grade;
import modele.Caserne;
import modele.Fonction;
import modele.Pompier;
import modele.Compte;
import modele.Profession;
import modele.Professionnel;
import modele.Volontaire;

/**
 *
 * @author ts1sio
 */

public class Profil extends javax.swing.JFrame {
    
    Connection cnt;
    Grade leGrade;
    Caserne laCaserne;
    String leType;
    Compte leCompte;
    String laProvenance;

    /**
     * Creates new form Accueil
     */
    public Profil() {
        initComponents();
    }
    
//FROM ACCUEIL
    
    public Profil(Compte unCompte, Pompier lePompier, Volontaire leVolontaire, Profession laProfession, String uneProvenance) {
        initComponents();
        
        leGrade = lePompier.getLeGrade();
        laCaserne = lePompier.getLaCaserne();
        leType = unCompte.getLeType();
        leCompte = unCompte;
        laProvenance = uneProvenance;
        
        cnt = ConnexionBdd.ouvrirConnexion();
        ArrayList<Fonction> lesfonctions = FonctionsDAO.getFonctions(cnt, lePompier.getPom_id());
        
        String fctString = "";  
        for(int i = 0; i < lesfonctions.size(); i++){
            fctString = fctString + (lesfonctions.get(i).getLibelle()) + ", " ; 
         }        
        
        
        //SET NAME
        j_prename.setText(String.valueOf(lePompier.getPom_nom().toUpperCase()));
        j_dateNaissance.setText(String.valueOf(lePompier.getPom_dateNaissance()));
        j_numBip.setText(String.valueOf(lePompier.getPom_numeroBip()));
        j_fonctions.setText(fctString);
        j_name.setText(String.valueOf(lePompier.getPom_prenom()));
        j_grade.setText(String.valueOf(leGrade.getLibelle()));
        j_caserne.setText(String.valueOf(laCaserne.getNom()));
        j_sexe.setText(String.valueOf(lePompier.getPom_sexe()));
        j_type.setText("VOLONTAIRE");
        
    }
    
    
    public Profil(Compte unCompte, Pompier lePompier, Professionnel leProfessionnel, String uneProvenance) {
        initComponents();
        
        leGrade = lePompier.getLeGrade();
        laCaserne = lePompier.getLaCaserne();
        leType = unCompte.getLeType();
        leCompte = unCompte;
        laProvenance = uneProvenance;
        
        cnt = ConnexionBdd.ouvrirConnexion();
        ArrayList<Fonction> lesfonctions = FonctionsDAO.getFonctions(cnt, lePompier.getPom_id());
        
        String fctString = "";  
        for(int i = 0; i < lesfonctions.size(); i++){
            fctString = fctString + (lesfonctions.get(i).getLibelle()) + ", " ; 
         }        
        
        //SET NAME
        j_prename.setText(String.valueOf(lePompier.getPom_nom().toUpperCase()));
        j_dateNaissance.setText(String.valueOf(lePompier.getPom_dateNaissance()));
        j_numBip.setText(String.valueOf(lePompier.getPom_numeroBip()));
        j_fonctions.setText(fctString);
        j_name.setText(String.valueOf(lePompier.getPom_prenom()));
        j_grade.setText(String.valueOf(leGrade.getLibelle()));
        j_caserne.setText(String.valueOf(laCaserne.getNom()));
        j_sexe.setText(String.valueOf(lePompier.getPom_sexe()));
        j_type.setText("PROFESSIONNEL");
           
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        j_prename = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        j_caserne = new javax.swing.JLabel();
        j_fonctions = new javax.swing.JLabel();
        j_grade = new javax.swing.JLabel();
        j_dateNaissance = new javax.swing.JLabel();
        j_numBip = new javax.swing.JLabel();
        j_type = new javax.swing.JLabel();
        j_name = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        j_sexe = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Reem Kufi", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("PROFIL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Type de pompier :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Informations");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        j_prename.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_prename.setText("#prenom");
        getContentPane().add(j_prename, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Pr??nom :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Caserne : ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Fonction(s) :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jButton5.setText("RETOUR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/barre.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 720, 60));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Grade : ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Date de naissance :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Num??ro de bip : ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Nom : ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        j_caserne.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_caserne.setText("#caserne");
        getContentPane().add(j_caserne, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));

        j_fonctions.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_fonctions.setText("#fonctions");
        getContentPane().add(j_fonctions, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        j_grade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_grade.setText("#grade");
        getContentPane().add(j_grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, -1, -1));

        j_dateNaissance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_dateNaissance.setText("#datenaissance");
        getContentPane().add(j_dateNaissance, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, -1, -1));

        j_numBip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_numBip.setText("#numbip");
        getContentPane().add(j_numBip, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, -1, -1));

        j_type.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_type.setText("#type");
        getContentPane().add(j_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, -1, -1));

        j_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_name.setText("#nom");
        getContentPane().add(j_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Sexe :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        j_sexe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_sexe.setText("#sexe");
        getContentPane().add(j_sexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/fond.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(laProvenance.equals("accueil")){
            if(leType.equals("a")){
                new MenuAdmin(leCompte).setVisible(true);
            }else if(leType.equals("s")){
                new MenuSalarie(leCompte).setVisible(true);
            }
        }else if(laProvenance.equals("pompiers")){
            new Pompiers(leCompte, "accueil").setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel j_caserne;
    private javax.swing.JLabel j_dateNaissance;
    private javax.swing.JLabel j_fonctions;
    private javax.swing.JLabel j_grade;
    private javax.swing.JLabel j_name;
    private javax.swing.JLabel j_numBip;
    private javax.swing.JLabel j_prename;
    private javax.swing.JLabel j_sexe;
    private javax.swing.JLabel j_type;
    // End of variables declaration//GEN-END:variables
}
