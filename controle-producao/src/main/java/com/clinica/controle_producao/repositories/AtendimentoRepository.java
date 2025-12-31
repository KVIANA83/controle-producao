package com.clinica.controle_producao.repositories;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.controle_producao.model.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    
    List<Atendimento> findByIdAtendimento(Long idAtendimento);

    List<Atendimento> findByStatusAtendimento(Boolean statusAtendimento);

    List<Atendimento> findByDiaSemana(DayOfWeek diaSemana);

    List<Atendimento> findByEspecialidade(String especialidade);

    List<Atendimento> findByTea(Boolean tea);
    
}
