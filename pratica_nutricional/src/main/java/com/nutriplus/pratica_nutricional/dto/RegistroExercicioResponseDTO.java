package com.nutriplus.pratica_nutricional.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegistroExercicioResponseDTO(
        Long id,
        Long usuarioId,
        LocalDateTime dataExercicio,
        String tipoExercicio,
        Integer duracaoMinutos,
        BigDecimal caloriasQueimadas,
        LocalDateTime criadoEm
) {
}
