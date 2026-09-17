package com.nutriplus.controle_nutricional.dto;

import com.nutriplus.controle_nutricional.entity.enums.IndiceGlicemicoEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AlimentoRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String nome,

        @NotBlank(message = "A categoria é obrigatória")
        @Size(max = 50, message = "A categoria deve ter no máximo 50 caracteres")
        String categoria,

        @NotNull(message = "As calorias por 100g são obrigatórias")
        @DecimalMin(value = "0.0", message = "As calorias não podem ser negativas")
        BigDecimal caloriasPor100g,

        @NotNull(message = "As proteínas por 100g são obrigatórias")
        @DecimalMin(value = "0.0", message = "As proteínas não podem ser negativas")
        BigDecimal proteinas100g,

        @NotNull(message = "Os carboidratos por 100g são obrigatórios")
        @DecimalMin(value = "0.0", message = "Os carboidratos não podem ser negativos")
        BigDecimal carboidratos100g,

        @NotNull(message = "As gorduras por 100g são obrigatórias")
        @DecimalMin(value = "0.0", message = "As gorduras não podem ser negativas")
        BigDecimal gorduras100g,

        // Opcional: se não vier no JSON, o service pode aplicar o default 'baixo'
        IndiceGlicemicoEnum indiceGlicemico
) {
}
