package com.example.catalogo.Serie;

public record SerieRequestDTO(Long id, String nome, String descricao, String autor,
                              String estudio, String status, String disponibilidade,
                              int temps, int maxEps, String statusVisto) {
}
