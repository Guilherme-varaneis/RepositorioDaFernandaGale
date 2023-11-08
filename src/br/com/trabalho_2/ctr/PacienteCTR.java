/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalho_2.ctr;
import br.com.trabalho_2.dto.MedicoDTO;
import br.com.trabalho_2.dao.PacienteDAO;
import br.com.trabalho_2.dao.ConexaoDAO;
import br.com.trabalho_2.dto.PacienteDTO;
import java.sql.ResultSet;
/**
 *
 * @author ferna
 */
public class PacienteCTR {
    
    PacienteDAO pacienteDAO = new PacienteDAO();
    
     public PacienteCTR(){  
    }
     
     public String inserirPaciente(PacienteDTO pacienteDTO, MedicoDTO medicoDTO){
         try{
             if(pacienteDTO.inserirPaciente(pacienteDTO, medicoDTO)){
                 return "Paciente cadastrado com sucesso!";
             } else{ 
                 return "Paciente NÃO cadastrado!";
             }    
      } catch(Exception e){
          System.out.println(e.getMessage());
          return "Paciente NÃO cadastrado";
        }
     }//fecha inserir
     
     
     public String alterarPaciente (PacienteDTO pacienteDTO, MedicoDTO medicoDTO){
         try{
             if(pacienteDAO.alterarPaciente(pacienteDTO, medicoDTO)){
                 return "Paciente alterado com sucesso!";
             } else{
                 return "Paciente NÃO alterado!";
             }
         } catch(Exception e){
             System.out.println(e.getMessage());
             return "Paciente NÃO alterado!";
         }
     }//fecha alterar
     
     public String excluirPaciente(PacienteDTO pacienteDTO){
         try{
             if (pacienteDAO.excluirPaciente(pacienteDTO)){
                 return "Paciente excluirdo com sucesso!";
             }else{
                 return "Paciente NÃO excluido!";
             }
         } catch(Exception e){
             System.out.println(e.getMessage());
             return "Paciente NÃO excluido!";
             }
         }//fecha excluir
     
     public ResultSet consultarPaciente(PacienteDTO pacienteDTO, int opcao){
            ResultSet rs = null;
            rs = pacienteDAO.consultarPaciente(pacienteDTO, opcao);
            return rs;
         }
     
     public void CloseDB(){
         ConexaoDAO.CloseDB();
         }
     }

