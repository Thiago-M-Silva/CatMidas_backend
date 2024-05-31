package com.example.catalogo.Filme;

public record FilmeResponseDTO(Long id, String nome, String descricao, String auto,
                               String estudio, String disponibilidade, String statusVisto,
                               int duracao) {
    public FilmeResponseDTO(Filme filme){
        this(filme.getId(),
                filme.getNome(),
                filme.getAutor(),
                filme.getDescricao(),
                filme.getDisponibilidade(),
                filme.getEstudio(),
                filme.getStatusVisto(),
                filme.getDuracao());
    }
}
