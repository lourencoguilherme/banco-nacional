package com.gml.banco.dto;

import com.gml.banco.entities.enums.TipoConta;

import java.io.Serializable;
import java.util.Objects;

public class ContaResponseDto implements Serializable {
    private static final long serialVersionUID =1L;

    private Long contaId;

    private String banco;

    private String agencia;

    private String conta;

    private String digito;

    private TipoConta tipoConta;

    private Long usuarioId;

    private String nome;

    private String razaoSocial;

    public ContaResponseDto() {
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaResponseDto that = (ContaResponseDto) o;
        return contaId.equals(that.contaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contaId);
    }
}
