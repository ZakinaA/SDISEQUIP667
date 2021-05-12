/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import DAO.CaserneDAO;
import DAO.ConnexionBdd;
import DAO.ProfessionDAO;
import DAO.ProfessionnelDAO;
import DAO.VolontaireDAO;
import java.sql.Connection;
import modele.Caserne;
import modele.Compte;
import modele.Pompier;
import modele.Profession;
import modele.Professionnel;
import modele.Volontaire;


/**
 *
 * @author ts1sio
 */
public class MenuAdmin extends javax.swing.JFrame {
    
    Connection cnt;
    Compte leCompte;
    int leMatricule;
    String leType;
    Pompier lePompier;
    Caserne laCaserne;

    /**
     * Creates new form Accueil
     */
    public MenuAdmin() {
        initComponents();
       
    }

    public MenuAdmin(Compte unCompte) {
        initComponents();
                
        leMatricule = unCompte.getId();
        leType = unCompte.getLeType();
        leCompte = unCompte;
       
        //FONCTION 
        lePompier = unCompte.getLePompier();
        
        //GET CASERNE
        cnt = ConnexionBdd.ouvrirConnexion();
        laCaserne = CaserneDAO.getCaserneById(cnt, lePompier.getLaCaserne().getId());
        
        //SET NAME
        j_prename.setText(String.valueOf(lePompier.getPom_nom().toUpperCase()));
        j_name.setText(String.valueOf(lePompier.getPom_prenom()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        j_prename = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        j_name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/utilisateur.png"))); // NOI18N
        jButton2.setText("PROFIL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/client.png"))); // NOI18N
        jButton4.setText("LISTE DES INTERVENTIONS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 390, 80));

        jButton3.setText("MES INTERVENTIONS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 180, -1));

        j_prename.setFont(new java.awt.Font("Reem Kufi", 0, 22)); // NOI18N
        j_prename.setForeground(new java.awt.Color(255, 204, 204));
        j_prename.setText("(prénom)");
        getContentPane().add(j_prename, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 120, -1));

        jLabel1.setFont(new java.awt.Font("Reem Kufi", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("(ADMIN)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 180, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/clients.png"))); // NOI18N
        jButton8.setText("LISTE DES POMPIERS");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 390, 80));

        jButton5.setText("MA CASERNE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/retour.png"))); // NOI18N
        jButton6.setText("LISTE DES CASERNES");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 390, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/barre.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 720, 60));

        jLabel5.setFont(new java.awt.Font("Reem Kufi", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 204));
        jLabel5.setText("BONJOUR");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, -1));

        j_name.setFont(new java.awt.Font("Reem Kufi", 0, 22)); // NOI18N
        j_name.setForeground(new java.awt.Color(255, 204, 204));
        j_name.setText("(nom)");
        getContentPane().add(j_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 120, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/fond.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        System.exit(0);  
        this.setVisible(false);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        cnt = ConnexionBdd.ouvrirConnexion();
        
        int isVolontaire = VolontaireDAO.isVolontaire(cnt, leMatricule);
        if(isVolontaire == 1){
            Volontaire leVolontaire = VolontaireDAO.getVolontaire(cnt, leMatricule);
            Profession laProfession = ProfessionDAO.getProfession(cnt, leVolontaire.getProfessionId());
            new Profil(leCompte, lePompier, leVolontaire, laProfession, "accueil").setVisible(true);
        }else{
            Professionnel leProfessionnel = ProfessionnelDAO.getProfessionnel(cnt, leMatricule);
            new Profil(leCompte, lePompier, leProfessionnel, "accueil").setVisible(true);
        }
        this.setVisible(false);
    }               
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            new ListeInter(leCompte, lePompier, "accueil").setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new ListeInter(leCompte, "accueil").setVisible(true);    
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new CaserneVue(leCompte, laCaserne, "accueil").setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                new ListeCaserne(leCompte).setVisible(true);    
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void quitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_quitButtonMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new Pompiers(leCompte, "accueil").setVisible(true);    
        this.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel j_name;
    private javax.swing.JLabel j_prename;
    // End of variables declaration//GEN-END:variables
}







