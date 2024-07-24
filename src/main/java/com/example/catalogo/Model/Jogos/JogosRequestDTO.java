package com.example.catalogo.Model.Jogos;

import java.sql.Date;

public record JogosRequestDTO(Long id, String nome, String autor, String descricao, String estudio,
                              String disponibilidade, String StatusVisto, Long duracaoMedia, Date mesAno,
                              Boolean favorito, String imagem) {
}
