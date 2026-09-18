package com.nutriplus.tabela_nutricional.mappers;

import com.nutriplus.tabela_nutricional.dto.RegistroExercicioRequestDTO;
import com.nutriplus.tabela_nutricional.dto.RegistroExercicioResponseDTO;
import com.nutriplus.tabela_nutricional.entity.RegistroExercicio;
import org.springframework.stereotype.Component;

@Component
public class RegistroExercicioMapper {

    public RegistroExercicio toEntity(RegistroExercicioRequestDTO dto) {
        RegistroExercicio registro = new RegistroExercicio();
        registro.setUsuarioId(dto.usuarioId());
        registro.setDataExercicio(dto.dataExercicio());
        registro.setTipoExercicio(dto.tipoExercicio());
        registro.setDuracaoMinutos(dto.duracaoMinutos());
        registro.setCaloriasQueimadas(dto.caloriasQueimadas());
        return registro;
    }

    public RegistroExercicioResponseDTO toResponseDTO(RegistroExercicio registro) {
        return new RegistroExercicioResponseDTO(
                registro.getId(),
                registro.getUsuarioId(),
                registro.getDataExercicio(),
                registro.getTipoExercicio(),
                registro.getDuracaoMinutos(),
                registro.getCaloriasQueimadas(),
                registro.getCriadoEm()
        );
    }
}
