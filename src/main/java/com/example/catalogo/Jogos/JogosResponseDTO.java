package com.example.catalogo.Jogos;

public record JogosResponseDTO(Long id, String nome, String autor, String descricao, String estudio,
                               String disponibilidade, String StatusVisto, Long duracaoMedia) {
    public JogosResponseDTO(Jogos jogos){
        this(jogos.getId(),
                jogos.getNome(),
                jogos.getAutor(),
                jogos.getDescricao(),
                jogos.getEstudio(),
                jogos.getDisponibilidade(),
                jogos.getStatusVisto(),
                jogos.getDuracaoMedia());
    }
}
