package com.example.catalogo.Model.Filme;

public record FilmeRequestDTO(Long id, String nome, String descricao, String autor,
                              String estudio, String disponibilidade, String statusVisto,
                              int duracao) {
}
