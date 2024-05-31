package com.example.catalogo.Novela;

public record NovelaRequestDTO(Long id, String nome, String descricao, String autor,
                               String estudio, String status, String disponibilidade,
                               int maxEps, String statusVisto) {
}
