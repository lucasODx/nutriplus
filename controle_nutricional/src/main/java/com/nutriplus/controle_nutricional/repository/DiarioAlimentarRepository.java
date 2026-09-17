package com.nutriplus.controle_nutricional.repository;

import com.nutriplus.controle_nutricional.entity.DiarioAlimentar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DiarioAlimentarRepository extends JpaRepository<DiarioAlimentar, Long> {

    List<DiarioAlimentar> findByUsuarioId(Long usuarioId);

    List<DiarioAlimentar> findByUsuarioIdAndDataRefeicaoBetween(
            Long usuarioId, LocalDateTime inicio, LocalDateTime fim);
}
