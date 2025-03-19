
package Screens;

import java.awt.Toolkit;


public class Dashboard extends javax.swing.JFrame {

    static int idUser;
    
    public Dashboard(int novoId) {
        initComponents();
        setIcon();
        idUser = novoId;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        minhaConta = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        criarCards = new javax.swing.JButton();
        meusCards = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minhaConta.setToolTipText("Minha conta");
        minhaConta.setContentAreaFilled(false);
        minhaConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minhaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minhaContaActionPerformed(evt);
            }
        });
        getContentPane().add(minhaConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 30, 80, 80));

        sair.setContentAreaFilled(false);
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        getContentPane().add(sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 200, 70));

        criarCards.setContentAreaFilled(false);
        criarCards.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        criarCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarCardsActionPerformed(evt);
            }
        });
        getContentPane().add(criarCards, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 390, 70));

        meusCards.setContentAreaFilled(false);
        meusCards.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        meusCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meusCardsActionPerformed(evt);
            }
        });
        getContentPane().add(meusCards, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 390, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Dashboard.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void criarCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarCardsActionPerformed
        // botao criar flashcards
        new CriarLista(idUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_criarCardsActionPerformed

    private void minhaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minhaContaActionPerformed
        // botao minha conta
        
        new MinhaConta(idUser).setVisible(true);
        dispose();
        
    }//GEN-LAST:event_minhaContaActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // botao sair 
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void meusCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meusCardsActionPerformed
        // botao meus flashcards
        MeusFlashcards flsh = new MeusFlashcards(idUser);
           flsh.setVisible(true);
        //new MeusFlashcards(idUser).setVisible(true);
        dispose();
        
        
    }//GEN-LAST:event_meusCardsActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(idUser).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton criarCards;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton meusCards;
    private javax.swing.JButton minhaConta;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
}
