package com.nutriplus.controle_nutricional.controller;

import com.nutriplus.controle_nutricional.entity.Alimento;
import com.nutriplus.controle_nutricional.repository.AlimentoRepository;
import com.nutriplus.controle_nutricional.service.AlimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/alimentos")
public class AlimentoController {

    private final AlimentoService service;

    public AlimentoController(AlimentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Alimento> save(@RequestBody Alimento alimento) {
        Alimento saved = service.save(alimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
