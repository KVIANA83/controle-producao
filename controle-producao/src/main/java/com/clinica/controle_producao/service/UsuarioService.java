package com.clinica.controle_producao.service;

import org.springframework.stereotype.Service;

import com.clinica.controle_producao.DTO.CreateUsuarioDTO;
import com.clinica.controle_producao.DTO.LoginDTO;
import com.clinica.controle_producao.DTO.UsuarioDTO;
import com.clinica.controle_producao.model.Usuario;
import com.clinica.controle_producao.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    // Criar usuario
    public UsuarioDTO criarUsuario(CreateUsuarioDTO dto) {

        usuarioRepository.findByLogin(dto.getLogin())
            .ifPresent(u -> {
                throw new RuntimeException("Login ja existente");
            });

        Usuario usuario = Usuario.builder()
            .login(dto.getLogin())
            .funcao(dto.getFuncao().toUpperCase())
            .senha(dto.getSenha())
            .build();

        Usuario salvo = usuarioRepository.save(usuario);
        return toDTO(salvo);
    }

    // Login
    public UsuarioDTO login(LoginDTO dto) {
        Usuario usuario = usuarioRepository.findByLogin(dto.getLogin())
                .orElseThrow(() -> new RuntimeException("Login inválido"));

        if (!usuario.getSenha().equals(dto.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        return toDTO(usuario);
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .idUsuario(usuario.getIdUsuario())
                .login(usuario.getLogin())
                .funcao(usuario.getFuncao())
                .build();
    }
}
