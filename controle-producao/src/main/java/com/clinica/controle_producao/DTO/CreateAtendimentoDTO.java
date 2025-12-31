package com.clinica.controle_producao.DTO;

import java.math.BigDecimal;
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
public class CreateAtendimentoDTO {
    
    private Long idAtendimento;
    private LocalDate dataAtendimento;
    private DayOfWeek diaSemana;
    private BigDecimal valorAtendimento;
    private int tempoAtendimento;
    private boolean tea;

    // Dados do Profissional
    private Long idProfissional;
    private String nomeProfissional;
    private String especialidade;

    // Dados do Paciente
    private Long idPaciente;
    private String nomePaciente;

}
