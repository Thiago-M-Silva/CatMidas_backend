package com.example.catalogo.Model.Livro;

public record LivroRequestDTO(Long id, String nome, String descricao, String autor,
                              String statusVisto, int paginas) {
}
