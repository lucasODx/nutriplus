package com.nutriplus.controle_nutricional.service;

import com.nutriplus.controle_nutricional.entity.Alimento;
import com.nutriplus.controle_nutricional.repository.AlimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlimentoService {

    private final AlimentoRepository repository;

    public AlimentoService(AlimentoRepository repository) {
        this.repository = repository;
    }

    public Alimento save(Alimento alimento) {
        return repository.save(alimento);
    }

}
