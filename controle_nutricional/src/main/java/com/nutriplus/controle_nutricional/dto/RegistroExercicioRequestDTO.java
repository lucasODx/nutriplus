package com.nutriplus.controle_nutricional.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegistroExercicioRequestDTO(

        @NotNull(message = "O id do usuário é obrigatório")
        Long usuarioId,

        @NotNull(message = "A data do exercício é obrigatória")
        LocalDateTime dataExercicio,

        @NotBlank(message = "O tipo de exercício é obrigatório")
        @Size(max = 50, message = "O tipo de exercício deve ter no máximo 50 caracteres")
        String tipoExercicio,

        @NotNull(message = "A duração é obrigatória")
        @Positive(message = "A duração deve ser maior que zero")
        Integer duracaoMinutos,

        @NotNull(message = "As calorias queimadas são obrigatórias")
        @DecimalMin(value = "0.0", message = "As calorias queimadas não podem ser negativas")
        BigDecimal caloriasQueimadas
) {
}
