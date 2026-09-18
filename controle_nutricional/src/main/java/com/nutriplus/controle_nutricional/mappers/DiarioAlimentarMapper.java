package com.nutriplus.controle_nutricional.mappers;

import com.nutriplus.controle_nutricional.dto.DiarioAlimentarRequestDTO;
import com.nutriplus.controle_nutricional.dto.DiarioAlimentarResponseDTO;
import com.nutriplus.controle_nutricional.entity.DiarioAlimentar;
import org.springframework.stereotype.Component;

@Component
public class DiarioAlimentarMapper {

    public DiarioAlimentar toEntity(DiarioAlimentarRequestDTO dto) {
        DiarioAlimentar diario = new DiarioAlimentar();
        diario.setUsuarioId(dto.usuarioId());
        diario.setDataRefeicao(dto.dataRefeicao());
        diario.setTipoRefeicao(dto.tipoRefeicao());
        diario.setAlimentoId(dto.alimentoId());
        diario.setQuantidadeGramas(dto.quantidadeGramas());
        return diario;
    }

    public DiarioAlimentarResponseDTO toResponseDTO(DiarioAlimentar diario) {
        return new DiarioAlimentarResponseDTO(
                diario.getId(),
                diario.getUsuarioId(),
                diario.getDataRefeicao(),
                diario.getTipoRefeicao(),
                diario.getAlimentoId(),
                diario.getQuantidadeGramas(),
                diario.getCriadoEm()
        );
    }
}
