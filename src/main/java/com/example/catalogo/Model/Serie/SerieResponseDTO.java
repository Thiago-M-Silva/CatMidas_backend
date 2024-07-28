package com.example.catalogo.Model.Serie;

import java.sql.Date;
import java.util.Base64;

public record SerieResponseDTO(Long id, String nome, String descricao, String autor,
                               String estudio, String status, String disponibilidade,
                               int temps, int maxEps, String statusVisto, Date mesAno,
                               Boolean favorito, String imagem) {
    public SerieResponseDTO(Serie serie){
        this(serie.getId(),
                serie.getNome(),
                serie.getDescricao(),
                serie.getAutor(),
                serie.getEstudio(),
                serie.getStatus(),
                serie.getDisponibilidade(),
                serie.getTemps(),
                serie.getMaxEps(),
                serie.getStatusVisto(),
                serie.getMesAno(),
                serie.getFavorito(),
                serie.getImagem());
    }
}
