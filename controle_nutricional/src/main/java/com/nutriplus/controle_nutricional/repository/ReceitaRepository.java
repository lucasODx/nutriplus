package com.nutriplus.controle_nutricional.repository;

import com.nutriplus.controle_nutricional.entity.Receita;
import com.nutriplus.controle_nutricional.entity.enums.DificuldadeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByDificuldade(DificuldadeEnum dificuldade);

    List<Receita> findByNomeContainingIgnoreCase(String nome);
}
