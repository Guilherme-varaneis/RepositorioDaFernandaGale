/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalho_2.dto;

/**
 *
 * @author ferna
 */
public class PacienteDTO {
     private String nome_pac, idade_pac, cpf_pac,altura_pac,peso_pac,sexo_pac;
    private int tel_pac, id_pac;

    public String getNome_pac() {
        return nome_pac;
    }

    public void setNome_pac(String nome_pac) {
        this.nome_pac = nome_pac;
    }

    public String getIdade_pac() {
        return idade_pac;
    }

    public void setIdade_pac(String idade_pac) {
        this.idade_pac = idade_pac;
    }

    public String getCpf_pac() {
        return cpf_pac;
    }

    public void setCpf_pac(String cpf_pac) {
        this.cpf_pac = cpf_pac;
    }

    public String getAltura_pac() {
        return altura_pac;
    }

    public void setAltura_pac(String altura_pac) {
        this.altura_pac = altura_pac;
    }

    public String getPeso_pac() {
        return peso_pac;
    }

    public void setPeso_pac(String peso_pac) {
        this.peso_pac = peso_pac;
    }

    public String getSexo_pac() {
        return sexo_pac;
    }

    public void setSexo_pac(String sexo_pac) {
        this.sexo_pac = sexo_pac;
    }

    public int getTel_pac() {
        return tel_pac;
    }

    public void setTel_pac(int tel_pac) {
        this.tel_pac = tel_pac;
    }

    public int getId_pac() {
        return id_pac;
    }

    public void setId_pac(int id_pac) {
        this.id_pac = id_pac;
    }

    public boolean inserirPaciente(PacienteDTO pacienteDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String geIdade_pac() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getAltura_pc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean inserirPaciente(PacienteDTO pacienteDTO, MedicoDTO medicoDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}


