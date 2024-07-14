package com.example.catalogo.Model.Serie;

public record SerieRequestDTO(Long id, String nome, String descricao, String autor,
                              String estudio, String status, String disponibilidade,
                              int temps, int maxEps, String statusVisto) {
}
