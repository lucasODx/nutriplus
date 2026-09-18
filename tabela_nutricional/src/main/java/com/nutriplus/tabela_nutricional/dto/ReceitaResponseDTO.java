package com.nutriplus.tabela_nutricional.dto;

import com.nutriplus.tabela_nutricional.entity.enums.DificuldadeEnum;

public record ReceitaResponseDTO(
        Long id,
        String nome,
        String descricao,
        Integer tempoPreparoMin,
        DificuldadeEnum dificuldade,
        String instrucoes
) {
}
