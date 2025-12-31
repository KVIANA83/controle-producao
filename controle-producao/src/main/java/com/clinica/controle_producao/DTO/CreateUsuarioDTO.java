package com.clinica.controle_producao.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUsuarioDTO {
    
    private String login;
    private String senha;
    private String funcao;
    
}
