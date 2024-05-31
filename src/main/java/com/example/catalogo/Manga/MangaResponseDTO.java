package com.example.catalogo.Manga;

public record MangaResponseDTO(Long id, String nome, String descricao, String autor,
                               String status, int qtdCaps, String statusLido, String nacionalidade) {
    public MangaResponseDTO(Manga manga){
        this(manga.getId(),
                manga.getNome(),
                manga.getDescricao(),
                manga.getAutor(),
                manga.getStatus(),
                manga.getQtdCaps(),
                manga.getStatusLido(),
                manga.getNacionalidade());
    }
}
