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

import com.clinica.controle_producao.DTO.CreatePacienteDTO;
import com.clinica.controle_producao.DTO.PacienteDTO;
import com.clinica.controle_producao.service.PacienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {
    
    private final PacienteService pacienteService;

        // Criar paciente
    @PostMapping
    public ResponseEntity<PacienteDTO> criar(@RequestBody CreatePacienteDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pacienteService.criarPaciente(dto));
    }

    // Buscar por ID
    @GetMapping("/paciente{id}")
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    // Buscar por nome
    @GetMapping("/paciente/{nome}")
    public ResponseEntity<PacienteDTO> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(pacienteService.buscarPorNome(nome));
    }

    // Buscar por TEA
    @GetMapping("/paciente/{tea}")
    public ResponseEntity<List<PacienteDTO>> buscarPorTea(@PathVariable boolean tea) {
        return ResponseEntity.ok(pacienteService.buscarPorTea(tea));
    }

}
