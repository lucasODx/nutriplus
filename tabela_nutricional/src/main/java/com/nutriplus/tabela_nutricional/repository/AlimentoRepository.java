package com.nutriplus.tabela_nutricional.repository;

import com.nutriplus.tabela_nutricional.entity.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

    List<Alimento> findByNome(String nome);
}
