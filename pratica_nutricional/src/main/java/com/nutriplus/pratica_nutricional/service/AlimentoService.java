package com.nutriplus.pratica_nutricional.service;

import com.nutriplus.pratica_nutricional.dto.AlimentoRequestDTO;
import com.nutriplus.pratica_nutricional.dto.AlimentoResponseDTO;
import com.nutriplus.pratica_nutricional.entity.Alimento;
import com.nutriplus.pratica_nutricional.entity.enums.IndiceGlicemicoEnum;
import com.nutriplus.pratica_nutricional.exception.NotFoundException;
import com.nutriplus.pratica_nutricional.mappers.AlimentoMapper;
import com.nutriplus.pratica_nutricional.repository.AlimentoRepository;
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
