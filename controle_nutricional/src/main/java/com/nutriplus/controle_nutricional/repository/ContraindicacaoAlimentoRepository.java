package com.nutriplus.controle_nutricional.repository;

import com.nutriplus.controle_nutricional.entity.Alimento;
import com.nutriplus.controle_nutricional.entity.ContraindicacaoAlimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContraindicacaoAlimentoRepository extends JpaRepository<ContraindicacaoAlimento, Long> {

    List<ContraindicacaoAlimento> findByCondicaoMedica(String nome);
}
