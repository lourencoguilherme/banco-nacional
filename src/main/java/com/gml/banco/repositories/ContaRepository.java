package com.gml.banco.repositories;

import com.gml.banco.entities.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Long> {
    List<ContaEntity> findContaEntityByUsuarioUsuarioId(Long usuarioId);
}
