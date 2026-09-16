package com.nutriplus.controle_nutricional.repository;

import com.nutriplus.controle_nutricional.entity.DiarioAlimentar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiarioAlimentarRepository extends JpaRepository<DiarioAlimentar, Long> {

    List<DiarioAlimentar> findByUsuarioId(Long id);

}