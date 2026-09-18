package com.nutriplus.tabela_nutricional.controller;

import com.nutriplus.tabela_nutricional.dto.RegistroExercicioRequestDTO;
import com.nutriplus.tabela_nutricional.dto.RegistroExercicioResponseDTO;
import com.nutriplus.tabela_nutricional.service.RegistroExercicioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros-exercicios")
public class RegistroExercicioController {

    private final RegistroExercicioService service;

    public RegistroExercicioController(RegistroExercicioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RegistroExercicioResponseDTO> create(@Valid @RequestBody RegistroExercicioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<RegistroExercicioResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
