package com.example.catalogo.Model.Manga;

public record MangaRequestDTO(Long id, String nome, String descricao, String autor,
                              String status, int qtdCaps, String statusLido, String nacionalidade) {
}
