
package Screens;

import ConnectSQL.ConnectDAO;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


public class MinhaConta extends javax.swing.JFrame {

    static int idUser; 
    
    public MinhaConta(int novoId) {
        initComponents();
        setIcon();
        idUser = novoId;
        ConnectDAO obj = new ConnectDAO();
        String t1 = obj.getNome(novoId);
        String t2 = obj.getEmail(novoId);
        
        nome.setText(t1);
        emai.setText(t2);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JLabel();
        emai = new javax.swing.JLabel();
        encerrar = new javax.swing.JButton();
        excluirConta = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        alterarDados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nome.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nome.setForeground(new java.awt.Color(255, 255, 255));
        nome.setText("Marcela Domiciano");
        getContentPane().add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 570, -1));

        emai.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        emai.setForeground(new java.awt.Color(217, 217, 216));
        emai.setText("marceladomiciano2@gmail.com");
        getContentPane().add(emai, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 174, 560, -1));

        encerrar.setContentAreaFilled(false);
        encerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        encerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encerrarActionPerformed(evt);
            }
        });
        getContentPane().add(encerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, 380, 70));

        excluirConta.setContentAreaFilled(false);
        excluirConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluirConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirContaActionPerformed(evt);
            }
        });
        getContentPane().add(excluirConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 380, 70));

        voltar.setContentAreaFilled(false);
        voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        getContentPane().add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 80, 80));

        alterarDados.setContentAreaFilled(false);
        alterarDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarDadosActionPerformed(evt);
            }
        });
        getContentPane().add(alterarDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 380, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Minha conta.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void encerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encerrarActionPerformed
        // encerrar sessao
        
        
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_encerrarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // voltar
        
        new Dashboard(idUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void excluirContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirContaActionPerformed
        // botao excluir
        
        int escolha = JOptionPane.showOptionDialog(
        null,
        "Você tem certeza de que deseja excluir sua conta?",
        "Excluir conta",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.WARNING_MESSAGE,
        null,
        new Object []{"Excluir", "Cancelar"},
        "sim"
        );
        
        if(escolha == 0){
            
            new ConnectDAO().deleteAll(idUser);
            new Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_excluirContaActionPerformed

    private void alterarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarDadosActionPerformed
        // botao alterar dados
        new AlterarDados(idUser).setVisible(true);
        dispose();
        
    }//GEN-LAST:event_alterarDadosActionPerformed

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
            java.util.logging.Logger.getLogger(MinhaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinhaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinhaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinhaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinhaConta(idUser).setVisible(true);
            }
        });
    }
    
    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarDados;
    private javax.swing.JLabel emai;
    private javax.swing.JButton encerrar;
    private javax.swing.JButton excluirConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nome;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
