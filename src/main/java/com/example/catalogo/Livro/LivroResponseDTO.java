package com.example.catalogo.Livro;

public record LivroResponseDTO(Long id, String nome, String descricao, String autor,
                                String statusVisto, int paginas) {
    public LivroResponseDTO(Livro livro){
        this(livro.getId(),
                livro.getNome(),
                livro.getAutor(),
                livro.getDescricao(),
                livro.getStatusVisto(),
                livro.getPaginas());
    }
}
