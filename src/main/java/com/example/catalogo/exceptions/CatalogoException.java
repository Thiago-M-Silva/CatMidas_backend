package com.example.catalogo.exceptions;

public class CatalogoException extends RuntimeException{
    public CatalogoException() {super("Deu erro");}

    public CatalogoException(String message) {super(message);}
}
