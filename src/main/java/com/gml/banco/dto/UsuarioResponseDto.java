package com.gml.banco.dto;

import java.io.Serializable;

public class UsuarioResponseDto implements Serializable {
    private static final long serialVersionUID =1L;

    private Long usuarioId;
    private String nome;

    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(Long usuarioId, String nome) {
        this.usuarioId = usuarioId;
        this.nome = nome;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
