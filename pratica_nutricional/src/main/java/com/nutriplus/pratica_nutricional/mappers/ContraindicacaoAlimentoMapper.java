package com.nutriplus.pratica_nutricional.mappers;

import com.nutriplus.pratica_nutricional.dto.ContraindicacaoAlimentoRequestDTO;
import com.nutriplus.pratica_nutricional.dto.ContraindicacaoAlimentoResponseDTO;
import com.nutriplus.pratica_nutricional.entity.ContraindicacaoAlimento;
import org.springframework.stereotype.Component;

@Component
public class ContraindicacaoAlimentoMapper {

    public ContraindicacaoAlimento toEntity(ContraindicacaoAlimentoRequestDTO dto) {
        ContraindicacaoAlimento contraindicacao = new ContraindicacaoAlimento();
        contraindicacao.setCondicaoMedica(dto.condicaoMedica());

        return contraindicacao;
    }

    public ContraindicacaoAlimentoResponseDTO toResponseDTO(ContraindicacaoAlimento contraindicacao) {
        return new ContraindicacaoAlimentoResponseDTO(
                contraindicacao.getId(),
                contraindicacao.getAlimento().getId(),
                contraindicacao.getAlimento().getNome(),
                contraindicacao.getCondicaoMedica()
        );
    }
}
