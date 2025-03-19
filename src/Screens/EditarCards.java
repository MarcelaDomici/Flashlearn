package Screens;

import Body.Flashcards;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import Body.Estudo;
import Elements.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EditarCards extends javax.swing.JFrame {
    private static int idUser;
    private String nomeLista;
    private Flashcards flash;
    private List<Estudo> list = new List<Estudo>();
    private ArrayList<Estudo> estudos;
    private DefaultTableModel model;
    private int cont = 0;
    
    public EditarCards(Flashcards newFlash,String novaLista, int novoId) {
        initComponents();
        setIcon();
        idUser = novoId;
        nomeLista = novaLista;
        jLabel2.setText(nomeLista);
        flash = newFlash;
        UpdateTable(flash);
    }
    
    private void UpdateTable(Flashcards flashnew){
        model = (DefaultTableModel) this.jTable1.getModel();
        model.setRowCount(0);
        for(Estudo estudo : new ConnectSQL.ConnectDAO().estudar(flashnew, idUser)){
            model.addRow(new Object[]{estudo.getPergunta(), estudo.getResposta()});
        }
        estudos = new ConnectSQL.ConnectDAO().estudar(flash, idUser);
        cont =0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addCard = new javax.swing.JButton();
        excluirCard = new javax.swing.JButton();
        salvarEdicao = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addCard.setToolTipText("Adicionar Card");
        addCard.setContentAreaFilled(false);
        addCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCardMouseClicked(evt);
            }
        });
        addCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCardActionPerformed(evt);
            }
        });
        addCard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addCardKeyPressed(evt);
            }
        });
        getContentPane().add(addCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 370, 100, 90));

        excluirCard.setToolTipText("Excluir Card");
        excluirCard.setContentAreaFilled(false);
        excluirCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluirCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                excluirCardMouseClicked(evt);
            }
        });
        getContentPane().add(excluirCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 240, 100, 90));

        salvarEdicao.setToolTipText("Salvar Dados");
        salvarEdicao.setContentAreaFilled(false);
        salvarEdicao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salvarEdicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salvarEdicaoMouseClicked(evt);
            }
        });
        salvarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarEdicaoActionPerformed(evt);
            }
        });
        getContentPane().add(salvarEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 490, 100, 100));

        voltar.setContentAreaFilled(false);
        voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        getContentPane().add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 80, 80));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Perguntas", "Respostas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 890, 490));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 104, 720, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar cards.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // botao voltar
        
        new MeusFlashcards(idUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void excluirCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excluirCardMouseClicked
        if((this.estudos.size())<=this.jTable1.getSelectedRow()){
            if(this.jTable1.getSelectedRow()<0){
                UpdateTable(flash);
                return;
            }
            this.model.removeRow(this.jTable1.getSelectedRow());
            if(cont!=0)cont--;
        }else{
            int p = JOptionPane.showConfirmDialog(null, "Você tem certeza de que deseja excluir esse card?","Aviso", JOptionPane.OK_CANCEL_OPTION);
            if(p==0){
                try{
                    
                    new ConnectSQL.ConnectDAO().DeleteItemAtList(this.estudos.get(this.jTable1.getSelectedRow()).getId());
                    UpdateTable(flash);
                }catch(SQLException ei){
                }
            }
        }
    }//GEN-LAST:event_excluirCardMouseClicked

    private void salvarEdicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salvarEdicaoMouseClicked
        try{            
            for(int i=0;i<this.estudos.size();i++){
            Estudo study = new Estudo();
            study.setPergunta(String.valueOf(model.getValueAt(i, 0)));
            study.setResposta(String.valueOf(model.getValueAt(i, 1)));
            study.setId(this.estudos.get(i).getId());
            
            if(study.getPergunta()!=null&&study.getResposta()!=null)list.Add(study);
            }
            list.flush();
            list = new List<>();
        }catch(SQLException ie){
        }
        if(cont>0){
            ArrayList<Estudo> study = new ArrayList<>();
            for(int i=0;i<(this.model.getRowCount()-this.estudos.size());i++){
                Estudo studies = new Estudo();
                studies.setPergunta((String)this.model.getValueAt(this.estudos.size()+i, 0));
                studies.setResposta((String)this.model.getValueAt(this.estudos.size()+i, 1));
                if (studies.getPergunta()!=null &&studies.getResposta()!=null){
                   if(studies.getPergunta().length()!=0&&studies.getResposta().length()!=0)study.add(studies);
                }
            }
            for(int i =0;i<study.size();i++){
                try {
                    new ConnectSQL.ConnectDAO().InsertAskAnswer(study.get(i).getPergunta(), study.get(i).getResposta(), new ConnectSQL.ConnectDAO().GetIdList(flash), idUser);
                } catch (SQLException ex) {
                    Logger.getLogger(EditarCards.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        UpdateTable(flash);
        
        //mudei aqui
        JOptionPane.showMessageDialog(null, "Dados salvos com Sucesso!","Aviso!",1);
        new MeusFlashcards(idUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_salvarEdicaoMouseClicked
    
    }
    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
    }//GEN-LAST:event_jTable1KeyPressed

    private void addCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCardMouseClicked
        model.setNumRows(this.jTable1.getRowCount()+1);
        cont++;
    }//GEN-LAST:event_addCardMouseClicked

    private void addCardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addCardKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCardKeyPressed

    private void salvarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarEdicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salvarEdicaoActionPerformed

    private void addCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCardActionPerformed

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
            java.util.logging.Logger.getLogger(EditarCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new EditarCards(null,null, idUser).setVisible(true);
        });
    }

    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCard;
    private javax.swing.JButton excluirCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton salvarEdicao;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
