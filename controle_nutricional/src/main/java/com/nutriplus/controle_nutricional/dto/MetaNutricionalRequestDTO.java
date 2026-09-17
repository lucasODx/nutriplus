package com.nutriplus.controle_nutricional.dto;

import com.nutriplus.controle_nutricional.entity.enums.ObjetivoEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record MetaNutricionalRequestDTO(

        @NotNull(message = "O id do usuário é obrigatório")
        Long usuarioId,

        @NotNull(message = "A meta calórica diária é obrigatória")
        @DecimalMin(value = "0.0", message = "A meta calórica não pode ser negativa")
        BigDecimal metaCaloricaDiaria,

        @NotNull(message = "A meta de proteínas é obrigatória")
        @DecimalMin(value = "0.0", message = "A meta de proteínas não pode ser negativa")
        BigDecimal metaProteinasG,

        @NotNull(message = "A meta de carboidratos é obrigatória")
        @DecimalMin(value = "0.0", message = "A meta de carboidratos não pode ser negativa")
        BigDecimal metaCarboidratosG,

        @NotNull(message = "A meta de gorduras é obrigatória")
        @DecimalMin(value = "0.0", message = "A meta de gorduras não pode ser negativa")
        BigDecimal metaGordurasG,

        @NotNull(message = "O objetivo é obrigatório")
        ObjetivoEnum objetivo
) {
}
