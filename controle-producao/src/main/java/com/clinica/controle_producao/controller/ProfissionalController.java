package com.clinica.controle_producao.controller;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.controle_producao.DTO.ProfissionalDTO;
import com.clinica.controle_producao.service.ProfissionalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profissionais")
@RequiredArgsConstructor
public class ProfissionalController {

    private final ProfissionalService service;
    
    @PostMapping
    public ResponseEntity<@Nullable Object> criarProfissional(@RequestBody ProfissionalDTO profissionalDTO) {
        // Lógica para criar um novo profissional
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(profissionalDTO));
    }
}
