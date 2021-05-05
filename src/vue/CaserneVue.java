/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import modele.Caserne;
import modele.Compte;

/**
 *
 * @author ts1sio
 */
public class CaserneVue extends javax.swing.JFrame {
    
    Compte leCompte;
    Caserne laCaserne;

    /**
     * Creates new form Accueil
     */
    public CaserneVue() {
        initComponents();
    }

    
    public CaserneVue(Compte unCompte, Caserne uneCaserne){
        initComponents();
        
        leCompte = unCompte;
        laCaserne = uneCaserne;
        
        //SET NAME
        j_nom.setText(String.valueOf(laCaserne.getNom().toUpperCase()));
        j_rue.setText(String.valueOf(laCaserne.getRue()));
        j_cp.setText(String.valueOf(laCaserne.getCp()));
        j_ville.setText(String.valueOf(laCaserne.getVille()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        j_nom = new javax.swing.JLabel();
        j_cp = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        j_ville = new javax.swing.JLabel();
        j_rue = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("ACCUEIL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/barre.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 720, 60));

        jLabel4.setFont(new java.awt.Font("Reem Kufi", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 204));
        jLabel4.setText("CASERNE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/clients.png"))); // NOI18N
        jButton5.setText("Engins");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 140, 70));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/client.png"))); // NOI18N
        jButton6.setText("Pompiers");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 140, 70));

        j_nom.setFont(new java.awt.Font("Reem Kufi", 0, 24)); // NOI18N
        j_nom.setForeground(new java.awt.Color(0, 0, 204));
        j_nom.setText("#nomdelacaserne");
        getContentPane().add(j_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 410, -1));

        j_cp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_cp.setText("#Cp");
        getContentPane().add(j_cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 340, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Adresse : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 70, 20));

        j_ville.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_ville.setText("#Ville");
        getContentPane().add(j_ville, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 330, 20));

        j_rue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        j_rue.setText("#Rue");
        getContentPane().add(j_rue, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 320, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/fond.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(leCompte.getLeType().equals("s")){
            new MenuSalarie(leCompte).setVisible(true);
        }else if(leCompte.getLeType().equals("a")){
            new MenuAdmin(leCompte).setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new Engins().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new Pompiers(laCaserne).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(CaserneVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaserneVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaserneVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaserneVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CaserneVue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel j_cp;
    private javax.swing.JLabel j_nom;
    private javax.swing.JLabel j_rue;
    private javax.swing.JLabel j_ville;
    // End of variables declaration//GEN-END:variables
}
