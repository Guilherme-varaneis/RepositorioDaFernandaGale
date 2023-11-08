/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalho_2.dao;
import javax.sql.*;
import br.com.trabalho_2.dto.ConsultaDTO;
import java.sql.ResultSet;

/**
 *
 * @author ferna
 */
public class ConsultaDAO {
    
    public ConsultaDAO(){
    }
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    
   
    
    public boolean inserirConsulta(ConsultaDTO consultaDTO){
        try{    
            ConexaoDAO.ConnectDB();
            stmt= (Statement) ConexaoDAO.con.createStatement();
            
            String comando = "Inserir into consulta(local_cons, numero_cons, hora_cons) values("
                    + " ' " + consultaDTO.getLocal_cons()+ "',"
                    + " ' " + consultaDTO.getHora_cons()+"' ,"
                    +consultaDTO.getNumero_cons();
            stmt.execute(comando.toUpperCase());
            
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConexaoDAO.CloseDB();
        }
    }//fecha inserir
    
    public boolean alterarConsulta(ConsultaDTO consultaDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Update consulta set"
                    +"local_cons = '"+consultaDTO.getLocal_cons()+ "',"
                    +"numero_cons = '"+consultaDTO.getNumero_cons()+"',"
                    +"hora_cons = '"+consultaDTO.getHora_cons()+ "'"
                    +"where id_cons = "+consultaDTO.getId_cons();
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConexaoDAO.CloseDB();
        }
    }//fecha alterar
    
    
    public boolean excluirConsulta(ConsultaDTO consultaDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from cliente where id_cons = "
                    +consultaDTO.getId_cons();
                    stmt.execute(comando);
                     ConexaoDAO.con.commit();
                     stmt.close();
                    return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConexaoDAO.CloseDB();
        }
    }// fecha excluir
    
    
    public ResultSet consultarConsulta(ConsultaDTO consultaDTO, int opcao){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando =  "";
            
            switch (opcao){
                case 1:
                    comando = "Select c.*"+
                              "from consulta c "+
                              "where local_cons like '"+ consultaDTO.getLocal_cons()+"%' "+
                              "order by.clocal_cons";
                    break;
                    
                     case 2:
                    comando = "Select c.*"+
                              "from consulta c "+
                             "where  c.id_cons = "+ consultaDTO.getId_cons();
                    break;
                    
                     case 3:
                    comando = "Select c.*"+
                              "from consulta c "; 
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
}
