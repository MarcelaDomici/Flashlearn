
package Screens;

import Body.Estudo;
import Body.Flashcards;
import ConnectSQL.ConnectDAO;
import java.awt.Toolkit;
import java.util.ArrayList;


public class EstudoLista extends javax.swing.JFrame {

    static int idUser;
    ArrayList<Estudo> estudar;
    int contar;
    int acertou, errou;
    String nomeLista;
    
    public EstudoLista(Flashcards flashcards, int novoId, String novoNome) {
        initComponents();
        setIcon();
        nomeLista = novoNome;
        jLabel2.setText(nomeLista);
        
        idUser = novoId;
        this.contar=0;
        acertou = errou = 0;
        campoResposta.setWrapStyleWord(true);
        campoPergunta.setWrapStyleWord(true);
        estudar = new ConnectDAO().estudar(flashcards, idUser);
        errado.setEnabled(false);
        certo.setEnabled(false);
       
       campoPergunta.setText(estudar.get(0).getPergunta());
       
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errado = new javax.swing.JButton();
        mostrarResp = new javax.swing.JButton();
        certo = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        duvida = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoResposta = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        campoPergunta = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        errado.setToolTipText("Errei");
        errado.setContentAreaFilled(false);
        errado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        errado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                erradoActionPerformed(evt);
            }
        });
        getContentPane().add(errado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 400, 80, 80));

        mostrarResp.setContentAreaFilled(false);
        mostrarResp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarRespActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarResp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 340, 60));

        certo.setToolTipText("Acertei");
        certo.setContentAreaFilled(false);
        certo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        certo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certoActionPerformed(evt);
            }
        });
        getContentPane().add(certo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 290, 80, 80));

        sair.setContentAreaFilled(false);
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        getContentPane().add(sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 80, 100, 90));

        duvida.setContentAreaFilled(false);
        duvida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        duvida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duvidaActionPerformed(evt);
            }
        });
        getContentPane().add(duvida, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 90, 90));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        campoResposta.setEditable(false);
        campoResposta.setBackground(new java.awt.Color(241, 239, 246));
        campoResposta.setColumns(20);
        campoResposta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        campoResposta.setForeground(new java.awt.Color(241, 239, 246));
        campoResposta.setLineWrap(true);
        campoResposta.setRows(5);
        campoResposta.setBorder(null);
        campoResposta.setCaretColor(new java.awt.Color(241, 239, 246));
        campoResposta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campoResposta.setEnabled(false);
        jScrollPane2.setViewportView(campoResposta);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 820, 200));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        campoPergunta.setEditable(false);
        campoPergunta.setBackground(new java.awt.Color(241, 239, 246));
        campoPergunta.setColumns(20);
        campoPergunta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        campoPergunta.setLineWrap(true);
        campoPergunta.setRows(5);
        campoPergunta.setBorder(null);
        jScrollPane3.setViewportView(campoPergunta);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 820, 140));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 720, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Estudo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // botao sair
        new MeusFlashcards(idUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void mostrarRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarRespActionPerformed
        // TODO add your handling code here:
        
        campoResposta.setText(estudar.get(contar).getResposta());
        mostrarResp.setEnabled(false);
        errado.setEnabled(true);
        certo.setEnabled(true);
        
    }//GEN-LAST:event_mostrarRespActionPerformed

    private void certoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certoActionPerformed
        // TODO add your handling code here:
        errado.setEnabled(false);
        certo.setEnabled(false);
        contar++;
        campoResposta.setText("");
        if(contar != estudar.size()){
            campoPergunta.setText(estudar.get(contar).getPergunta());
            mostrarResp.setEnabled(true);
        }else{
            acertou++;
            new PontuacaoFinal(this.acertou, errou, idUser).setVisible(true);
            dispose(); 
        }
        acertou++;
    }//GEN-LAST:event_certoActionPerformed

    private void erradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_erradoActionPerformed
        // TODO add your handling code here:
        
        certo.setEnabled(false);
        errado.setEnabled(false);
        contar++;
        campoResposta.setText("");
        if(contar != estudar.size()){
            campoPergunta.setText(estudar.get(contar).getPergunta());
            mostrarResp.setEnabled(true);
        }else{
            errou++;
            new PontuacaoFinal(this.acertou, errou, idUser).setVisible(true);
            dispose();
        }
        errou++;
    }//GEN-LAST:event_erradoActionPerformed

    private void duvidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duvidaActionPerformed
        // TODO add your handling code here:
        
        
        new EstudoDuvidas(this).setVisible(true);
    }//GEN-LAST:event_duvidaActionPerformed

    
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
            java.util.logging.Logger.getLogger(EstudoLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstudoLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstudoLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstudoLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new EstudoLista(null, idUser, null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea campoPergunta;
    private javax.swing.JTextArea campoResposta;
    private javax.swing.JButton certo;
    private javax.swing.JButton duvida;
    private javax.swing.JButton errado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton mostrarResp;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
}
