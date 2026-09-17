package com.nutriplus.controle_nutricional.service;

import com.nutriplus.controle_nutricional.dto.ReceitaRequestDTO;
import com.nutriplus.controle_nutricional.dto.ReceitaResponseDTO;
import com.nutriplus.controle_nutricional.entity.Receita;
import com.nutriplus.controle_nutricional.entity.enums.DificuldadeEnum;
import com.nutriplus.controle_nutricional.exception.NotFoundException;
import com.nutriplus.controle_nutricional.mappers.ReceitaMapper;
import com.nutriplus.controle_nutricional.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    private final ReceitaRepository repository;
    private final ReceitaMapper mapper;

    public ReceitaService(ReceitaRepository repository, ReceitaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ReceitaResponseDTO create(ReceitaRequestDTO dto) {
        Receita receita = mapper.toEntity(dto);
        return mapper.toResponseDTO(repository.save(receita));
    }

    public List<ReceitaResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public List<ReceitaResponseDTO> findByDificuldade(DificuldadeEnum dificuldade) {
        return repository.findByDificuldade(dificuldade)
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public List<ReceitaResponseDTO> findByNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }
}
