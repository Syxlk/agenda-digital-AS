package br.com.agendadigital.dao;

import br.com.agendadigital.dto.ContatoDTO;
import java.sql.ResultSet;
import java.sql.*;



public class ContatoDAO {
    
    
    public ContatoDAO() {}
 
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirContato(ContatoDTO contatoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para brir o banco de dados
            ConexaoDAO1.ConnectDB();
            //Instancia o statment que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO1.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into contato (nome_cont,tel_cont,email_cont) values ( " 
                    + "'" + contatoDTO.getNome_cont() + "', " 
                    + "'" + contatoDTO.getTel_cont() + "', "
                    + "'" + contatoDTO.getEmail_cont()+ "') "; 
            
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO1.con.commit();
            //Fecha o Statement
            stmt.close();
            return true;
        }
         //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que está acontecendo.
         catch (Exception e) {
             System.out.println(e.getMessage());
             return false;
         }
        finally {
            //Chama o metodo da classe conexaoDAO para fechar o banco de dados.
            ConexaoDAO1.CloseDB();
        }
    }
    
    
}
