package com.nutriplus.controle_nutricional.dto;

import com.nutriplus.controle_nutricional.entity.enums.TipoRefeicaoEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DiarioAlimentarRequestDTO(

        @NotNull(message = "O id do usuário é obrigatório")
        Long usuarioId,

        @NotNull(message = "A data da refeição é obrigatória")
        LocalDateTime dataRefeicao,

        @NotNull(message = "O tipo de refeição é obrigatório")
        TipoRefeicaoEnum tipoRefeicao,

        @NotNull(message = "O id do alimento é obrigatório")
        Long alimentoId,

        @NotNull(message = "A quantidade em gramas é obrigatória")
        @DecimalMin(value = "0.01", message = "A quantidade deve ser maior que zero")
        BigDecimal quantidadeGramas
) {
}
