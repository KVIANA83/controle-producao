package com.clinica.controle_producao.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProfissionalDTO {
    
    private Long idProfissional;
    private String nomeProfissional;
    private String especialidade;

}
