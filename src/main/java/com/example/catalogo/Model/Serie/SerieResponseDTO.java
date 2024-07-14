package com.example.catalogo.Model.Serie;

public record SerieResponseDTO(Long id, String nome, String descricao, String autor,
                               String estudio, String status, String disponibilidade,
                               int temps, int maxEps, String statusVisto) {
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
                serie.getStatusVisto());
    }
}
