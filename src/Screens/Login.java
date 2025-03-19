package Screens;

import Body.User;
import ConnectSQL.ConnectDAO;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    
    public Login() {
        initComponents();
        // icone app
        setIcon();
        // esconder campo de senha com codigo de bolinha
        campoSenha.setEchoChar('\u25cf');
        
    }

    
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoEmail = new javax.swing.JTextField();
        esqueceSenha = new javax.swing.JButton();
        entrar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        campoSenha = new javax.swing.JPasswordField();
        mostrar = new javax.swing.JLabel();
        esconder = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoEmail.setBackground(new java.awt.Color(241, 239, 246));
        campoEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        campoEmail.setForeground(new java.awt.Color(0, 0, 0));
        campoEmail.setBorder(null);
        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });
        getContentPane().add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 206, 440, 40));

        esqueceSenha.setContentAreaFilled(false);
        esqueceSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        esqueceSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esqueceSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(esqueceSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, 210, 30));

        entrar.setContentAreaFilled(false);
        entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        getContentPane().add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 170, 50));

        cadastrar.setContentAreaFilled(false);
        cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 600, 310, 70));

        campoSenha.setBackground(new java.awt.Color(241, 239, 246));
        campoSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        campoSenha.setForeground(new java.awt.Color(0, 0, 0));
        campoSenha.setBorder(null);
        getContentPane().add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 335, 420, 40));

        mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/mostrar.png"))); // NOI18N
        mostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarMouseClicked(evt);
            }
        });
        getContentPane().add(mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1104, 334, 40, 40));

        esconder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/esconder.png"))); // NOI18N
        esconder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        esconder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                esconderMouseClicked(evt);
            }
        });
        getContentPane().add(esconder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1104, 334, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Login (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        // botao cadastrar
        new Cadastro().setVisible(true);
        dispose();
    }//GEN-LAST:event_cadastrarActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        // botao entrar
        
        User user = new User();
        user.setEmail(campoEmail.getText());
        user.setPassword(new String (campoSenha.getPassword()));
        if(new ConnectDAO().CheckUser(user) == true){
            
            Dashboard dashboard = new Dashboard(new ConnectDAO().GetIdUser(user));
            dashboard.setVisible(true);
            dispose();
        }
        else{
            // tela de mensagem
            JOptionPane.showMessageDialog(null, "Usuário não reconhecido", "Aviso", 0);
        }
        
        
    }//GEN-LAST:event_entrarActionPerformed

    private void esqueceSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esqueceSenhaActionPerformed
        // botao esqueceu a senha
        new RecuperarConta().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_esqueceSenhaActionPerformed

    private void mostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrarMouseClicked
        // TODO add your handling code here:
        
        mostrar.setVisible(false);
        esconder.setVisible(true);
        campoSenha.setEchoChar((char)0);
    }//GEN-LAST:event_mostrarMouseClicked

    private void esconderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_esconderMouseClicked
        // TODO add your handling code here:
        mostrar.setVisible(true);
        esconder.setVisible(false);
        campoSenha.setEchoChar('\u25cf');
    }//GEN-LAST:event_esconderMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel esconder;
    private javax.swing.JButton esqueceSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mostrar;
    // End of variables declaration//GEN-END:variables
    
    // metodo para aparecer icone app
    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
}
