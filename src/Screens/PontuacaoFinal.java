
package Screens;

import java.awt.Toolkit;


public class PontuacaoFinal extends javax.swing.JFrame {

    static int idUser;
            
    public PontuacaoFinal(int acerto, int erro, int novoId) {
        initComponents();
        setIcon();
        idUser = novoId;
        jLabel2.setText(String.valueOf(acerto));
        jLabel3.setText(String.valueOf(erro));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pagPrincipal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pagPrincipal.setContentAreaFilled(false);
        pagPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pagPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(pagPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 340, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("4");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(894, 398, 110, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("10");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 277, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pontuacao final.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pagPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagPrincipalActionPerformed
        // TODO add your handling code here:
        
        new MeusFlashcards(idUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_pagPrincipalActionPerformed

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
            java.util.logging.Logger.getLogger(PontuacaoFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PontuacaoFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PontuacaoFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PontuacaoFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PontuacaoFinal(0, 0, idUser).setVisible(true);
            }
        });
    }

    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton pagPrincipal;
    // End of variables declaration//GEN-END:variables
}
