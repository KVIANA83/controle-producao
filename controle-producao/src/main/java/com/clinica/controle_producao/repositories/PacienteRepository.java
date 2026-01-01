package com.clinica.controle_producao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.controle_producao.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
    Optional <Paciente> findByIdPaciente(Long idPaciente);

    Optional <Paciente> findByNomePaciente(String nomePaciente);

    Optional <Paciente> findByTea(Boolean tea);

    Object findByIdAtendimento(Long idAtendimento);
    
}
