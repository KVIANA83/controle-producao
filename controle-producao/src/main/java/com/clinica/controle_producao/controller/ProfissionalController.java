package com.clinica.controle_producao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.controle_producao.DTO.ProfissionalDTO;
import com.clinica.controle_producao.service.ProfissionalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profissional")
@RequiredArgsConstructor
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    // Endpoint para criar um novo profissional
    @PostMapping
    public ResponseEntity<ProfissionalDTO> criar(@RequestBody ProfissionalDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profissionalService.criarProfissional(dto));
    }

    // Listar todos os profissionais
    @GetMapping
    public ResponseEntity<List<ProfissionalDTO>> listar() {
        return ResponseEntity.ok(profissionalService.listarTodos());
    }

    // Listar profissionais por ID
    @GetMapping("/profissional/{id}")
    public ResponseEntity<List<ProfissionalDTO>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(profissionalService.buscarPorId(id));
    }

    // Listar profissionais por especialidade
    @GetMapping("/profissional/{especialidade}")
    public ResponseEntity<List<ProfissionalDTO>> buscarPorEspecialidade(@PathVariable String especialidade) {
        return ResponseEntity.ok(profissionalService.buscarPorEspecialidade(especialidade));
    }

    // Listar profissionais por nome
    @GetMapping("/profissional/{nomeProfissional}")
    public ResponseEntity<List<ProfissionalDTO>> buscarPorNome(@PathVariable String nomeProfissional) {
        return ResponseEntity.ok(profissionalService.buscarPorNome(nomeProfissional));
    }

}
