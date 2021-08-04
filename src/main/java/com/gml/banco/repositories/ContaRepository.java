package com.gml.banco.repositories;

import com.gml.banco.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findContaEntityByUsuarioUsuarioId(Long usuarioId);
}
