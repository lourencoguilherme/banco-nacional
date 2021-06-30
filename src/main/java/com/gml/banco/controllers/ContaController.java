package com.gml.banco.controllers;

import com.gml.banco.dto.ContaCreateDto;
import com.gml.banco.dto.ContaResponseDto;
import com.gml.banco.dto.ContaUpdateDto;
import com.gml.banco.dto.UsuarioResponseDto;
import com.gml.banco.entities.ContaEntity;
import com.gml.banco.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.gml.banco.mapper.ContaMapper.*;
import static com.gml.banco.mapper.UsuarioMapper.usuarioToUsuarioResponseDto;

@RestController
@RequestMapping(path = "/api/contas")
public class ContaController {

    @Autowired
    private ContaService service;

    @PostMapping
    public ContaResponseDto criarConta(@RequestBody ContaCreateDto contaCreateDto) {
        ContaEntity contaEntity = service.saveConta(contaCreateDtoToConta(contaCreateDto));

        return contaToContaResponseDto(contaEntity);
    }
    @GetMapping(path = "/{contaId}")
    public ContaResponseDto buscaContaPorId(@PathVariable("contaId") Long contaId) {
        return contaToContaResponseDto(service.findContaById(contaId));
    }

    @PutMapping(path = "/{contaId}")
    public ContaResponseDto atualizaConta(@PathVariable("contaId") Long contaId, @RequestBody ContaUpdateDto contaUpdateDto) {
        ContaEntity contaEntity = service.updateConta(contaUpdateDtoToConta(contaUpdateDto, contaId));
        return contaToContaResponseDto(contaEntity);
    }

    @DeleteMapping(path = "/{contaId}")
    public void deletaConta(@PathVariable("contaId") Long contaId) {

        service.deleteConta(contaId);
    }

    @GetMapping(path = "/usuarios/{usuarioId}")
    public List<ContaResponseDto> buscaContasPorUsuarioId(@PathVariable("usuarioId") Long usuarioId) {
        List<ContaEntity> contaEntityList = service.findContaByUsuarioId(usuarioId);

        List<ContaResponseDto> contaResponseDtoList = contaEntityList.stream().map(contaEntity ->  contaToContaResponseDto(contaEntity)).collect(Collectors.toList());

        return contaResponseDtoList;
    }




}
