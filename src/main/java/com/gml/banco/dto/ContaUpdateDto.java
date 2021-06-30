package com.gml.banco.dto;

import com.gml.banco.entities.enums.TipoConta;

import java.io.Serializable;

public class ContaUpdateDto implements Serializable {
    private static final long serialVersionUID =1L;

    private TipoConta tipoConta;
    private Long usuarioId;

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
