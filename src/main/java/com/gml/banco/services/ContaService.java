package com.gml.banco.services;

import com.gml.banco.entities.Conta;
import com.gml.banco.entities.Usuario;
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

    public List<Conta> findContaByUsuarioId(Long usuarioId) {
        return repository.findContaEntityByUsuarioUsuarioId(usuarioId);
    }

    public Conta saveConta(Conta conta) {
        Usuario usuario = usuarioService.findUsuarioById(conta.getUsuario().getUsuarioId());
        conta.setUsuario(usuario);
        return repository.save(conta);
    }

    public Conta updateConta(Conta contaTransientToUpdate) {
        Conta contaManaged = repository.findById(contaTransientToUpdate.getContaId()).orElseThrow();
        contaManaged.setTipoConta(contaTransientToUpdate.getTipoConta());

        return repository.save(contaManaged);
    }

    public void deleteConta(Long contaId) {
        repository.deleteById(contaId);
    }

    public Conta findContaById(Long contaId) {
        return repository.findById(contaId).orElseThrow();
    }
}
