package com.nutriplus.controle_nutricional.service;

import com.nutriplus.controle_nutricional.dto.MetaNutricionalRequestDTO;
import com.nutriplus.controle_nutricional.dto.MetaNutricionalResponseDTO;
import com.nutriplus.controle_nutricional.entity.MetaNutricional;
import com.nutriplus.controle_nutricional.exception.NotFoundException;
import com.nutriplus.controle_nutricional.mappers.MetaNutricionalMapper;
import com.nutriplus.controle_nutricional.repository.MetaNutricionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaNutricionalService {

    private final MetaNutricionalRepository repository;
    private final MetaNutricionalMapper mapper;

    public MetaNutricionalService(MetaNutricionalRepository repository, MetaNutricionalMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public MetaNutricionalResponseDTO create(MetaNutricionalRequestDTO dto) {
        MetaNutricional meta = mapper.toEntity(dto);
        return mapper.toResponseDTO(repository.save(meta));
    }

    public List<MetaNutricionalResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }
}
