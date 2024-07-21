package com.example.catalogo.Model.Desenho;

import java.sql.Date;
import java.util.Base64;

public record DesenhoResponseDTO(Long id, String nome, String autor, String descricao, String disponibilidade, String estudio, int maxeps,
                                 Date mesAno, String nacionalidade, String status, String StatusVisto, int temps, String imagem) {

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
                desenho.getTemps(),
                Base64.getEncoder().encodeToString(desenho.getImagem()));
    }
}