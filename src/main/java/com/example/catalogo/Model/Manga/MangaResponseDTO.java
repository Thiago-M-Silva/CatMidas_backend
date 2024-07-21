package com.example.catalogo.Model.Manga;

import java.sql.Date;
import java.util.Base64;

public record MangaResponseDTO(Long id, String nome, String descricao, String autor,
                               String status, int qtdCaps, String statusLido, String nacionalidade, Date mesAno, String imagem) {
    public MangaResponseDTO(Manga manga){
        this(manga.getId(),
                manga.getNome(),
                manga.getDescricao(),
                manga.getAutor(),
                manga.getStatus(),
                manga.getQtdCaps(),
                manga.getStatusLido(),
                manga.getNacionalidade(),
                manga.getMesAno(),
                Base64.getEncoder().encodeToString(manga.getImagem()));
    }
}
