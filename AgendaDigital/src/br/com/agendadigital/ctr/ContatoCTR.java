/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.agendadigital.ctr;

import br.com.agendadigital.dao.ContatoDAO;
import br.com.agendadigital.dto.ContatoDTO;
import br.com.agendadigital.dao.ConexaoDAO1;
import java.sql.ResultSet;


public class ContatoCTR {
    ContatoDAO contatoDAO = new ContatoDAO();
        
    public ContatoCTR() {}
    
    
    public void CloseDB() {
        ConexaoDAO1.CloseDB();
    }

    
    
    
    
}
