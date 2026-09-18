package com.nutriplus.tabela_nutricional.repository;

import com.nutriplus.tabela_nutricional.entity.Alimento;
import com.nutriplus.tabela_nutricional.entity.ContraindicacaoAlimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContraindicacaoAlimentoRepository extends JpaRepository<ContraindicacaoAlimento, Long> {

    List<ContraindicacaoAlimento> findByCondicaoMedica(String nome);
}
