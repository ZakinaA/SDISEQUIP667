/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import modele.Caserne;
import DAO.CaserneDAO;
import DAO.ConnexionBdd;
import DAO.GradeDAO;
import DAO.PompierDAO;
import static java.lang.System.console;
import java.sql.Connection;
import java.util.ArrayList;
import modele.Compte;
import modele.Grade;
import modele.Pompier;

/**
 *
 * @author ts1sio
 */
public class AddPompier extends javax.swing.JFrame {
    
    Connection cnt;
    Compte leCompte;
    ArrayList<Caserne> lesCasernes;
    ArrayList<Grade> lesGrades;
   

    /**
     * Creates new form Accueil
     */
    public AddPompier() {
        initComponents();
    }
    
    public AddPompier(Compte unCompte) {
        initComponents();
        
        Connection cnt =  ConnexionBdd.ouvrirConnexion();
        
        leCompte = unCompte;
        
        lesCasernes = CaserneDAO.getLesCasernes(cnt);
        lesGrades = GradeDAO.getLesGrades(cnt);
        
        for(int i = 0; i < lesCasernes.size(); i++){
            Caserne uneCaserne = lesCasernes.get(i) ;
            jCaserne.addItem(uneCaserne.getNom());
        }
        
        for(int i = 0; i < lesGrades.size(); i++){
            Grade unGrade = lesGrades.get(i) ;
            jGrade.addItem(unGrade.getLibelle());
        }
        
        //On désactrive les infos de pro/volontaire
       j_profession.setVisible(false);
       j_profession_i.setVisible(false);
       j_ville.setVisible(false);
       j_ville_i.setVisible(false);
       j_indice.setVisible(false);
       j_indice_i.setVisible(false);
       j_dtindice.setVisible(false);
       j_dtindice_i.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        j_error = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        j_nom = new javax.swing.JTextField();
        j_prenom = new javax.swing.JTextField();
        j_sexe = new javax.swing.JTextField();
        j_tel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        j_numbip = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        j_naissance = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jGrade = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCaserne = new javax.swing.JComboBox<>();
        jVol = new javax.swing.JRadioButton();
        j_submit = new javax.swing.JButton();
        jPro = new javax.swing.JRadioButton();
        j_dtindice_i = new javax.swing.JTextField();
        j_dtindice = new javax.swing.JLabel();
        j_indice = new javax.swing.JLabel();
        j_indice_i = new javax.swing.JTextField();
        j_profession_i = new javax.swing.JTextField();
        j_profession = new javax.swing.JLabel();
        j_ville_i = new javax.swing.JTextField();
        j_ville = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        j_error.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(j_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 420, 20));

