package com.gml.banco.mapper;

import com.gml.banco.dto.*;
import com.gml.banco.entities.ContaEntity;
import com.gml.banco.entities.UsuarioEntity;

public class ContaMapper {
    public static ContaResponseDto contaToContaResponseDto(ContaEntity contaEntity) {
        ContaResponseDto contaResponseDto = new ContaResponseDto();
        contaResponseDto.setContaId(contaEntity.getContaId());
        contaResponseDto.setBanco(contaEntity.getBanco());
        contaResponseDto.setAgencia(contaEntity.getAgencia());
        contaResponseDto.setConta(contaEntity.getConta());
        contaResponseDto.setDigito(contaEntity.getDigito());
        contaResponseDto.setTipoConta(contaEntity.getTipoConta());
        contaResponseDto.setUsuarioId(contaEntity.getUsuario().getUsuarioId());
        contaResponseDto.setNome(contaEntity.getUsuario().getNome());
        contaResponseDto.setRazaoSocial(contaEntity.getUsuario().getRazaoSocial());

        return contaResponseDto;
    }
    public static ContaEntity contaCreateDtoToConta(ContaCreateDto contaCreateDto) {
        ContaEntity contaEntity = new ContaEntity();
        contaEntity.setBanco(contaCreateDto.getBanco());
        contaEntity.setAgencia(contaCreateDto.getAgencia());
        contaEntity.setConta(contaCreateDto.getConta());
        contaEntity.setDigito(contaCreateDto.getDigito());
        contaEntity.setTipoConta(contaCreateDto.getTipoConta());

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setUsuarioId(contaCreateDto.getUsuarioId());
        contaEntity.setUsuario(usuarioEntity);
        return contaEntity;
    }
    public static ContaEntity contaUpdateDtoToConta(ContaUpdateDto contaUpdateDto, Long contaId) {
        ContaEntity contaEntity = new ContaEntity();
        contaEntity.setContaId(contaId);
        contaEntity.setTipoConta(contaUpdateDto.getTipoConta());

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setUsuarioId(contaUpdateDto.getUsuarioId());
        contaEntity.setUsuario(usuarioEntity);
        return contaEntity;
    }
}
