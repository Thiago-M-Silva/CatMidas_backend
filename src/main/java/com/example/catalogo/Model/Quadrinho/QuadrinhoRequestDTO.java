package com.example.catalogo.Model.Quadrinho;

import java.sql.Date;

public record QuadrinhoRequestDTO(Long id, String nome, String descricao, String autor,
                                  String status, int qtdCaps, String statusLido, String nacionalidade, Date mesAno,
                                  Boolean favorito, String imagem) {
}
