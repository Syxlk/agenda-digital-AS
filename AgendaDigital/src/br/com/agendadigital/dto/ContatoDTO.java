/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.agendadigital.dto;

public class ContatoDTO {
    private String nome_cont, tel_cont, email_cont;
    private int id_cont;

    public int getId_cont() {
        return id_cont;
    }

    public void setId_cont(int id_cont) {
        this.id_cont = id_cont;
    }

    public String getNome_cont() {
        return nome_cont;
    }

    public void setNome_cont(String nome_cont) {
        this.nome_cont = nome_cont;
    }

    public String getTel_cont() {
        return tel_cont;
    }

    public void setTel_cont(String tel_cont) {
        this.tel_cont = tel_cont;
    }

    public String getEmail_cont() {
        return email_cont;
    }

    public void setEmail_cont(String email_cont) {
        this.email_cont = email_cont;
    }
}
