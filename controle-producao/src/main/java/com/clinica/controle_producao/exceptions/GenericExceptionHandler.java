package com.clinica.controle_producao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(ValidacaoException.class)
    public final ResponseEntity <ErrorBody> lancaExcessao(ValidacaoException ex) {
        
        ErrorBody errorBody = ErrorBody.builder()
            .message(ex.getMessage())
            .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }
}
