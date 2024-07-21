package com.example.catalogo.Model.Filme;

import java.sql.Date;

public record FilmeRequestDTO(Long id, String nome, String descricao, String autor,
                              String estudio, String disponibilidade, String statusVisto,
                              int duracao, Date mesAno, String imagem) {
}
