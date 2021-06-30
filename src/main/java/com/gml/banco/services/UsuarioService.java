package com.gml.banco.services;

import com.gml.banco.entities.UsuarioEntity;
import com.gml.banco.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public UsuarioEntity findByUsuarioById(Long usuarioId) {
        return repository.findById(usuarioId).orElseThrow();
    }

    public UsuarioEntity saveUsuario(UsuarioEntity usuarioEntity) {

        return repository.save(usuarioEntity);
    }

    public UsuarioEntity updateUsuario(UsuarioEntity usuarioEntityTransientToUpdate) {
        UsuarioEntity usuarioEntityManaged = repository.findById(usuarioEntityTransientToUpdate.getUsuarioId()).orElseThrow();
        usuarioEntityManaged.setNome(usuarioEntityTransientToUpdate.getNome());
        usuarioEntityManaged.setSenha(usuarioEntityTransientToUpdate.getSenha());

        return repository.save(usuarioEntityManaged);
    }

    public void deleteUsuario(Long usuarioId) {
        repository.deleteById(usuarioId);
    }
}
