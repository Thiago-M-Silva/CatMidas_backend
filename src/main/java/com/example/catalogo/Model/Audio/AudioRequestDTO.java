package com.example.catalogo.Model.Audio;

import java.sql.Date;

public record AudioRequestDTO(Long id, String nome, String autor, String descricao, String estudio,
                              String disponibilidade, String StatusVisto, Long duracao, String tipo, Date mesAno, String imagem) {
}
