package com.nutriplus.tabela_nutricional.dto;

import com.nutriplus.tabela_nutricional.entity.enums.ObjetivoEnum;

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
