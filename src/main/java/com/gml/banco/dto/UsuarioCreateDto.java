package com.gml.banco.dto;

import java.io.Serializable;

public class UsuarioCreateDto implements Serializable {
    private static final long serialVersionUID =1L;

    private String nome;
    private String razaoSocial;
    private String Senha;

    public UsuarioCreateDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
