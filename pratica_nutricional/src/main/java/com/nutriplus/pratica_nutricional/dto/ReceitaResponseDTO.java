package com.nutriplus.pratica_nutricional.dto;

import com.nutriplus.pratica_nutricional.entity.enums.DificuldadeEnum;

public record ReceitaResponseDTO(
        Long id,
        String nome,
        String descricao,
        Integer tempoPreparoMin,
        DificuldadeEnum dificuldade,
        String instrucoes
) {
}
