package com.gml.banco.mapper;

import com.gml.banco.dto.*;
import com.gml.banco.entities.Conta;
import com.gml.banco.entities.Usuario;

public class ContaMapper {
    public static ContaResponseDto contaToContaResponseDto(Conta conta) {
        ContaResponseDto contaResponseDto = new ContaResponseDto();
        contaResponseDto.setContaId(conta.getContaId());
        contaResponseDto.setBanco(conta.getBanco());
        contaResponseDto.setAgencia(conta.getAgencia());
        contaResponseDto.setConta(conta.getConta());
        contaResponseDto.setDigito(conta.getDigito());
        contaResponseDto.setTipoConta(conta.getTipoConta());
        contaResponseDto.setUsuarioId(conta.getUsuario().getUsuarioId());
        contaResponseDto.setNome(conta.getUsuario().getNome());
        contaResponseDto.setRazaoSocial(conta.getUsuario().getRazaoSocial());

        return contaResponseDto;
    }
    public static Conta contaCreateDtoToConta(ContaCreateDto contaCreateDto) {
        Conta conta = new Conta();
        conta.setBanco(contaCreateDto.getBanco());
        conta.setAgencia(contaCreateDto.getAgencia());
        conta.setConta(contaCreateDto.getConta());
        conta.setDigito(contaCreateDto.getDigito());
        conta.setTipoConta(contaCreateDto.getTipoConta());

        Usuario usuario = new Usuario();
        usuario.setUsuarioId(contaCreateDto.getUsuarioId());
        conta.setUsuario(usuario);
        return conta;
    }
    public static Conta contaUpdateDtoToConta(ContaUpdateDto contaUpdateDto, Long contaId) {
        Conta conta = new Conta();
        conta.setContaId(contaId);
        conta.setTipoConta(contaUpdateDto.getTipoConta());

        Usuario usuario = new Usuario();
        usuario.setUsuarioId(contaUpdateDto.getUsuarioId());
        conta.setUsuario(usuario);
        return conta;
    }
}
