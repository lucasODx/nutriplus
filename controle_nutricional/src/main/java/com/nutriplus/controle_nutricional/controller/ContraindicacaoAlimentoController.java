package com.nutriplus.controle_nutricional.controller;

import com.nutriplus.controle_nutricional.dto.*;
import com.nutriplus.controle_nutricional.service.ContraindicacaoAlimentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contraindicacoes-alimentos")
public class ContraindicacaoAlimentoController {

    private final ContraindicacaoAlimentoService service;

    public ContraindicacaoAlimentoController(ContraindicacaoAlimentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ContraindicacaoAlimentoResponseDTO> save(@Valid @RequestBody ContraindicacaoAlimentoRequestDTO dto) {
        ContraindicacaoAlimentoResponseDTO saved = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<ContraindicacaoAlimentoResponseDTO> findAll() {
        return service.findAll();
    }
}
