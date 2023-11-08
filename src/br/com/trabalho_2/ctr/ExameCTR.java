/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalho_2.ctr;
import br.com.trabalho_2.dao.ConexaoDAO;
import br.com.trabalho_2.dao.ExameDAO;
import br.com.trabalho_2.dto.ExameDTO;
import br.com.trabalho_2.dto.ConsultaDTO;
import javax.swing.JTable;
        
        
/**
 *
 * @author ferna
 */
public class ExameCTR {

     ExameDAO exameDAO = new ExameDAO();
    
    public ExameCTR(){
    }
    
    public String inserirExame(ExameDTO exameDTO,ConsultaDTO consultaDTO, JTable exame){
        try{
            if(exameDAO.inserirExame(exameDTO, consultaDTO, exame)){
                return "Exame cadastrado com sucesso!";
            } else{
                return "Exame NÃO cadastrado!";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Exame NÃO cadastrado!";
        }
    }//fecha inserir
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
