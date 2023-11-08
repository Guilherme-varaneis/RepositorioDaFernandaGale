/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalho_2.dto;
import java.util.Date;
/**
 *
 * @author ferna
 */
public class MedicoDTO {
    private int id_med;
    private String nome_med, especi_med, via_med, crm_med;
    private Date data_emis_med;

    public int getId_med() {
        return id_med;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }

    public String getCrm_med() {
        return crm_med;
    }

    public void setCrm_med(String crm_med) {
        this.crm_med = crm_med;
    }

    public String getNome_med() {
        return nome_med;
    }

    public void setNome_med(String nome_med) {
        this.nome_med = nome_med;
    }

    public String getEspeci_med() {
        return especi_med;
    }

    public void setEspeci_med(String especi_med) {
        this.especi_med = especi_med;
    }

    public String getVia_med() {
        return via_med;
    }

    public void setVia_med(String via_med) {
        this.via_med = via_med;
    }

    public Date getData_emis_med() {
        return data_emis_med;
    }

    public void setData_emis_med(Date data_emis_med) {
        this.data_emis_med = data_emis_med;
    }
	
    
    
}
