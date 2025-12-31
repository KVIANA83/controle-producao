package com.clinica.controle_producao.repositories;

import java.time.DayOfWeek;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.controle_producao.model.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    
    Optional <Atendimento> findByIdAtendimento(Long idAtendimento);

    Optional <Atendimento> findByStatusAtendimento(Boolean statusAtendimento);

    Optional <Atendimento> findByDiaSemana(DayOfWeek diaSemana);

    Optional <Atendimento> findByEspecialidade(String especialidade);

    Optional <Atendimento> findByTea(Boolean tea);
    
}
