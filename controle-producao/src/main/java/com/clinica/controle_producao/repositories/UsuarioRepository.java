package com.clinica.controle_producao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.controle_producao.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional <Usuario> findByIdUsuario(Long idUsuario);

    Optional <Usuario> findByLogin(String login);

    Optional <Usuario> findByFuncao(String funcao);

}
