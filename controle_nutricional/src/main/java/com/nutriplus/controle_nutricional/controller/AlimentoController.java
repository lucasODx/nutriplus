package com.nutriplus.controle_nutricional.controller;

import com.nutriplus.controle_nutricional.dto.AlimentoRequestDTO;
import com.nutriplus.controle_nutricional.dto.AlimentoResponseDTO;
import com.nutriplus.controle_nutricional.service.AlimentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {

    private final AlimentoService service;

    public AlimentoController(AlimentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AlimentoResponseDTO> save(@Valid @RequestBody AlimentoRequestDTO dto) {
        AlimentoResponseDTO saved = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<AlimentoResponseDTO> findAll() {
        return service.findAll();
    }
}
