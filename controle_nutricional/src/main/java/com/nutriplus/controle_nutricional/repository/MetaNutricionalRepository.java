package com.nutriplus.controle_nutricional.repository;

import com.nutriplus.controle_nutricional.entity.MetaNutricional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetaNutricionalRepository extends JpaRepository<MetaNutricional, Long> {

    // usuario_id é unique na tabela, então cada usuário tem no máximo uma meta
    Optional<MetaNutricional> findByUsuarioId(Long usuarioId);
}
