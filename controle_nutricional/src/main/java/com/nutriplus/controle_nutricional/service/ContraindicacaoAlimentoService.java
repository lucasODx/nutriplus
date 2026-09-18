package com.nutriplus.controle_nutricional.service;

import com.nutriplus.controle_nutricional.dto.ContraindicacaoAlimentoRequestDTO;
import com.nutriplus.controle_nutricional.dto.ContraindicacaoAlimentoResponseDTO;
import com.nutriplus.controle_nutricional.entity.Alimento;
import com.nutriplus.controle_nutricional.entity.ContraindicacaoAlimento;
import com.nutriplus.controle_nutricional.exception.NotFoundException;
import com.nutriplus.controle_nutricional.mappers.ContraindicacaoAlimentoMapper;
import com.nutriplus.controle_nutricional.repository.AlimentoRepository;
import com.nutriplus.controle_nutricional.repository.ContraindicacaoAlimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContraindicacaoAlimentoService {

    private final AlimentoRepository alimentoRepository;
    private final ContraindicacaoAlimentoRepository repository;
    private final ContraindicacaoAlimentoMapper mapper;

    public ContraindicacaoAlimentoService(ContraindicacaoAlimentoRepository repository, ContraindicacaoAlimentoMapper mapper, AlimentoRepository alimentoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.alimentoRepository = alimentoRepository;
    }

    public ContraindicacaoAlimentoResponseDTO create(ContraindicacaoAlimentoRequestDTO dto) {
        Alimento alimento = alimentoRepository.findById(dto.alimentoId())
                .orElseThrow(() -> new NotFoundException(
                        "Dado não encontrado!"));

        ContraindicacaoAlimento contraIndicacaoAlimento = this.mapper.toEntity(dto);
        contraIndicacaoAlimento.setAlimento(alimento);
        return mapper.toResponseDTO(repository.save(contraIndicacaoAlimento));
    }

    public List<ContraindicacaoAlimentoResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }
}
