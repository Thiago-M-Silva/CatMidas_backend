package com.example.catalogo.Model.Livro;

import java.sql.Date;

public record LivroRequestDTO(Long id, String nome, String descricao, String autor,
                              String statusVisto, int paginas, Date mesAno, String imagem) {
}
