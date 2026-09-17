package com.nutriplus.controle_nutricional.dto;

import com.nutriplus.controle_nutricional.entity.enums.DificuldadeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ReceitaRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String nome,

        String descricao,

        @NotNull(message = "O tempo de preparo é obrigatório")
        @Positive(message = "O tempo de preparo deve ser maior que zero")
        Integer tempoPreparoMin,

        // Opcional: se não vier no JSON, o service pode aplicar o default 'facil'
        DificuldadeEnum dificuldade,

        @NotBlank(message = "As instruções são obrigatórias")
        String instrucoes
) {
}
