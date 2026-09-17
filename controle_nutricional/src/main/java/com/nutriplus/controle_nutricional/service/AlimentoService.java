package com.nutriplus.controle_nutricional.service;

import com.nutriplus.controle_nutricional.dto.AlimentoRequestDTO;
import com.nutriplus.controle_nutricional.dto.AlimentoResponseDTO;
import com.nutriplus.controle_nutricional.entity.Alimento;
import com.nutriplus.controle_nutricional.entity.enums.IndiceGlicemicoEnum;
import com.nutriplus.controle_nutricional.exception.NotFoundException;
import com.nutriplus.controle_nutricional.mappers.AlimentoMapper;
import com.nutriplus.controle_nutricional.repository.AlimentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlimentoService {

    private final AlimentoRepository repository;
    private final AlimentoMapper mapper;

    public AlimentoService(AlimentoRepository repository, AlimentoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public AlimentoResponseDTO create(AlimentoRequestDTO dto) {
        Alimento alimento = this.mapper.toEntity(dto);
        return mapper.toResponseDTO(repository.save(alimento));
    }

    public List<AlimentoResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }
}
