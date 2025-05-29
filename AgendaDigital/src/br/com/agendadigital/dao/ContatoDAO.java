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
    
    public ResultSet bucarContato(ContatoDTO contatoDTO, int opcao) {
        try {
            ConexaoDAO1.ConnectDB();
            
            stmt = ConexaoDAO1.con.createStatement();
            String comando = "";
            
            switch (opcao) {
                case 1:
                    comando = "Select c.*"+
                            "from contato c "+
                            "where nome_cont like '" + contatoDTO.getNome_cont()+ "%' " +
                            "order by c.nome_cont";
                    
                break;
                case 2:
                    comando = "Select c.* "+
                            "from contato c " +
                            "where c.id_cont = " + contatoDTO.getId_cont();
                    
                break;
                case 3:
                    comando = "Select c.id_cont, c.nome_cont "+
                            "from cont c ";
                    
                break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    
}
