package com.clinica.controle_producao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.controle_producao.model.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{
    
    Optional<Profissional> findByIdProfissional(Long idProfissional);

    Optional<Profissional> findByNomeProfissional(String nomeProfissional);

    Optional<Profissional> findByEspecialidade(String especialidade);

}
