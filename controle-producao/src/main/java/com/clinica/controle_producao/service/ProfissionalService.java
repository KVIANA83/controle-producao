package com.clinica.controle_producao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clinica.controle_producao.DTO.ProfissionalDTO;
import com.clinica.controle_producao.model.Profissional;
import com.clinica.controle_producao.repositories.ProfissionalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfissionalService {
    
    private static final ProfissionalRepository profissionalRepository = null;

    // Criar profissional
    public ProfissionalDTO criarProfissional(ProfissionalDTO dto) {

        Profissional profissional = new Profissional();
        profissional.setNomeProfissional(dto.getNomeProfissional());
        profissional.setEspecialidade(dto.getEspecialidade());

        Profissional salvo = profissionalRepository.save(profissional);

        return toDTO(salvo);
    }

    // Buscar profissional por ID
    public List<ProfissionalDTO> buscarPorId(Long idProfissional) {

        Profissional profissional = profissionalRepository.findByIdProfissional(idProfissional)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        return List.of(toDTO(profissional));

    }

    // Listar todos os profissionais
    public List<ProfissionalDTO> listarTodos() {
        List<Profissional> profissionais = profissionalRepository.findAll();
        return profissionais.stream().map(this::toDTO).toList();
    }

    // Buscar profissional por especialidade
    public List<ProfissionalDTO> buscarPorEspecialidade(String especialidade) {
        Profissional profissional = profissionalRepository.findByEspecialidade(especialidade)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        return List.of(toDTO(profissional));
    }

    // Buscar profissional por nome
    public List<ProfissionalDTO> buscarPorNome(String nomeProfissional) {
        Profissional profissional = profissionalRepository.findByNomeProfissional(nomeProfissional)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        return List.of(toDTO(profissional));
    }

    // Conversão Entity → DTO
    private ProfissionalDTO toDTO(Profissional profissional) {
        return ProfissionalDTO.builder()
                .idProfissional(profissional.getIdProfissional())
                .nomeProfissional(profissional.getNomeProfissional())
                .especialidade(profissional.getEspecialidade())
                .build();
    }

}
