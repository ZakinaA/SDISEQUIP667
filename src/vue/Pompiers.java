/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import DAO.ConnexionBdd;
import DAO.PompierDAO;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modele.Caserne;
import modele.Compte;
import modele.Pompier;

/**
 *
 * @author ts1sio
 */
public class Pompiers extends javax.swing.JFrame {
    
    Caserne laCaserne;
    Connection cnt;
    Compte leCompte;
    String laProvenance;
    

    /**
     * Creates new form Accueil
     */
    public Pompiers() {
        initComponents();
    }
    
    public Pompiers(Compte unCompte, String uneProvenance) {
        initComponents();
        
        jLabel1.setText("");
        j_casnom.setText("");
        
        
        leCompte = unCompte;
        laProvenance = uneProvenance;
        
        
        //GET LES POMPIERS
        cnt = ConnexionBdd.ouvrirConnexion();
        ArrayList<Pompier> lesPompiers = PompierDAO.getAllPompiers(cnt);
        
        System.out.println(lesPompiers);
        
        DefaultTableModel model =  new DefaultTableModel(new String[]{"ID", "NOM", "PRENOM", "CASERNE"}, 1);
        
        
        jTable.setModel(model);
        for(int i = 0; i < lesPompiers.size(); i++){
            Pompier unPompier = lesPompiers.get(i) ;
           // System.out.println(String.valueOf(unPompier.getPom_id()) + unPompier.getPom_nom() + unPompier.getPom_prenom()+ unPompier.getLaCaserne().getId());
            model.addRow(new Object[] { String.valueOf(unPompier.getPom_id()) , unPompier.getPom_nom() , unPompier.getPom_prenom(), "A AJOUTER"});

        }
        
    }
    
    public Pompiers(Compte unCompte, Caserne uneCaserne, String uneProvenance) {
        initComponents();
        
        leCompte = unCompte;
        laCaserne = uneCaserne;
        laProvenance = uneProvenance;
        
        
        //GET LES POMPIERS
        cnt = ConnexionBdd.ouvrirConnexion();
        ArrayList<Pompier> lesPompiers = PompierDAO.getPompierByCaserne(cnt, laCaserne.getId());
        
        System.out.println(lesPompiers);
        
        DefaultTableModel model =  new DefaultTableModel(new String[]{"ID", "NOM", "PRENOM", "CASERNE"}, 1);
        
        
        jTable.setModel(model);
        for(int i = 0; i < lesPompiers.size(); i++){
            Pompier unPompier = lesPompiers.get(i) ;
           // System.out.println(String.valueOf(unPompier.getPom_id()) + unPompier.getPom_nom() + unPompier.getPom_prenom()+ unPompier.getLaCaserne().getId());
            model.addRow(new Object[] { String.valueOf(unPompier.getPom_id()) , unPompier.getPom_nom() , unPompier.getPom_prenom(), "A AJOUTER"});

        }
        
        //System.out.println(lesCasernes);
        
        //SET NAME
        j_casnom.setText(String.valueOf(laCaserne.getNom().toUpperCase()));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        j_casnom = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("RETOUR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Reem Kufi", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("de la caserne ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/barre.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 720, 60));

        j_casnom.setFont(new java.awt.Font("Reem Kufi", 0, 18)); // NOI18N
        j_casnom.setForeground(new java.awt.Color(102, 0, 51));
        j_casnom.setText("NOMCASERNE");
        getContentPane().add(j_casnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 220, -1));

        jLabel5.setFont(new java.awt.Font("Reem Kufi", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 204));
        jLabel5.setText("POMPIERS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, -1));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOM", "PRENOM", "CASERNE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, 470));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/fond.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(laProvenance.equals("accueil")){
            new MenuAdmin(leCompte).setVisible(true);
        }else if(laProvenance.equals("caserne")){
            new CaserneVue(leCompte, laCaserne, "accueil").setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked

        if(jTable.getValueAt(jTable.getSelectedRow(), 0) != null){

            int id = Integer.parseInt((String) jTable.getValueAt(jTable.getSelectedRow(), 0));

            //GetCaserne
            //cnt = ConnexionBdd.ouvrirConnexion();
            //lePompier = CaserneDAO.getCaserneById(cnt, id);

            //GoToPage
                //new CaserneVue(leCompte, laCaserne, "listecaserne").setVisible(true);
                //this.setVisible(false);
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
            java.util.logging.Logger.getLogger(Pompiers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pompiers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pompiers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pompiers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Pompiers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel j_casnom;
    // End of variables declaration//GEN-END:variables
}
