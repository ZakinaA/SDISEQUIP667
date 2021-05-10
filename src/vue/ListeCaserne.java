/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import DAO.CaserneDAO;
import DAO.ConnexionBdd;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modele.Caserne;
import modele.Compte;

/**
 *
 * @author ts1sio
 */
public class ListeCaserne extends javax.swing.JFrame {
    
    Compte leCompte;
    Caserne laCaserne;
    Connection cnt;
    

    /**
     * Creates new form Accueil
     */
    public ListeCaserne() {
        initComponents();
        

        Connection cnt =  ConnexionBdd.ouvrirConnexion();
        ArrayList<Caserne> lesCasernes = CaserneDAO.getLesCasernes(cnt);
        
        System.out.println(lesCasernes.size());
        
        DefaultTableModel model =  new DefaultTableModel(new String[]{"ID", "NOM", "RUE", "CP", "VILLE"}, 1);
        
        
        jTable.setModel(model);
        for(int i = 0; i < lesCasernes.size(); i++){
            Caserne uneCaserne = lesCasernes.get(i) ;
            System.out.println(String.valueOf(uneCaserne.getId()) + uneCaserne.getNom() + uneCaserne.getRue() + uneCaserne.getCp() + uneCaserne.getVille());
            model.addRow(new Object[] { String.valueOf(uneCaserne.getId()), uneCaserne.getNom(), uneCaserne.getRue(), uneCaserne.getCp(), uneCaserne.getVille()});

        }
        
        System.out.println(lesCasernes);
        
        
    }
    
    
    public ListeCaserne(Compte unCompte) {
        initComponents();
        
        leCompte = unCompte;
        
        Connection cnt =  ConnexionBdd.ouvrirConnexion();
        ArrayList<Caserne> lesCasernes = CaserneDAO.getLesCasernes(cnt);
        
        System.out.println(lesCasernes.size());
        
        DefaultTableModel model =  new DefaultTableModel(new String[]{"ID", "NOM", "RUE", "CP", "VILLE"}, 1);
        
        jTable.setModel(model);
        for(int i = 0; i < lesCasernes.size(); i++){
            Caserne uneCaserne = lesCasernes.get(i) ;
            System.out.println(String.valueOf(uneCaserne.getId()) + uneCaserne.getNom() + uneCaserne.getRue() + uneCaserne.getCp() + uneCaserne.getVille());
            model.addRow(new Object[] { String.valueOf(uneCaserne.getId()), uneCaserne.getNom(), uneCaserne.getRue(), uneCaserne.getCp(), uneCaserne.getVille()});

        }
        
        System.out.println(lesCasernes);
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
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("ACCUEIL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/barre.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 720, 60));

        jLabel4.setFont(new java.awt.Font("Reem Kufi", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 204));
        jLabel4.setText("Liste Casernes");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 240, -1));

        jButton6.setText("AJOUTER");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 110, 40));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOM", "RUE", "CP", "VILLE"
            }
        ));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, 470));

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

    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new AddCaserne().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        
        if(jTable.getValueAt(jTable.getSelectedRow(), 0) != null){
            
            int id = Integer.parseInt((String) jTable.getValueAt(jTable.getSelectedRow(), 0));
            
            //GetCaserne
            cnt = ConnexionBdd.ouvrirConnexion();
            laCaserne = CaserneDAO.getCaserneById(cnt, id);
            
            //GoToPage
            new CaserneVue(leCompte, laCaserne, "listecaserne").setVisible(true);
            this.setVisible(false);
            //System.out.println(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTableMouseClicked

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
            java.util.logging.Logger.getLogger(ListeCaserne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListeCaserne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListeCaserne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListeCaserne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ListeCaserne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
