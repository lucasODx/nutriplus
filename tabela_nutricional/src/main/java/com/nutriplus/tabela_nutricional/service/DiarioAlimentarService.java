package com.nutriplus.tabela_nutricional.service;

import com.nutriplus.tabela_nutricional.dto.DiarioAlimentarRequestDTO;
import com.nutriplus.tabela_nutricional.dto.DiarioAlimentarResponseDTO;
import com.nutriplus.tabela_nutricional.entity.DiarioAlimentar;
import com.nutriplus.tabela_nutricional.mappers.DiarioAlimentarMapper;
import com.nutriplus.tabela_nutricional.repository.DiarioAlimentarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiarioAlimentarService {

    private final DiarioAlimentarRepository repository;
    private final DiarioAlimentarMapper mapper;

    public DiarioAlimentarService(DiarioAlimentarRepository repository, DiarioAlimentarMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DiarioAlimentar> findAll() {
        return repository.findAll();
    }

    public DiarioAlimentarResponseDTO create(DiarioAlimentarRequestDTO dto) {
        DiarioAlimentar diarioAlimentar = mapper.toEntity(dto);
        return mapper.toResponseDTO(repository.save(diarioAlimentar));
    }

}
