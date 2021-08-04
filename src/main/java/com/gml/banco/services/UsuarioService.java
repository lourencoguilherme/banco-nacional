package com.gml.banco.services;

import com.gml.banco.entities.Usuario;
import com.gml.banco.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario findUsuarioById(Long usuarioId) {
        return repository.findById(usuarioId).orElseThrow();
    }

    public Usuario saveUsuario(Usuario usuario) {

        return repository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuarioTransientToUpdate) {
        Usuario usuarioManaged = repository.findById(usuarioTransientToUpdate.getUsuarioId()).orElseThrow();
        usuarioManaged.setNome(usuarioTransientToUpdate.getNome());
        usuarioManaged.setSenha(usuarioTransientToUpdate.getSenha());

        return repository.save(usuarioManaged);
    }

    public void deleteUsuario(Long usuarioId) {
        repository.deleteById(usuarioId);
    }
}
