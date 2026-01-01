package com.clinica.controle_producao.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atendimento")
public class Atendimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_atendimento")
    private Long idAtendimento;

    // Data de atendimento
    @Column(name = "data_atendimento")
    private LocalDate dataAtendimento;

    // Dia da semana (SEGUNDA, TERCA, etc.)
    @Column(name = "dia_semana")
    private DayOfWeek diaSemana;

    // Tempo de atendimento em minutos 40 min ou 60 min
    @Column(name = "tempo_atendimento")
    private int tempoAtendimento;

    // Se paciente é TEA ou não
    @Column(name = "tea")
    private boolean tea;

    // especialidade
    @Column(name="especialidade")
    private String especialidade;

    // Status do atendimento (atendido ou não)
    @Column(name = "status_atendimento")
    private boolean statusAtendimento;

    // Relacionamento com paciente
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    // Relacionamento com profissional
    @ManyToOne
    @JoinColumn(name = "id_profissional", nullable = false)
    private Profissional profissional;

}
