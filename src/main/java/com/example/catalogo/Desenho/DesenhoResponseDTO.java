package com.example.catalogo.Desenho;

import java.sql.Date;

public record DesenhoResponseDTO(Long id, String nome, String autor, String descricao, String disponibilidade, String estudio, int maxeps,
                                 Date mesAno, String nacionalidade, String status, String StatusVisto, int temps) {

    public DesenhoResponseDTO(Desenho desenho){
        this(desenho.getId(),
                desenho.getNome(),
                desenho.getAutor(),
                desenho.getDescricao(),
                desenho.getDisponibilidade(),
                desenho.getEstudio(),
                desenho.getMaxEps(),
                desenho.getMesAno(),
                desenho.getNacionalidade(),
                desenho.getStatus(),
                desenho.getStatusVisto(),
                desenho.getTemps());
    }
}