package com.nutriplus.tabela_nutricional.service;

import com.nutriplus.tabela_nutricional.dto.RegistroExercicioRequestDTO;
import com.nutriplus.tabela_nutricional.dto.RegistroExercicioResponseDTO;
import com.nutriplus.tabela_nutricional.entity.RegistroExercicio;
import com.nutriplus.tabela_nutricional.exception.NotFoundException;
import com.nutriplus.tabela_nutricional.mappers.RegistroExercicioMapper;
import com.nutriplus.tabela_nutricional.repository.RegistroExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroExercicioService {

    private final RegistroExercicioRepository repository;
    private final RegistroExercicioMapper mapper;

    public RegistroExercicioService(RegistroExercicioRepository repository, RegistroExercicioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RegistroExercicioResponseDTO create(RegistroExercicioRequestDTO dto) {
        RegistroExercicio registroExercicio = mapper.toEntity(dto);
        return mapper.toResponseDTO(repository.save(registroExercicio));
    }

    public List<RegistroExercicioResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }
}
