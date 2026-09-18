package com.nutriplus.pratica_nutricional.mappers;

import com.nutriplus.pratica_nutricional.dto.AlimentoRequestDTO;
import com.nutriplus.pratica_nutricional.dto.AlimentoResponseDTO;
import com.nutriplus.pratica_nutricional.entity.Alimento;
import com.nutriplus.pratica_nutricional.entity.enums.IndiceGlicemicoEnum;
import org.springframework.stereotype.Component;

@Component
public class AlimentoMapper {

    public Alimento toEntity(AlimentoRequestDTO dto) {
        Alimento alimento = new Alimento();
        alimento.setNome(dto.nome());
        alimento.setCategoria(dto.categoria());
        alimento.setCaloriasPor100g(dto.caloriasPor100g());
        alimento.setProteinas100g(dto.proteinas100g());
        alimento.setCarboidratos100g(dto.carboidratos100g());
        alimento.setGorduras100g(dto.gorduras100g());
        alimento.setIndiceGlicemico(
                dto.indiceGlicemico() != null ? dto.indiceGlicemico() : IndiceGlicemicoEnum.BAIXO);
        return alimento;
    }

    public AlimentoResponseDTO toResponseDTO(Alimento alimento) {
        return new AlimentoResponseDTO(
                alimento.getId(),
                alimento.getNome(),
                alimento.getCategoria(),
                alimento.getCaloriasPor100g(),
                alimento.getProteinas100g(),
                alimento.getCarboidratos100g(),
                alimento.getGorduras100g(),
                alimento.getIndiceGlicemico()
        );
    }
}
