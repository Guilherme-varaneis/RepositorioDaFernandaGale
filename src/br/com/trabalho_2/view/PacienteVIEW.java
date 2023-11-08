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
import br.com.trabalho_2.dto.PacienteDTO;
import br.com.trabalho_2.ctr.PacienteCTR;

/**
 *
 * @author ferna
 */
public class PacienteVIEW extends javax.swing.JInternalFrame {
    MedicoDTO medicoDTO = new MedicoDTO();
    MedicoCTR medicoCTR = new MedicoCTR();
    PacienteDTO pacienteDTO = new PacienteDTO();
    PacienteCTR pacienteCTR = new PacienteCTR();
    
    int gravar_alterar;
    
    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_paciente;
    DefaultTableModel modelo_jtl_consultar_medico;
    
    public void setPosicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width)/2, (d.height - this.getSize().height)/2);
    }//fecha set posicao
    
    private void gravar(){
        try{
            pacienteDTO.setNome_pac(nome_pac.getText());
            pacienteDTO.setId_pac(Integer.parseInt(idade_pac.getText()));
            pacienteDTO.setCpf_pac(cpf_pac.getText());
            pacienteDTO.setAltura_pac(altura_pac.getText());
            pacienteDTO.setPeso_pac(peso_pac.getText());
            pacienteDTO.setSexo_pac(sexo_pac.getText());
            medicoDTO.setId_med(Integer.parseInt(String.valueOf(
                        jtl_consultar_medico.getValueAt(
                          jtl_consultar_medico.getSelectedRow(),0))));
                    JOptionPane.showMessageDialog(null, pacienteCTR.inserirPaciente(pacienteDTO, medicoDTO));
                        
        } catch(Exception e){
            System.out.println("Erro ao gravar"+e.getMessage());
        }
    }//fecha gravar
    
    private void alterar(){
        try {
                 pacienteDTO.setNome_pac(nome_pac.getText());
                 pacienteDTO.setId_pac(Integer.parseInt(idade_pac.getText()));
                 pacienteDTO.setCpf_pac(cpf_pac.getText());
                 pacienteDTO.setAltura_pac(altura_pac.getText());
                 pacienteDTO.setPeso_pac(peso_pac.getText());
                 pacienteDTO.setSexo_pac(sexo_pac.getText());
                 medicoDTO.setId_med(Integer.parseInt(String.valueOf(
                    jtl_consultar_medico.getValueAt(
                       jtl_consultar_medico.getSelectedRow(), 0 ))));
                        
        } catch(Exception e){
            System.out.println("Erro ao alterar"+e.getMessage());
        }
    }//fecha alterar
    
    
    private void escluir(){
        if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir?", "Aviso",
                 JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                          JOptionPane.showMessageDialog(null, pacienteCTR.excluirPaciente(pacienteDTO));
        }
    }//fecha excluir
    
    private void liberaCampos(boolean a){
        nome_pac.setEnabled(a);
        idade_pac.setEnabled(a);
   	cpf_pac.setEnabled(a);
    	altura_pac.setEnabled(a);
   	peso_pac.setEnabled(a);
        sexo_pac.setEnabled(a);
        pesquisa_nome_med.setEnabled(a);
        btnPesquisarMedico.setEnabled(a);
        jtl_consultar_medico.setEnabled(a);
    }//fecha libera campos
    
    private void liberaBotoes(boolean a,boolean b,boolean c,boolean d,boolean e){
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }//fecha libera botoes
    
     private void limpaCampos(){
        nome_pac.setText("");
        idade_pac.setText("");
   	cpf_pac.setText("");
    	altura_pac.setText("");
   	peso_pac.setText("");
        sexo_pac.setText("");
        pesquisa_nome_med.setText("");
        modelo_jtl_consultar_medico.setNumRows(0);
    }//fecha limpa campos
    
    private void preencheTabelaPaciente(String nome_pac){
        try{
            modelo_jtl_consultar_paciente.setNumRows(0);
            pacienteDTO.setNome_pac(nome_pac);
            rs = pacienteCTR.consultarPaciente(pacienteDTO, 1);
            while(rs.next()){
                modelo_jtl_consultar_paciente.addRow(new Object[]{
                    rs.getString("id_pac"),
                     rs.getString("nome_pac"),
                });
            }
        } catch(Exception erTab){
                System.out.println("Erro SQL: "+erTab);
        }finally{
            pacienteCTR.CloseDB();
        }
    }//fecha tabela paciente
    
    private void preencheCamposPaciente(int id_pac){
        try{
            pacienteDTO.setId_pac(id_pac);
            rs = pacienteCTR.consultarPaciente(pacienteDTO, 2);
            if(rs.next()){
                limpaCampos();
                
                nome_pac.setText(rs.getString("nome_pac"));
                idade_pac.setText(rs.getString("idade_pac"));
                cpf_pac.setText(rs.getString("cpf_pac"));
                altura_pac.setText(rs.getString("altura_pac"));
                peso_pac.setText(rs.getString("peso_pac"));
                sexo_pac.setText(rs.getString("sexo_pac"));
                
                modelo_jtl_consultar_medico.setNumRows(0);
                modelo_jtl_consultar_medico.addRow(new Object[]{rs.getInt("id_med"), rs.getString("nome_med"),});
                jtl_consultar_medico.setRowSelectionInterval(0, 0);
                
                gravar_alterar =2;
                liberaCampos(true);
            }
        }catch(Exception erTab){
            System.out.println("Erro no SQL: "+erTab);
        }finally{
            pacienteCTR.CloseDB();
        }
    }//fecha campos paciente
    
    private void preencheTabelaMedico(String nome_med){
        try{
            modelo_jtl_consultar_medico.setNumRows(0);
            medicoDTO.setNome_med(nome_med);
            rs = medicoCTR.consultarMedico(medicoDTO, 1);
            while(rs.next()){
                modelo_jtl_consultar_medico.addRow(new Object[]{
                    rs.getString("id_med"),
                    rs.getString("nome_med"),
                });
            }
        }catch(Exception erTab){
            System.out.println("Erro no SQL: "+ erTab);
        }finally{
            pacienteCTR.CloseDB();
        }
           
    }//fecha tabela medico
    
    
    
    /**
     * Creates new form PacienteVIEW
     */
    public PacienteVIEW() {
        initComponents();
        
        liberaCampos(false);
            
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_medico = (DefaultTableModel) jtl_consultar_medico.getModel();
        modelo_jtl_consultar_paciente = (DefaultTableModel) jtl_consultar_paciente.getModel();
        
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
        nome_pac = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        idade_pac = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cpf_pac = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        altura_pac = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        peso_pac = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        sexo_pac = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pesquisa_nome_med = new javax.swing.JTextField();
        btnPesquisarMedico = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_medico = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pesquisa_nome_paciente = new javax.swing.JTextField();
        btnPesquisarPaciente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_consultar_paciente = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Ficha de Paciente");

        jLabel2.setText("Nome:");

        jLabel3.setText("Idade:");

        jLabel4.setText("CPF:");

        jLabel5.setText("Altura:");

        jLabel6.setText("Peso:");

        jLabel7.setText("Sexo:");

        jLabel8.setText("Médico Responsável:");

        btnPesquisarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisarMedico.setText("OK");
        btnPesquisarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarMedicoActionPerformed(evt);
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
        jScrollPane1.setViewportView(jtl_consultar_medico);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/novo.png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/sair.png"))); // NOI18N
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Consulta");

        jLabel10.setText("Nome:");

        btnPesquisarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/trabalho_2/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisarPaciente.setText("OK");
        btnPesquisarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPacienteActionPerformed(evt);
            }
        });

        jtl_consultar_paciente.setModel(new javax.swing.table.DefaultTableModel(
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
        jtl_consultar_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_pacienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtl_consultar_paciente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pesquisa_nome_med, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnPesquisarMedico))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(126, 126, 126)
                                    .addComponent(jLabel1))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nome_pac, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(idade_pac, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cpf_pac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(altura_pac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(peso_pac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sexo_pac, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(163, 163, 163)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisa_nome_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarPaciente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome_pac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(cpf_pac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idade_pac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(pesquisa_nome_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(altura_pac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(peso_pac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(sexo_pac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesquisa_nome_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair)
                    .addComponent(btnNovo))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        gravar_alterar =1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquisarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarMedicoActionPerformed
        preencheTabelaMedico(pesquisa_nome_med.getText());
    }//GEN-LAST:event_btnPesquisarMedicoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       if(gravar_alterar == 1){
           gravar();
           gravar_alterar = 0;
       }
       else{
           if(gravar_alterar==2){
               alterar();
               gravar_alterar = 0;
           }
           else{
               JOptionPane.showMessageDialog(null, "Erro no Sistema!");
           }
       }
       limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
           
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPacienteActionPerformed
        preencheTabelaPaciente(pesquisa_nome_paciente.getText());
    }//GEN-LAST:event_btnPesquisarPacienteActionPerformed

    private void jtl_consultar_pacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_pacienteMouseClicked
        preencheCamposPaciente(Integer.parseInt(String.valueOf(
                   jtl_consultar_paciente.getValueAt(
                    jtl_consultar_paciente.getSelectedRow(),0))));
        liberaBotoes(false, true, true, true, true);
    }//GEN-LAST:event_jtl_consultar_pacienteMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       excluir();
       limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_paciente.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_paciente.setNumRows(0);
        liberaBotoes(true, false, false, false, true);
        gravar_alterar =0;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField altura_pac;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarMedico;
    private javax.swing.JButton btnPesquisarPaciente;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField cpf_pac;
    private javax.swing.JTextField idade_pac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtl_consultar_medico;
    private javax.swing.JTable jtl_consultar_paciente;
    private javax.swing.JTextField nome_pac;
    private javax.swing.JTextField peso_pac;
    private javax.swing.JTextField pesquisa_nome_med;
    private javax.swing.JTextField pesquisa_nome_paciente;
    private javax.swing.JTextField sexo_pac;
    // End of variables declaration//GEN-END:variables

    private void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
