package com.nutriplus.controle_nutricional.dto;

import com.nutriplus.controle_nutricional.entity.enums.DificuldadeEnum;

public record ReceitaResponseDTO(
        Long id,
        String nome,
        String descricao,
        Integer tempoPreparoMin,
        DificuldadeEnum dificuldade,
        String instrucoes
) {
}
