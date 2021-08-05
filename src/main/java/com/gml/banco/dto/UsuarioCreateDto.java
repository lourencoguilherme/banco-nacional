package com.gml.banco.dto;

import javax.validation.constraints.NotNull;

import java.io.Serializable;

public class UsuarioCreateDto implements Serializable {
    private static final long serialVersionUID =1L;

    @NotNull
    private String nome;
    private String razaoSocial;
    private String Senha;

    public UsuarioCreateDto() {
    }

    public UsuarioCreateDto(String nome, String razaoSocial, String senha) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        Senha = senha;
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
