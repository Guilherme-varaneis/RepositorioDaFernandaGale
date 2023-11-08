/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalho_2.ctr;
import java.sql.ResultSet;
import br.com.trabalho_2.dto.ConsultaDTO;
import br.com.trabalho_2.dao.ConsultaDAO;
import br.com.trabalho_2.dao.ConexaoDAO;


/**
 *
 * @author ferna
 */
public class ConsultaCTR {

    ConsultaDAO consultaDAO = new ConsultaDAO();
    
    
    public ConsultaCTR(){
    }
    
    public String inserirConcsulta(ConsultaDTO consultaDTO){
        try{
            if(consultaDAO.inserirConsulta(consultaDTO)){
                return "Conculta Cadastrada!";
            }else{
                return "Consulta NÃO cadastrada!";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Consulta NÃO cadastrada!";
        }
    }//fecha inserir
    
     public String alterarConsulta(ConsultaDTO consultaDTO){
         try{
             if(consultaDAO.alterarConsulta(consultaDTO)){
                 return "Consulta cadastrada!";
             }else{
                 return "consulta NÃO cadastrada!";
             }
         }catch(Exception e){
             System.out.println(e.getMessage());
             return "Consulta NÃO cadastrada!";
         }
     }// fecha alterar
     
     public String excluirConsulta(ConsultaDTO consultaDTO){
         try{
             if(consultaDAO.excluirConsulta(consultaDTO)){
                 return "Consulta excluida!";
             }else{
                 return "consulta NÃO excluida!";
             }
         }catch(Exception e){
             System.out.println(e.getMessage());
             return "Consulta NÃO excluida!";
         }
     }// fecha excluir
     
     public ResultSet consultarConsulta(ConsultaDTO consultaDTO){
         ResultSet rs = null;
         int opcao = 0;
        rs = consultaDAO.consultarConsulta(consultaDTO,opcao);
        return rs;
         
     }// fecha consultar
     
     public void CloseDB(){
         ConexaoDAO.CloseDB();
     }
}