        jLabel1.setFont(new java.awt.Font("Reem Kufi", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("AJOUTER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 260, -1));

        jLabel6.setText("SEXE (H/F/A)");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jLabel5.setText("PRENOM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, 10));

        jLabel7.setText("GRADE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        jButton5.setText("RETOUR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/barre.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 720, 60));

        j_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_nomActionPerformed(evt);
            }
        });
        getContentPane().add(j_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 100, -1));
        getContentPane().add(j_prenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 100, -1));
        getContentPane().add(j_sexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 100, -1));
        getContentPane().add(j_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 100, -1));

        jLabel8.setText("NOM");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));
        getContentPane().add(j_numbip, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 100, -1));

        jLabel9.setText("NUMERO BIP");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, 10));
        getContentPane().add(j_naissance, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 100, -1));

        jLabel10.setText("DATE NAISSANCE");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, 10));

        jGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGradeActionPerformed(evt);
            }
        });
        getContentPane().add(jGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        jLabel11.setText("NUM. TEL");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));

        jLabel12.setText("CASERNE");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        getContentPane().add(jCaserne, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        jVol.setText("Volontaire");
        jVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVolActionPerformed(evt);
            }
        });
        getContentPane().add(jVol, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, -1, -1));

        j_submit.setText("Validé");
        j_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_submitActionPerformed(evt);
            }
        });
        getContentPane().add(j_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, -1, -1));

        jPro.setText("Professionnel");
        jPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProActionPerformed(evt);
            }
        });
        getContentPane().add(jPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));
        getContentPane().add(j_dtindice_i, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 100, -1));

        j_dtindice.setText("Dt obtention");
        getContentPane().add(j_dtindice, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, -1, -1));

        j_indice.setText("Indice");
        getContentPane().add(j_indice, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        j_indice_i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_indice_iActionPerformed(evt);
            }
        });
        getContentPane().add(j_indice_i, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 100, -1));
        getContentPane().add(j_profession_i, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 100, -1));

        j_profession.setText("Profession");
        getContentPane().add(j_profession, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, -1));
        getContentPane().add(j_ville_i, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 100, -1));

        j_ville.setText("Ville");
        getContentPane().add(j_ville, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vue/fond.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void j_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j_nomActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new ListeCaserne(leCompte).setVisible(true);
        this.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jVolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVolActionPerformed
       jVol.setSelected(true);
       jPro.setSelected(false);
       
       j_indice.setVisible(false);
       j_indice_i.setVisible(false);
       j_dtindice.setVisible(false);
       j_dtindice_i.setVisible(false);
       
       j_profession.setVisible(true);
       j_profession_i.setVisible(true);
       j_ville.setVisible(true);
       j_ville_i.setVisible(true);
    }//GEN-LAST:event_jVolActionPerformed

    private void jProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProActionPerformed
       jVol.setSelected(false);
       jPro.setSelected(true);
       
       j_indice.setVisible(true);
       j_indice_i.setVisible(true);
       j_dtindice.setVisible(true);
       j_dtindice_i.setVisible(true);
       
       j_profession.setVisible(false);
       j_profession_i.setVisible(false);
       j_ville.setVisible(false);
       j_ville_i.setVisible(false);
    }//GEN-LAST:event_jProActionPerformed

    private void j_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_submitActionPerformed
        String nom = String.valueOf(j_nom.getText());
        String prenom = String.valueOf(j_prenom.getText());
        String naissance = String.valueOf(j_naissance.getText());
        String numbip = String.valueOf(j_numbip.getText());
        String sexe = String.valueOf(j_sexe.getText());
        String tel = String.valueOf(j_tel.getText());
        
        String BoxGrade = (String) jGrade.getSelectedItem();
        String BoxCaserne = (String) jCaserne.getSelectedItem();
        
        if(jVol.isSelected()){
            String Type = "volontaire";
            
            String profession = String.valueOf(j_profession_i.getText());
            String ville = String.valueOf(j_ville_i.getText());
        }else if(jPro.isSelected()){
            String Type = "professionnel";
            
            String indice = String.valueOf(j_indice_i.getText());
            String dtindice = String.valueOf(j_dtindice_i.getText());
        }else{
            String Type = "";
        }
        
        Pompier lePompier = new Pompier();   
        lePompier.setPom_nom(nom);
        lePompier.setPom_prenom(prenom);
        lePompier.setPom_dateNaissance(naissance);
        lePompier.setPom_numeroBip(Integer.parseInt(naissance));
        lePompier.setPom_sexe(sexe);
        lePompier.setPom_telephone(tel);
        
        Caserne laCaserne = new Caserne();
        laCaserne = CaserneDAO.getCaserneByLibelle(cnt, BoxCaserne);
        
        Grade leGrade = new Grade();
        leGrade = GradeDAO.getGradeByLibelle(cnt, BoxGrade);
        
        lePompier.setLaCaserne(laCaserne);
        lePompier.setLeGrade(leGrade);
        
        int result = PompierDAO.AddPompier(cnt, lePompier);
        
        if(result != 1){
            j_error.setText("Erreur dans l'insertion");
        }else if(result == 1){
            j_error.setText("Caserne ajoutée");
            
            j_nom.setEnabled(false);
            j_prenom.setEnabled(false);
            j_naissance.setEnabled(false);
            j_numbip.setEnabled(false);
            j_sexe.setEnabled(false);
            j_tel.setEnabled(false);
            jGrade.setEnabled(false);
            jCaserne.setEnabled(false);
            jVol.setEnabled(false);
            jPro.setEnabled(false);
            j_naissance.setEnabled(false);
            j_profession.setEnabled(false);
            j_profession_i.setEnabled(false);
            j_ville.setEnabled(false);
            j_ville_i.setEnabled(false);
            j_indice.setEnabled(false);
            j_indice_i.setEnabled(false);
            j_dtindice.setEnabled(false);
            j_dtindice_i.setEnabled(false);
            j_submit.setEnabled(false);
           
        }
        
        
    }//GEN-LAST:event_j_submitActionPerformed

    private void jGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGradeActionPerformed

    }//GEN-LAST:event_jGradeActionPerformed

    private void j_indice_iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_indice_iActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j_indice_iActionPerformed

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
            java.util.logging.Logger.getLogger(AddPompier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPompier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPompier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPompier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AddPompier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jCaserne;
    private javax.swing.JComboBox<String> jGrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList2;
    private javax.swing.JRadioButton jPro;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton jVol;
    private javax.swing.JLabel j_dtindice;
    private javax.swing.JTextField j_dtindice_i;
    private javax.swing.JLabel j_error;
    private javax.swing.JLabel j_indice;
    private javax.swing.JTextField j_indice_i;
    private javax.swing.JTextField j_naissance;
    private javax.swing.JTextField j_nom;
    private javax.swing.JTextField j_numbip;
    private javax.swing.JTextField j_prenom;
    private javax.swing.JLabel j_profession;
    private javax.swing.JTextField j_profession_i;
    private javax.swing.JTextField j_sexe;
    private javax.swing.JButton j_submit;
    private javax.swing.JTextField j_tel;
    private javax.swing.JLabel j_ville;
    private javax.swing.JTextField j_ville_i;
    // End of variables declaration//GEN-END:variables
}
