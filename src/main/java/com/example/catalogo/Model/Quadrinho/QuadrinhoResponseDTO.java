package com.example.catalogo.Model.Quadrinho;

import java.sql.Date;
import java.util.Base64;

public record QuadrinhoResponseDTO(Long id, String nome, String descricao, String autor,
                                   String status, int qtdCaps, String statusLido, String nacionalidade,
                                   Date mesAno, Boolean favorito, String imagem) {
    public QuadrinhoResponseDTO(Quadrinho quadrinho){
        this(quadrinho.getId(),
                quadrinho.getNome(),
                quadrinho.getDescricao(),
                quadrinho.getAutor(),
                quadrinho.getStatus(),
                quadrinho.getQtdCaps(),
                quadrinho.getStatusLido(),
                quadrinho.getNacionalidade(),
                quadrinho.getMesAno(),
                quadrinho.getFavorito(),
                Base64.getEncoder().encodeToString(quadrinho.getImagem()));
    }
}
