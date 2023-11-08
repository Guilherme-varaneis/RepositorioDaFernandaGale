/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.trabalho_2.view;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.trabalho_2.dto.MedicoDTO;
import br.com.trabalho_2.ctr.MedicoCTR;
import java.text.SimpleDateFormat;
/**
 *
 * @author ferna
 */
public class MedicoVIEW extends javax.swing.JInternalFrame {
     SimpleDateFormat data_format = new SimpleDateFormat("dd/mm/yyyy");
   
     MedicoDTO medicoDTO = new MedicoDTO();
     MedicoCTR medicoCTR =  new MedicoCTR();
        
        int gravar_alterar;
        ResultSet rs;
        DefaultTableModel modelo_jtl_consultar_medico;
    private Object data_emis_med;
        
        
        public void setPosicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width)/2, (d.height - this.getSize().height)/2);
       }
    
        
    public MedicoVIEW() {
        initComponents();
        
        liberaCampos(false);
        liberaBotoes(true,false,false,false,true);
        modelo_jtl_consultar_medico = (DefaultTableModel) jtl_consultar_medico.getModel();
    }

   
        private void gravar(){
        try{
            medicoDTO.setNome_med(nome_med.getText());
            medicoDTO.setCrm_med(crm_med.getText());
            medicoDTO.setEspeci_med(especi_med.getText());
            medicoDTO.setVia_med(via_med.getText());
           
            
            JOptionPane.showMessageDialog(null, medicoCTR.inserirMedico(medicoDTO));
        }
        catch (Exception e) {
            System.out.println("Erro ao gravar" + e.getMessage());
        }      
    }//gravar
        
        
         private void alterar(){
        try{
            medicoDTO.setNome_med(nome_med.getText());
            medicoDTO.setCrm_med(crm_med.getText());
            medicoDTO.setEspeci_med(especi_med.getText());
            medicoDTO.setVia_med(via_med.getText());
            
            
            
            JOptionPane.showMessageDialog(null, medicoCTR.alterarMedico(medicoDTO));
        }catch(Exception e){
            System.out.print("Erro ao alterar: " + e.getMessage());
        }
    }//fecha alterar
         
        private void excluir(){
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?","AVISO",
                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,medicoCTR.excluirMedico(medicoDTO));
        }
    }
        
    private void liberaCampos(boolean a){
    nome_med.setEnabled(a);
    crm_med.setEnabled(a);
    especi_med.setEnabled(a);
    via_med.setEnabled(a);
}//libera campos
    
     private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e){
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }//libera botoes
     
     private void limpaCampos(){
    nome_med.setText("");
    crm_med.setText("");
    especi_med.setText("");
    via_med.setText("");
   
    }//limpa campos
     
     
     
    private void preencheTabela(String nome_med){
        try{
            modelo_jtl_consultar_medico.setNumRows(0);
            
           medicoDTO.setNome_med(nome_med);
            rs = medicoCTR.consultarMedico(medicoDTO, 1);
            while(rs.next()){
                modelo_jtl_consultar_medico.addRow(new Object[]{
                   rs.getString("id_pac"),
                    rs.getString("nome_med"),
                });      
            } 
        }
        
        catch(Exception e){
            System.out.println("Erro SQL:"+e);
        }
        finally{
            medicoCTR.CloseDB();
        }
    }//fevha tabela
    
    
      private void preencheCampos(int id_medico){
        try{
            medicoDTO.setId_med(id_medico);
            rs = medicoCTR.consultarMedico(medicoDTO, 2);
            if (rs.next()){
                limpaCampos();
                
                nome_med.setText(rs.getString("nome_med"));
                crm_med.setText(rs.getString("crm_med"));
                especi_med.setText(rs.getString("especi_med"));
                via_med.setText(rs.getString("via_med"));
               
                
                gravar_alterar = 2;
                liberaCampos(true);
            }
        }
        catch (Exception erTab){
            System.out.println("Erro SQL: "+erTab);
        }
        finally{
           medicoCTR.CloseDB();
        }
 
    }//fecha preencher
    
        
        
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nome_med = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        crm_med = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        especi_med = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        via_med = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pesquisa_nome_med = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_medico = new javax.swing.JTable();

        jLabel1.setText("Nome:");

        jLabel2.setText("CRM:");

        jLabel3.setText("Especialidade:");

        jLabel4.setText("Via da carteira:");

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Cadastro");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Consultar");

        jLabel8.setText("Nome:");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.setText("OK");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jtl_consultar_medico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ));
        jtl_consultar_medico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_medicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtl_consultar_medico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(crm_med, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nome_med, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(especi_med, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addGap(21, 21, 21)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(via_med, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pesquisa_nome_med, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(234, 234, 234))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(nome_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(pesquisa_nome_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(crm_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(especi_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(via_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar)
                            .addComponent(btnExcluir)
                            .addComponent(btnSair))
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
       liberaBotoes(false,true,true,false,true);
       gravar_alterar = 1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

            if (gravar_alterar == 1){
           gravar();
           gravar_alterar = 0; 
       }
       else{
           if(gravar_alterar == 2){
               gravar_alterar = 0;
           }
            else{
               JOptionPane.showMessageDialog(null,"Erro no Sistema!");
               }
       }
    
       limpaCampos();
       liberaCampos(false);
       liberaBotoes(true,false,false,false,true);
                                                                          
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       preencheTabela(pesquisa_nome_med.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jtl_consultar_medicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_medicoMouseClicked
       preencheCampos (Integer.parseInt(String.valueOf(
        jtl_consultar_medico.getValueAt(
        jtl_consultar_medico.getSelectedRow(),0))));
        liberaBotoes(false,true,true,true,true);
    }//GEN-LAST:event_jtl_consultar_medicoMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true,false,false,false,true);
        modelo_jtl_consultar_medico.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       limpaCampos();
       liberaCampos(false);
       modelo_jtl_consultar_medico.setNumRows(0);
       liberaBotoes(true, false,false,false,true);
       gravar_alterar=0;
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
    private javax.swing.JTextField crm_med;
    private javax.swing.JTextField especi_med;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtl_consultar_medico;
    private javax.swing.JTextField nome_med;
    private javax.swing.JTextField pesquisa_nome_med;
    private javax.swing.JTextField via_med;
    // End of variables declaration//GEN-END:variables
}
