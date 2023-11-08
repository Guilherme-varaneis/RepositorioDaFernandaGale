/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalho_2.dao;
import br.com.trabalho_2.dto.ConsultaDTO;
import br.com.trabalho_2.dto.ExameDTO;
import java.sql.*;
import javax.swing.JTable;
/**
 *
 * @author ferna
 */
public class ExameDAO {
    
    public ExameDAO(){    
    }
    
    private ResultSet rs = null;
    Statement stmt = null;
    Statement stmt1 = null;
    
    public boolean inserirExame(ExameDTO exameDTO, ConsultaDTO consultaDTO, JTable exame){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();
            
            String comando1 = "Inserir into Exame(dat_exame, hora_exame"
                    +"id_exame, descricao_exame) values ("
                    +exameDTO.getId_exame();
            
            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();
            
            for(int cont=0; cont<exame.getRowCount(); cont++){
                String comando2 = "Inserir into exame_pac(id_exame, id_paci,"
                        + "data_exame, hora_exame, descricao_exame) values("
                        + rs.getInt("id_exame")+","
                        +exame.getValueAt(cont, 0)+","
                        +exame.getValueAt(cont, 1)+","
                        +exame.getValueAt(cont, 3)+");";
                stmt1.execute(comando2);
            }
            ConexaoDAO.con.commit();
            stmt.close();;
            stmt1.close();
            rs.close();
            return true;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConexaoDAO.CloseDB();
        }
    }// fecha inserir
}


 
    
