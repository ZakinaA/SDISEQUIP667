/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import DAO.CompteDAO;
import DAO.ConnexionBdd;
import java.sql.Connection;
import modele.Compte;
import modele.Pompier;
import modele.Grade;




/**
 *
 * @author ts1sio
 */
public class Connexion extends javax.swing.JFrame {
    
    Connection cnt;

    /**
     * Creates new form Connexion
     */
    public Connexion() {
        initComponents();
        jpnl_password.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        jlbl_connexion = new javax.swing.JButton();
        jtxt_login = new javax.swing.JTextField();
        jpsw_password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jpnl_password = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Reem Kufi", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EKIP667 POMPIER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, 366, 23));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Connexion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 366, 23));

        jlbl_connexion.setText("Connexion");
        jlbl_connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlbl_connexionActionPerformed(evt);
            }
        });
        getContentPane().add(jlbl_connexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        jtxt_login.setToolTipText("Identifiant");
        jtxt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_loginActionPerformed(evt);
            }
        });
        getContentPane().add(jtxt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 337, -1));

        jpsw_password.setToolTipText("Password");
        jpsw_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpsw_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(jpsw_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 337, -1));

        jLabel3.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/utilisateur.png"))); // NOI18N
        jLabel3.setText("Identifiant ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/key.png"))); // NOI18N
        jLabel4.setText("Mot de passe ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/pompier-image-animee-0011.gif"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/pompier-image-animee-0011.gif"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 0, 160, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/pompier-image-animee-0011.gif"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 80, 70));

        jpnl_password.setText("MESSAGEBOX");
        getContentPane().add(jpnl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 390, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/ban.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 410, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 410, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlbl_connexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlbl_connexionActionPerformed
        //Récupération variables
        String login = jtxt_login.getText();
        int loginNum = Integer.parseInt(login);
        String password = String.valueOf(jpsw_password.getPassword());
        
        //FONCTION 
        cnt = ConnexionBdd.ouvrirConnexion();
        Compte unCompte = CompteDAO.getCompte(cnt, loginNum, password);
        
        
        //jpnl_password.setText(unCompte.getId() + " / " + unCompte.getLePompier().getPom_nom() + " / " + unCompte.getLeType());
        
        if(unCompte.getLeType().equals("s")){
            new MenuSalarie(unCompte).setVisible(true);
            this.setVisible(false);
        }else if(unCompte.getLeType().equals("a")){
            new MenuAdmin(unCompte).setVisible(true);
            this.setVisible(false);
            jpnl_password.setText("admin");
        }else if(unCompte.getLeType().equals("r")){
            //new MenuResponsable().setVisible(true);
            //this.setVisible(false);
            jpnl_password.setText("Responsable");
        }else{
            jpnl_password.setText("Erreur dans votre demande");
        }
                

    }//GEN-LAST:event_jlbl_connexionActionPerformed

    private void jtxt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_loginActionPerformed

    private void jpsw_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpsw_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpsw_passwordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        Connection con = ConnexionBdd.ouvrirConnexion();
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
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jlbl_connexion;
    private javax.swing.JLabel jpnl_password;
    private javax.swing.JPasswordField jpsw_password;
    private javax.swing.JTextField jtxt_login;
    // End of variables declaration//GEN-END:variables
}