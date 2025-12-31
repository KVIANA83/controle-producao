package com.clinica.controle_producao.service;

import java.time.DayOfWeek;

import org.springframework.stereotype.Service;

import com.clinica.controle_producao.DTO.AtendimentoDTO;
import com.clinica.controle_producao.DTO.CreateAtendimentoDTO;
import com.clinica.controle_producao.model.Atendimento;
import com.clinica.controle_producao.model.Paciente;
import com.clinica.controle_producao.model.Profissional;
import com.clinica.controle_producao.repositories.AtendimentoRepository;
import com.clinica.controle_producao.repositories.PacienteRepository;
import com.clinica.controle_producao.repositories.ProfissionalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtendimentoService {
    
    private final AtendimentoRepository atendimentoRepository;
    private final PacienteRepository pacienteRepository;
    private final ProfissionalRepository profissionalRepository;

    public AtendimentoDTO criarAtendimento(CreateAtendimentoDTO dto, boolean statusAtendimento) {

        Paciente paciente = pacienteRepository.findById(dto.getIdPaciente())
            .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Profissional profissional = profissionalRepository.findByIdProfissional(dto.getIdProfissional())
            .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        boolean tea = paciente.isTea();
        int tempoAtendimento = tea ? 60 : 40;
        DayOfWeek diaSemana = dto.getDataAtendimento().getDayOfWeek();

        /* 
        boolean isStatusAtendimento;
        Atendimento atendimento = atendimento.builder()
                .dataAtendimento(dto.getDataAtendimento())
                .diaSemana(dto.getDiaSemana())
                .tempoAtendimento(tempoAtendimento)
                .tea(dto.isTea())
                .statusAtendimento(isStatusAtendimento)
                .paciente(dto.getIdPaciente())
                .profissional(dto.getIdProfissional())
                .build();
        */

        Atendimento atendimento = Atendimento.builder()
                .dataAtendimento(dto.getDataAtendimento())
                .diaSemana(diaSemana)
                .tempoAtendimento(tempoAtendimento)
                .tea(tea)
                .statusAtendimento(statusAtendimento)
                .paciente(paciente)
                .profissional(profissional)
                .build();

        Atendimento salvo = atendimentoRepository.save(atendimento);
        return toDTO(salvo);
        
    }

    private AtendimentoDTO toDTO(Atendimento atendimento) {
        return AtendimentoDTO.builder()
                .idAtendimento(atendimento.getIdAtendimento())
                .dataAtendimento(atendimento.getDataAtendimento())
                .diaSemana(atendimento.getDiaSemana())
                .tempoAtendimento(atendimento.getTempoAtendimento())
                .tea(atendimento.isTea())
                .statusAtendimento(atendimento.isStatusAtendimento())
                .idPaciente(atendimento.getPaciente().getIdPaciente())
                .nomePaciente(atendimento.getPaciente().getNomePaciente())
                .idProfissional(atendimento.getProfissional().getIdProfissional())
                .nomeProfissional(atendimento.getProfissional().getNomeProfissional())
                .build();
    }

}
