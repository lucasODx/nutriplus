package com.nutriplus.pratica_nutricional.repository;

import com.nutriplus.pratica_nutricional.entity.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

    List<Alimento> findByNome(String nome);
}
