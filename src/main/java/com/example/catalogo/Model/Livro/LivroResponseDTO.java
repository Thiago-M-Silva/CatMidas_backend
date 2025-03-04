package com.example.catalogo.Model.Livro;

import java.sql.Date;
import java.util.Base64;

public record LivroResponseDTO(Long id, String nome, String descricao, String autor,
                               String statusVisto, int paginas, Date mesAno, Boolean favorito,
                               String imagem) {
    public LivroResponseDTO(Livro livro){
        this(livro.getId(),
                livro.getNome(),
                livro.getAutor(),
                livro.getDescricao(),
                livro.getStatusVisto(),
                livro.getPaginas(),
                livro.getMesAno(),
                livro.getFavorito(),
                livro.getImagem());
    }
}
