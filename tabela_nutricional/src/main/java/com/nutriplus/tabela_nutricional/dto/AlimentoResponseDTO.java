package com.nutriplus.tabela_nutricional.dto;

import com.nutriplus.tabela_nutricional.entity.enums.IndiceGlicemicoEnum;

import java.math.BigDecimal;

public record AlimentoResponseDTO(
        Long id,
        String nome,
        String categoria,
        BigDecimal caloriasPor100g,
        BigDecimal proteinas100g,
        BigDecimal carboidratos100g,
        BigDecimal gorduras100g,
        IndiceGlicemicoEnum indiceGlicemico
) {
}
