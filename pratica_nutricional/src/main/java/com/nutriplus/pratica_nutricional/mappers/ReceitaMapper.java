package com.nutriplus.pratica_nutricional.mappers;

import com.nutriplus.pratica_nutricional.dto.ReceitaRequestDTO;
import com.nutriplus.pratica_nutricional.dto.ReceitaResponseDTO;
import com.nutriplus.pratica_nutricional.entity.Receita;
import com.nutriplus.pratica_nutricional.entity.enums.DificuldadeEnum;
import org.springframework.stereotype.Component;

@Component
public class ReceitaMapper {

    public Receita toEntity(ReceitaRequestDTO dto) {
        Receita receita = new Receita();
        receita.setNome(dto.nome());
        receita.setDescricao(dto.descricao());
        receita.setTempoPreparoMin(dto.tempoPreparoMin());
        receita.setDificuldade(
                dto.dificuldade() != null ? dto.dificuldade() : DificuldadeEnum.FACIL);
        receita.setInstrucoes(dto.instrucoes());
        return receita;
    }

    public ReceitaResponseDTO toResponseDTO(Receita receita) {
        return new ReceitaResponseDTO(
                receita.getId(),
                receita.getNome(),
                receita.getDescricao(),
                receita.getTempoPreparoMin(),
                receita.getDificuldade(),
                receita.getInstrucoes()
        );
    }
}
