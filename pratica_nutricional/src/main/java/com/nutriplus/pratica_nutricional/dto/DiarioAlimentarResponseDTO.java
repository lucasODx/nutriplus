package com.nutriplus.pratica_nutricional.dto;

import com.nutriplus.pratica_nutricional.entity.enums.TipoRefeicaoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DiarioAlimentarResponseDTO(
        Long id,
        Long usuarioId,
        LocalDateTime dataRefeicao,
        TipoRefeicaoEnum tipoRefeicao,
        Long alimentoId,
        BigDecimal quantidadeGramas,
        LocalDateTime criadoEm
) {
}
