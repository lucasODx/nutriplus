package com.nutriplus.controle_nutricional.controller;

import com.nutriplus.controle_nutricional.dto.DiarioAlimentarRequestDTO;
import com.nutriplus.controle_nutricional.dto.DiarioAlimentarResponseDTO;
import com.nutriplus.controle_nutricional.entity.DiarioAlimentar;
import com.nutriplus.controle_nutricional.service.DiarioAlimentarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diarios-alimentares")
public class DiarioAlimentarController {

    private final DiarioAlimentarService service;

    public DiarioAlimentarController(DiarioAlimentarService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DiarioAlimentarResponseDTO> create(@Valid @RequestBody DiarioAlimentarRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<DiarioAlimentar>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}
