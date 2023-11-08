/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalho_2.dao;
import br.com.trabalho_2.dto.MedicoDTO;
import java.sql.*;
import br.com.trabalho_2.dto.PacienteDTO;
/**
 *
 * @author ferna
 */
public class PacienteDAO {
    
    public PacienteDAO(){
    }
    
   private ResultSet rs = null;
   private Statement stmt = null;
   
   
   
   public boolean inserirPaciente(PacienteDTO pacienteDTO){
       try{
           ConexaoDAO.ConnectDB();
           stmt = ConexaoDAO.con.createStatement();
           
           String comando = "Update cliente set "
                    + "nome_pac = '"+ pacienteDTO.getNome_pac()+"' ,"
                    + "idade_pac = '"+ pacienteDTO.getIdade_pac()+"' ,"
                    + "Tel_cli = "+ pacienteDTO.getTel_pac()+","
                    + "cpf_pac = '"+ pacienteDTO.getCpf_pac()+"' ,"
                    + "altura_pac = '"+ pacienteDTO.getAltura_pac()+"' ,"
                    + "peso_pac = '"+ pacienteDTO.getPeso_pac()+"' ,"
                    + "where id_pac = "+ pacienteDTO.getId_pac();
           
           stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            
            stmt.close();
            return true;       
       }
       catch (Exception e){
           System.out.println(e.getMessage());
           return false;
       }
       finally {
           ConexaoDAO.CloseDB();
       }
   }//inserir paciente
   
   
   public ResultSet consultarPaciente(PacienteDTO pacienteDTO, int opcao){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
        
            String comando = "";
            
            switch (opcao){
                case 1:
                    comando = "Select p.*" +
                            "froom paciente p"+
                            "where p.nome_pac ilike '" + pacienteDTO.getNome_pac()+ "%'" +
                            "order by p.nome_pac";
                    break;
                case 2:
                    comando = "Select p.*, from nome_pac, f.id_pac = " + 
                              "from paciente p, paciente f"+
                              "where p.id_pac = f.id_pac and"+
                              "p.id_pac = "+ pacienteDTO.getId_pac();
                    break; 
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            return rs;
        }
    }//fecha consultar paciente
   
   
    public boolean alterarPaciente(PacienteDTO pacienteDTO){
        try{
            //chama o metodo que esta na classe conexao p abrir
            ConexaoDAO.ConnectDB();
            //cria o Statemente q responsavel por executar alguma alteração
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = pacienteDTO.geIdade_pac()+ "Update cliente set "
                    + "nome_pac = '"+ pacienteDTO.getNome_pac()+"' ,"
                    + "idade_pac = '"+"' ,"
                    + "tel_pac= "+ pacienteDTO.getTel_pac()+","
                    + "cpf_pac = '"+ pacienteDTO.getCpf_pac()+"' ,"
                    + "sexo_pac = '"+ pacienteDTO.getSexo_pac()+"' ,"
                    + "peso_pac = '"+ pacienteDTO.getPeso_pac()+"' ,"
                    + "altura_pac= '"+ pacienteDTO.getAltura_pc();
                    
            stmt.execute(comando.toUpperCase());
            
            ConexaoDAO.con.commit();
            
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            ConexaoDAO.CloseDB();
        }
    }//altera paciente
    
    
       public boolean excluirPaciente(PacienteDTO pacienteDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Delete from paciente where id_pac = "+
                    pacienteDTO.getId_pac();
            
            stmt.execute(comando);
            
            ConexaoDAO.con.commit();;
            stmt.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            ConexaoDAO.CloseDB();
        }
    }//fecha excluir

    public boolean alterarPaciente(PacienteDTO pacienteDTO, MedicoDTO medicoDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
