package com.nutriplus.tabela_nutricional.repository;

import com.nutriplus.tabela_nutricional.entity.RegistroExercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroExercicioRepository extends JpaRepository<RegistroExercicio, Long> {

    List<RegistroExercicio> findByUsuarioId(Long usuarioId);
}
