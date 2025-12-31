package com.clinica.controle_producao.DTO;

import java.time.DayOfWeek;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoDTO {

    private Long idAtendimento;
    private LocalDate dataAtendimento;
    private DayOfWeek diaSemana;
    private int tempoAtendimento;
    private boolean tea;
    private boolean statusAtendimento;

    // Dados do Profissional
    private Long idProfissional;
    private String nomeProfissional;
    private String especialidade;

    // Dados do Paciente
    private Long idPaciente;
    private String nomePaciente;
    
}
