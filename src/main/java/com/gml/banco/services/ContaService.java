package com.gml.banco.services;

import com.gml.banco.entities.ContaEntity;
import com.gml.banco.entities.UsuarioEntity;
import com.gml.banco.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {
    @Autowired
    private ContaRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    public List<ContaEntity> findContaByUsuarioId(Long usuarioId) {
        return repository.findContaEntityByUsuarioUsuarioId(usuarioId);
    }

    public ContaEntity saveConta(ContaEntity contaEntity) {
        UsuarioEntity usuarioEntity = usuarioService.findByUsuarioById(contaEntity.getUsuario().getUsuarioId());
        contaEntity.setUsuario(usuarioEntity);
        return repository.save(contaEntity);
    }

    public ContaEntity updateConta(ContaEntity contaEntityTransientToUpdate) {
        ContaEntity contaEntityManaged = repository.findById(contaEntityTransientToUpdate.getContaId()).orElseThrow();
        contaEntityManaged.setTipoConta(contaEntityTransientToUpdate.getTipoConta());

        return repository.save(contaEntityManaged);
    }

    public void deleteConta(Long contaId) {
        repository.deleteById(contaId);
    }

    public ContaEntity findContaById(Long contaId) {
        return repository.findById(contaId).orElseThrow();
    }
}
