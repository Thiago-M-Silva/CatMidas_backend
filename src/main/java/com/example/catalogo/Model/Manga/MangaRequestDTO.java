package com.example.catalogo.Model.Manga;

import java.sql.Date;

public record MangaRequestDTO(Long id, String nome, String descricao, String autor,
                              String status, int qtdCaps, String statusLido, String nacionalidade, Date mesAno, String imagem) {
}
