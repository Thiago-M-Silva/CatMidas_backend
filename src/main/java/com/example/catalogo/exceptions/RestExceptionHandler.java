package com.example.catalogo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    /*
        classe para lancamento de excecoes genericas ou personalizadas.
        posteriormente implementar excecoes para o sistema.
        crie classes personalizadas para o tratamento de erros.
    */
    @ExceptionHandler(CatalogoException.class)
    private ResponseEntity<RestErrorMessage> catalogoExceptionHandlerNF(CatalogoException exception){
        RestErrorMessage threatedMessage = new RestErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatedMessage);
    }

    @ExceptionHandler(CatalogoException.class)
    private ResponseEntity<RestErrorMessage> catalogoExceptionHandlerBR(CatalogoException exception){
        RestErrorMessage threatedMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatedMessage);
    }

    @ExceptionHandler(CatalogoException.class)
    private ResponseEntity<RestErrorMessage> catalogoExceptionHandlerNC(CatalogoException exception){
        RestErrorMessage threatedMessage = new RestErrorMessage(HttpStatus.NO_CONTENT,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(threatedMessage);
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorMessage> globalExceptionHandler(Exception exception, WebRequest request) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred: " + exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
