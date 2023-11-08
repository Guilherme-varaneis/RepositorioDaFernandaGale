/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalho_2.ctr;
import br.com.trabalho_2.dto.MedicoDTO;
import br.com.trabalho_2.dao.MedicoDAO;
import br.com.trabalho_2.dao.ConexaoDAO;
import java.sql.ResultSet;
/**
 *
 * @author ferna
 */
public class MedicoCTR {
    
    MedicoDAO medicoDAO = new MedicoDAO();
    
    public MedicoCTR(){
    }
    
     public String inserirMedico(MedicoDTO medicoDTO){
         try{
             if(medicoDAO.inserirMedico(medicoDTO)){
                 return "Medico Cadastrado com sucesso!";
             }else {
                 return "Medico NÃO cadastrado!";
             }
         }
         catch (Exception e) {
             System.out.println(e.getMessage());
             return " Medico não cadastrado!";
         }
     }//fecha inserir
     
     
     public String alterarMedico(MedicoDTO medicoDTO){
         try{
             if(medicoDAO.alterarMedico(medicoDTO)){
                 return "Medico Alterado com sucesso!";
             }else{
                 return "Medico NÃO Alterado";
             }
         }
         catch(Exception e){
             System.out.println(e.getMessage());
             return "Medico NÃO alterado!";
         }
     }//fecha alterar
     
     
     public String excluirMedico(MedicoDTO medicoDTO){
        try{
            if(medicoDAO.excluirMedico(medicoDTO))
                return "Medico excluido com sucesso!";
            else
                return "Medico NÃO excluido!";
        }catch(Exception e){
            System.out.print(e.getMessage());
            return "Medico NÃO excluido!";
        }
    }//fecha excluir
     
     
    public ResultSet consultarMedico(MedicoDTO medicoDTO, int opcao){
        ResultSet rs = null;
        rs = medicoDAO.consultarMedico(medicoDTO, opcao);
        return rs;
    }//fecha consultar
    
     public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}


