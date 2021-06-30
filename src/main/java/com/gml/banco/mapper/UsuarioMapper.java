package com.gml.banco.mapper;

import com.gml.banco.dto.UsuarioCreateDto;
import com.gml.banco.dto.UsuarioResponseDto;
import com.gml.banco.dto.UsuarioUpdateDto;
import com.gml.banco.entities.UsuarioEntity;

public class UsuarioMapper {

    public static UsuarioResponseDto usuarioToUsuarioResponseDto(UsuarioEntity usuarioEntity) {
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setUsuarioId(usuarioEntity.getUsuarioId());
        usuarioResponseDto.setNome(usuarioEntity.getNome());

        return usuarioResponseDto;
    }
    public static UsuarioEntity usuarioCreateDtoToUsuario(UsuarioCreateDto usuarioCreateDto) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(usuarioCreateDto.getNome());
        usuarioEntity.setRazaoSocial(usuarioCreateDto.getRazaoSocial());
        usuarioEntity.setSenha(usuarioCreateDto.getSenha());
        return usuarioEntity;
    }
    public static UsuarioEntity usuarioUpdateDtoToUsuario(UsuarioUpdateDto usuarioUpdateDto, Long usuarioId) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setUsuarioId(usuarioId);
        usuarioEntity.setNome(usuarioUpdateDto.getNome());
        usuarioEntity.setSenha(usuarioUpdateDto.getSenha());
        return usuarioEntity;
    }
}
