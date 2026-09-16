package com.nutriplus.controle_nutricional.service;

import com.nutriplus.controle_nutricional.entity.Alimento;
import com.nutriplus.controle_nutricional.entity.DiarioAlimentar;
import com.nutriplus.controle_nutricional.repository.DiarioAlimentarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiarioAlimentarService {

    private final DiarioAlimentarRepository repository;

    public DiarioAlimentarService(DiarioAlimentarRepository repository) {
        this.repository = repository;
    }

    public List<DiarioAlimentar> findById(Long id) {
        return repository.findByUsuarioId(id);
    }
}
