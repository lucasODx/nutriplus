package com.nutriplus.controle_nutricional.dto;

import com.nutriplus.controle_nutricional.entity.enums.TipoRefeicaoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DiarioAlimentarResponseDTO(
        Long id,
        Long usuarioId,
        LocalDateTime dataRefeicao,
        TipoRefeicaoEnum tipoRefeicao,
        Long alimentoId,
        BigDecimal quantidadeGramas,
        BigDecimal caloriasCalculadas,
        LocalDateTime criadoEm
) {
}
