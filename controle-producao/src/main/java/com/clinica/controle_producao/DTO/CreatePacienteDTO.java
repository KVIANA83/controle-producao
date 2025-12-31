package com.clinica.controle_producao.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePacienteDTO {
    
    private Long idPaciente;
    private String nomePaciente;
    private boolean tea;

}
