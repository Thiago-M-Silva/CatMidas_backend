package com.example.catalogo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    /*
        classe para lancamento de excecoes genericas ou personalizadas.
        posteriormente implementar excecoes para o sistema.
        crie classes personalizadas para o tratamento de erros.
    */
    @ExceptionHandler(CatalogoException.class)
    private ResponseEntity<RestErrorMessage> catalogoExceptionHandler(CatalogoException exception){
        RestErrorMessage threatedMessage = new RestErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatedMessage);
    }
}
