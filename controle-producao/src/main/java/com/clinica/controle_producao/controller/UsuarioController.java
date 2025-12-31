package com.clinica.controle_producao.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.controle_producao.DTO.CreateUsuarioDTO;
import com.clinica.controle_producao.DTO.LoginDTO;
import com.clinica.controle_producao.DTO.UsuarioDTO;
import com.clinica.controle_producao.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    
    // Criar usuario
    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody CreateUsuarioDTO dto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(usuarioService.criarUsuario(dto));
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody LoginDTO dto) {
        return ResponseEntity
            .ok(usuarioService.login(dto));
    }
    
}
