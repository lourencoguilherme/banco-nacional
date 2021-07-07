package com.gml.banco.controllers;

import com.gml.banco.dto.UsuarioCreateDto;
import com.gml.banco.dto.UsuarioResponseDto;
import com.gml.banco.dto.UsuarioUpdateDto;
import com.gml.banco.entities.UsuarioEntity;
import com.gml.banco.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.gml.banco.mapper.UsuarioMapper.*;

@RestController
@RequestMapping(path = "/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping(path = "/{usuarioId}")
    public UsuarioResponseDto buscaUsuarioPorId(@PathVariable("usuarioId") Long usuarioId) {
        return usuarioToUsuarioResponseDto(service.findUsuarioById(usuarioId));
    }

    @PostMapping
    public UsuarioResponseDto criarUsuario(@RequestBody UsuarioCreateDto usuarioCreateDto) {
        UsuarioEntity usuarioEntity = service.saveUsuario(usuarioCreateDtoToUsuario(usuarioCreateDto));
        return usuarioToUsuarioResponseDto(usuarioEntity);
    }

    @PutMapping(path = "/{usuarioId}")
    public UsuarioResponseDto atualizaUsuario(@PathVariable("usuarioId") Long usuarioId, @RequestBody UsuarioUpdateDto usuarioUpdateDto) {
        UsuarioEntity usuarioEntity = service.updateUsuario(usuarioUpdateDtoToUsuario(usuarioUpdateDto, usuarioId));
        return usuarioToUsuarioResponseDto(usuarioEntity);
    }

    @DeleteMapping(path = "/{usuarioId}")
    public void deletaUsuario(@PathVariable("usuarioId") Long usuarioId) {

        service.deleteUsuario(usuarioId);
    }



}
