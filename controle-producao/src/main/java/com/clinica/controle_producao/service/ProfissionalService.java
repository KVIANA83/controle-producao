package com.clinica.controle_producao.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.clinica.controle_producao.DTO.ProfissionalDTO;
import com.clinica.controle_producao.exceptions.ValidacaoException;
import com.clinica.controle_producao.model.Profissional;
import com.clinica.controle_producao.repositories.ProfissionalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfissionalService {
    
    private final ProfissionalRepository repository;

    public Profissional salvar(ProfissionalDTO profissionalDTO) {
        if (profissionalDTO.getNomeProfissional() == null || profissionalDTO.getNomeProfissional().isBlank()) {
            throw new ValidacaoException("Nome do profissional é obrigatório");
        }
        return repository.salvar(profissionalDTO);
    }

    public List<Profissional> listarTodos() {
        return repository.findAll();
    }

    public Profissional buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Profissional não encontrado"));
    }

    public void deletar(Long id) {
        buscarPorId(id); // valida se existe
        repository.deleteById(id);
    }

    public static Object toEntity(ProfissionalDTO profissionalDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    public @Nullable Object save(Object entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    
}
