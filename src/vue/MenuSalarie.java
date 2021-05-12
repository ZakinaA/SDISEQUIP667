/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import DAO.ConnexionBdd;
import DAO.CaserneDAO;
import DAO.ProfessionDAO;
import DAO.ProfessionnelDAO;
import DAO.VolontaireDAO;
import java.sql.Connection;
import modele.Caserne;
import modele.Compte;
import modele.Pompier;
import modele.Profession;
import modele.Volontaire;
import modele.Professionnel;

/**
 *
 * @author ts1sio
 */
public class MenuSalarie extends javax.swing.JFrame {
    
    Connection cnt;
    int leMatricule;
    String leType;
    Compte leCompte;
    Pompier lePompier;
    Caserne laCaserne;
    
    /**
     * Creates new form Accueil
     */
    public MenuSalarie() {
        initComponents();  
    }

    public MenuSalarie(Compte unCompte) {
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

        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        j_prename = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        j_name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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

        jButton4.setText("MA CASERNE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jButton3.setText("INTERVENTION");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 150, -1));

        quitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/key.png"))); // NOI18N
        quitButton.setText("Quitter");
        quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitButtonMouseClicked(evt);
            }
        });
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(quitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 120, -1));

        j_prename.setFont(new java.awt.Font("Reem Kufi", 0, 22)); // NOI18N
        j_prename.setForeground(new java.awt.Color(255, 204, 204));
        j_prename.setText("(prénom)");
        getContentPane().add(j_prename, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 120, -1));

        jLabel1.setFont(new java.awt.Font("Reem Kufi", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("(SALARIE)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 180, -1));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            new ListeInter(leCompte, lePompier, "accueil").setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(leType.equals("a")){
            new ListeCaserne(leCompte).setVisible(true);
        }else if(leType.equals("s")){
            new CaserneVue(leCompte, laCaserne, "accueil").setVisible(true);
        }
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void quitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_quitButtonMouseClicked

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        System.exit(0);
        this.setVisible(false);
    }//GEN-LAST:event_quitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MenuSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuSalarie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MenuSalarie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel j_name;
    private javax.swing.JLabel j_prename;
    private javax.swing.JButton quitButton;
    // End of variables declaration//GEN-END:variables
}






