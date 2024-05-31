package com.example.catalogo.Jogos;

public record JogosRequestDTO(Long id, String nome, String autor, String descricao, String estudio,
                              String disponibilidade, String StatusVisto, Long duracaoMedia) {
}
