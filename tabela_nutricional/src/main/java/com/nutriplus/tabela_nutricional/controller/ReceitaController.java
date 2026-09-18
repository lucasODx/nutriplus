package com.nutriplus.tabela_nutricional.controller;

import com.nutriplus.tabela_nutricional.dto.ReceitaRequestDTO;
import com.nutriplus.tabela_nutricional.dto.ReceitaResponseDTO;
import com.nutriplus.tabela_nutricional.entity.enums.DificuldadeEnum;
import com.nutriplus.tabela_nutricional.service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    private final ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReceitaResponseDTO> create(@Valid @RequestBody ReceitaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ReceitaResponseDTO>> findAll(
            @RequestParam(required = false) DificuldadeEnum dificuldade,
            @RequestParam(required = false) String nome) {

        if (dificuldade != null) {
            return ResponseEntity.ok(service.findByDificuldade(dificuldade));
        }
        if (nome != null && !nome.isBlank()) {
            return ResponseEntity.ok(service.findByNome(nome));
        }
        return ResponseEntity.ok(service.findAll());
    }
}
