package com.nutriplus.pratica_nutricional.dto;

import com.nutriplus.pratica_nutricional.entity.enums.ObjetivoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MetaNutricionalResponseDTO(
        Long id,
        Long usuarioId,
        BigDecimal metaCaloricaDiaria,
        BigDecimal metaProteinasG,
        BigDecimal metaCarboidratosG,
        BigDecimal metaGordurasG,
        ObjetivoEnum objetivo,
        LocalDateTime atualizadoEm
) {
}
