package com.nutriplus.pratica_nutricional.dto;

public record ContraindicacaoAlimentoResponseDTO(
        Long id,
        Long alimentoId,
        String alimentoNome,
        String condicaoMedica
) {
}
