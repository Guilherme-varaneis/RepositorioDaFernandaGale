/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalho_2.dao;
import java.sql.*;
import br.com.trabalho_2.dto.MedicoDTO;
import java.text.SimpleDateFormat;
/**
 *
 * @author ferna
 */
public class MedicoDAO {
    
        public MedicoDAO(){
        }
        
        SimpleDateFormat data_format =  new SimpleDateFormat("dd/mm/yyyy");
        
        private ResultSet rs = null;
        private Statement stmt = null;
        
        
        public boolean inserirMedico(MedicoDTO medicoDTO){
            try{
                ConexaoDAO.ConnectDB();
                stmt = ConexaoDAO.con.createStatement();
                
                String comando = "Inserir into medico(nome_med, especi_med, via_med,"
                        + " data_emis_med, crm_med) velues ("
                        + "'"+medicoDTO.getNome_med()+ "',"
                        + "'"+medicoDTO.getEspeci_med()+ "',"
                        + "'"+medicoDTO.getVia_med()+ "',"
                        + "'"+medicoDTO.getCrm_med()+ "',"
                        + "to_date('"+data_format.format(medicoDTO.getData_emis_med())+"','dd/mm/yyyy)) ";
                
                    stmt.execute(comando.toUpperCase());
                    ConexaoDAO.con.commit();
                    stmt.close();
                    return true;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                return false;
            }
            finally{
                ConexaoDAO.CloseDB();
            }
        }
        
        
        public boolean alterarMedico(MedicoDTO medicoDTO){
            try{
                    ConexaoDAO.ConnectDB();
                    stmt = ConexaoDAO.con.createStatement();
                
                        String comando = "Update medico set"
                         +"nome_med = '"+ medicoDTO.getNome_med()+ " ',"
                         +"especi_med = '" +medicoDTO.getEspeci_med()+ " ',"
                         +"via_med = '" +medicoDTO.getVia_med()+ " ',"
                         +"crm_med = '"+medicoDTO.getCrm_med()+ "' ,"
                         +"data_emis_med = to date('" + data_format.format(medicoDTO.getData_emis_med())+ "','dd/mm/yyyy')"
                         +"where id_med = " + medicoDTO.getId_med();
                        
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
        }
        
        public boolean excluirMedico(MedicoDTO medicoDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Delete from medico where id_med = "+
                    medicoDTO.getId_med();
            
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
        
        
        public ResultSet consultarMedico(MedicoDTO medicoDTO, int opcao){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
        
            String comando = "";
            
            switch (opcao){
                case 1:
                    comando = "Select f.id_med, f.nome_med" +
                              "from medico f"+
                              "where f.nome_med ilike'" + medicoDTO.getNome_med()+ "%' "+
                              "order by f.nome_med";
                    break;
                case 2:
                    comando = "Select f.nome_med, f.cmr_med, f.via_med" +
                              "to_char(f.data_emis_med, 'dd/mm/yyyy') as data_emis_med"+
                              "from medico f"+
                              "where f.id_med = "+medicoDTO.getId_med();
                    break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            return rs;
        }
    }//fecha consultar medico
}
