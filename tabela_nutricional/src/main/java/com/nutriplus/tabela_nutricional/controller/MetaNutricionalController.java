package com.nutriplus.tabela_nutricional.controller;

import com.nutriplus.tabela_nutricional.dto.MetaNutricionalRequestDTO;
import com.nutriplus.tabela_nutricional.dto.MetaNutricionalResponseDTO;
import com.nutriplus.tabela_nutricional.service.MetaNutricionalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas-nutricionais")
public class MetaNutricionalController {

    private final MetaNutricionalService service;

    public MetaNutricionalController(MetaNutricionalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MetaNutricionalResponseDTO> create(@Valid @RequestBody MetaNutricionalRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<MetaNutricionalResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
