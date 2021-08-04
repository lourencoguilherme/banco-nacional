package com.gml.banco.mapper;

import com.gml.banco.dto.UsuarioCreateDto;
import com.gml.banco.dto.UsuarioResponseDto;
import com.gml.banco.dto.UsuarioUpdateDto;
import com.gml.banco.entities.Usuario;

public class UsuarioMapper {

    public static UsuarioResponseDto usuarioToUsuarioResponseDto(Usuario usuario) {
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setUsuarioId(usuario.getUsuarioId());
        usuarioResponseDto.setNome(usuario.getNome());

        return usuarioResponseDto;
    }
    public static Usuario usuarioCreateDtoToUsuario(UsuarioCreateDto usuarioCreateDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioCreateDto.getNome());
        usuario.setRazaoSocial(usuarioCreateDto.getRazaoSocial());
        usuario.setSenha(usuarioCreateDto.getSenha());
        return usuario;
    }
    public static Usuario usuarioUpdateDtoToUsuario(UsuarioUpdateDto usuarioUpdateDto, Long usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(usuarioId);
        usuario.setNome(usuarioUpdateDto.getNome());
        usuario.setSenha(usuarioUpdateDto.getSenha());
        return usuario;
    }
}
