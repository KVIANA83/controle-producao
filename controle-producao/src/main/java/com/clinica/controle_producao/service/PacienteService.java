package com.clinica.controle_producao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clinica.controle_producao.DTO.CreatePacienteDTO;
import com.clinica.controle_producao.DTO.PacienteDTO;
import com.clinica.controle_producao.model.Paciente;
import com.clinica.controle_producao.repositories.PacienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository PacienteRepository;

    // Criar paciente
    public PacienteDTO criarPaciente(CreatePacienteDTO dto) {
        Paciente paciente = Paciente.builder()
                .nomePaciente(dto.getNomePaciente())
                .tea(dto.isTea())
                .build();
        
        Paciente salvo = PacienteRepository.save(paciente);
        return toDTO(salvo);
    }
    
    // Buscar paciente por ID
    public PacienteDTO buscarPorId(Long idPaciente) {
        Paciente paciente = PacienteRepository.findByIdPaciente(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        return toDTO(paciente);
    }

    // Listar todos os pacientes
    public List<PacienteDTO> ListarTodos() {
        return PacienteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }
    
    // Buscar paciente por nome
    public PacienteDTO buscarPorNome(String nome) {
        Paciente paciente = PacienteRepository.findByNomePaciente(nome)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        return toDTO(paciente);
    }

    // Buscar por TEA
    public List<PacienteDTO> buscarPorTea(boolean tea) {
        return PacienteRepository.findAll().stream()
                .filter(p -> p.isTea() == tea)
                .map(this::toDTO)
                .toList();
    }

    private PacienteDTO toDTO(Paciente paciente) {
        return PacienteDTO.builder()
                .idPaciente(paciente.getIdPaciente())
                .nomePaciente(paciente.getNomePaciente())
                .tea(paciente.isTea())
                .build();
    }
    
}
