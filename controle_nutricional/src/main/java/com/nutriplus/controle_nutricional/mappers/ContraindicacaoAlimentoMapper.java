package com.nutriplus.controle_nutricional.mappers;

import com.nutriplus.controle_nutricional.dto.ContraindicacaoAlimentoRequestDTO;
import com.nutriplus.controle_nutricional.dto.ContraindicacaoAlimentoResponseDTO;
import com.nutriplus.controle_nutricional.entity.ContraindicacaoAlimento;
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
