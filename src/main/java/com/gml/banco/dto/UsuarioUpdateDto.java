package com.gml.banco.dto;

import java.io.Serializable;

public class UsuarioUpdateDto implements Serializable {
    private static final long serialVersionUID =1L;

    private String nome;
    private String Senha;

    public UsuarioUpdateDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
