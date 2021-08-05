package com.gml.banco.dto;

import java.io.Serializable;

public class UsuarioUpdateDto implements Serializable {
    private static final long serialVersionUID =1L;

    private String nome;
    private String senha;

    public UsuarioUpdateDto() {
    }

    public UsuarioUpdateDto(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
