package com.nutriplus.tabela_nutricional.mappers;

import com.nutriplus.tabela_nutricional.dto.MetaNutricionalRequestDTO;
import com.nutriplus.tabela_nutricional.dto.MetaNutricionalResponseDTO;
import com.nutriplus.tabela_nutricional.entity.MetaNutricional;
import org.springframework.stereotype.Component;

@Component
public class MetaNutricionalMapper {

    public MetaNutricional toEntity(MetaNutricionalRequestDTO dto) {
        MetaNutricional meta = new MetaNutricional();
        meta.setUsuarioId(dto.usuarioId());
        meta.setMetaCaloricaDiaria(dto.metaCaloricaDiaria());
        meta.setMetaProteinasG(dto.metaProteinasG());
        meta.setMetaCarboidratosG(dto.metaCarboidratosG());
        meta.setMetaGordurasG(dto.metaGordurasG());
        meta.setObjetivo(dto.objetivo());
        return meta;
    }

    public MetaNutricionalResponseDTO toResponseDTO(MetaNutricional meta) {
        return new MetaNutricionalResponseDTO(
                meta.getId(),
                meta.getUsuarioId(),
                meta.getMetaCaloricaDiaria(),
                meta.getMetaProteinasG(),
                meta.getMetaCarboidratosG(),
                meta.getMetaGordurasG(),
                meta.getObjetivo(),
                meta.getAtualizadoEm()
        );
    }
}
