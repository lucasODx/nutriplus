package com.nutriplus.tabela_nutricional.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ContraindicacaoAlimentoRequestDTO(

        @NotNull(message = "O id do alimento é obrigatório")
        Long alimentoId,

        @NotBlank(message = "A condição médica é obrigatória")
        @Size(max = 50, message = "A condição médica deve ter no máximo 50 caracteres")
        String condicaoMedica
) {
}
