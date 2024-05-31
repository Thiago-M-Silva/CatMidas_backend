package com.example.catalogo.Audio;

public record AudioRequestDTO(Long id, String nome, String autor, String descricao, String estudio,
                              String disponibilidade, String StatusVisto, Long duracao, String tipo) {
}
