/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.agendadigital.dao;

import java.sql.*;

/**
 *
 * @author allan
 */
public class ConexaoDAO1 {
    
    public static Connection con = null;
    
    public ConexaoDAO1() {
        
    }
    public static Connection ConnectDBRels(){
        ConnectDB();
        return con;
    }
    
    public static void ConnectDB() {
        try {
            String dsn = "agendaDigital";
            String user = "postgres";
            String senha = "postdba";
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url = "jdbc:postgresql://localhost:5432/" + dsn;
            
            con = DriverManager.getConnection(url, user, senha);
            
            con.setAutoCommit(false);
            if (con == null) {
                System.out.println("erro ao abrir o banco");
            }
            
        }
        catch (Exception e) {
            System.out.println("Problema ao abrir a base de dados! " + e.getMessage());
        }
    }
    
    public static void CloseDB() {
        try {
            con.close();
        }
        catch (Exception e) {
            System.out.println("Problema ao fechar a base de dados! " +
                    e.getMessage());
        }
    }
    
}
