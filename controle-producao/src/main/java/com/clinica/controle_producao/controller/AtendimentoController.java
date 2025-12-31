package com.clinica.controle_producao.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.controle_producao.DTO.AtendimentoDTO;
import com.clinica.controle_producao.DTO.CreateAtendimentoDTO;
import com.clinica.controle_producao.service.AtendimentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/atendimento")
@RequiredArgsConstructor
public class AtendimentoController {
    
    private final AtendimentoService atendimentoService;

    @PostMapping
    public ResponseEntity<AtendimentoDTO> criar(@RequestBody CreateAtendimentoDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(atendimentoService.criarAtendimento(dto, false));
    }
    
}
