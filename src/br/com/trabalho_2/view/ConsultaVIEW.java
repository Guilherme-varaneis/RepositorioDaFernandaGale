/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.trabalho_2.view;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.trabalho_2.dto.ConsultaDTO;
import br.com.trabalho_2.ctr.ConsultaCTR;
       

/**
 *
 * @author ferna
 */
public class ConsultaVIEW extends javax.swing.JInternalFrame {

        ConsultaDTO consultaDTO = new ConsultaDTO();
        ConsultaCTR consultaCTR= new ConsultaCTR();
        
        int gravar_alterar;
        ResultSet rs;
        DefaultTableModel modelo_jtl_consultar_consulta;
        
        public void setPosicao(){
            Dimension d = this.getDesktopPane().getSize();
            this.setLocation((d.width -  this.getSize().width)/2, (d.height - this.getSize().height)/2);
        }// fecha set posicao
        
        
        private void gravar(){
            try{
                consultaDTO.setLocal_cons(local_cons.getText());
                consultaDTO.setHora_cons(hora_cons.getText());
                consultaDTO.setNumero_cons(Integer.parseInt(numero_cons.getText()));
                JOptionPane.showMessageDialog(null,consultaCTR.inserirConcsulta(consultaDTO));
            }catch(Exception e){
                System.out.println("Erro ao gravar" +e.getMessage());
            }
        }// fecha gravar
        
        
         private void alterar(){
            try{
                consultaDTO.setLocal_cons(local_cons.getText());
                consultaDTO.setHora_cons(hora_cons.getText());
                consultaDTO.setNumero_cons(Integer.parseInt(numero_cons.getText()));
                JOptionPane.showMessageDialog(null,consultaCTR.inserirConcsulta(consultaDTO));
            }catch(Exception e){
                System.out.println("Erro ao alterar" +e.getMessage());
            }
        }// fecha alterar
        
        
         private void excluir(){
             if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Aviso",
                     JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
                              JOptionPane.showMessageDialog(null, consultaCTR.excluirConsulta(consultaDTO));
             }
         }// fecha excluir
         
         private void liberaCampos(boolean a){
             local_cons.setEnabled(a);
             hora_cons.setEnabled(a);
             numero_cons.setEnabled(a);
         }// feha libera campos
         
         private void liberaBotoes(boolean a, boolean b, boolean c, boolean d,boolean e){
             btnNovo.setEnabled(a);
             btnSalvar.setEnabled(b);
             btnCancelar.setEnabled(c);
             btnExcluir.setEnabled(d);
             btnSair.setEnabled(e);
         }// fecha botoes
         
         
         private void limpaCampos(){
             local_cons.setText("");
             hora_cons.setText("");
             numero_cons.setText("");
         }//fecha limpa
         
         private void preencheTabela(String local_cons){
             try{
                 modelo_jtl_consultar_consulta.setNumRows(0);
                 consultaDTO.setLocal_cons(local_cons);
                 rs = consultaCTR.consultarConsulta(consultaDTO);
                 while(rs.next()){
                     modelo_jtl_consultar_consulta.addRow(new Object[]{
                         rs.getString("id_cons"),
                         rs.getString ("local_cons"),
                     });
                 }
             }catch(Exception erTab){
                 System.out.println("erro no SQL: "+erTab);
             }finally{
                 consultaCTR.CloseDB();
             }
         }// fecha tabela
         
         private void preencheCampos(int id_cons){
             try{
                 consultaDTO.setId_cons(id_cons);
                 rs = consultaCTR.consultarConsulta(consultaDTO);
                 if(rs.next()){
                     limpaCampos();
                     
                     local_cons.setText(rs.getString("local_cons"));
                     hora_cons.setText(rs.getString("hora_cons"));
                     numero_cons.setText(rs.getString("numero_cons"));
                     
                     gravar_alterar =2;
                     liberaCampos(true);
                 }
             }catch(Exception erTab){
                 System.out.println("erro no SQL: "+erTab);
             }finally{
                 consultaCTR.CloseDB();
             }
         }// fecha campo
    
    /**
     * Creates new form ConsultaVIEW
     */
    public ConsultaVIEW() {
        initComponents();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_consulta = (DefaultTableModel) jtl_consultar_consulta.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        local_cons = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        hora_cons = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numero_cons = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pesquisa_consulta = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_consulta = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Cadastrar Consulta");

        jLabel2.setText("Local da Consulta:");

        jLabel3.setText("Hora da consulta:");

        jLabel4.setText("Telefone:");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Pesquisar");

        jLabel6.setText("Local:");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.setText("OK");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jtl_consultar_consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Local"
            }
        ));
        jtl_consultar_consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_consultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtl_consultar_consulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(local_cons, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pesquisa_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSair))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(hora_cons, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(numero_cons, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(201, 201, 201))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(local_cons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(pesquisa_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(hora_cons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(numero_cons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar)
                            .addComponent(btnExcluir)
                            .addComponent(btnSair)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaBotoes(false, true, true, false, true);
        liberaCampos(true);
        gravar_alterar = 1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        preencheTabela(pesquisa_consulta.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       if(gravar_alterar == 1){
           gravar();
           gravar_alterar = 0;
       }
       else{
           if(gravar_alterar == 2){
               alterar();
               gravar_alterar = 0;
           }
             else{
               JOptionPane.showMessageDialog(null, "Erro no sistema!");
               }
       }
       
       limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
       
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jtl_consultar_consultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_consultaMouseClicked
        preencheCampos((Integer.parseInt(String.valueOf(
            jtl_consultar_consulta.getValueAt(
              jtl_consultar_consulta.getSelectedRow(),0)))));
        liberaBotoes(false, true, true, true, true);
        
    }//GEN-LAST:event_jtl_consultar_consultaMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       excluir();
       limpaCampos();
       liberaCampos(false);
       liberaBotoes(true, false, false, false, true);
       modelo_jtl_consultar_consulta.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_consulta.setNumRows(0);
        liberaBotoes(true, false, false, false, true);
        gravar_alterar = 0;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField hora_cons;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtl_consultar_consulta;
    private javax.swing.JTextField local_cons;
    private javax.swing.JTextField numero_cons;
    private javax.swing.JTextField pesquisa_consulta;
    // End of variables declaration//GEN-END:variables
}
