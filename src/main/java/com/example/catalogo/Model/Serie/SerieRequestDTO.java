package com.example.catalogo.Model.Serie;

import java.sql.Date;

public record SerieRequestDTO(Long id, String nome, String descricao, String autor,
                              String estudio, String status, String disponibilidade,
                              int temps, int maxEps, String statusVisto, Date mesAno,
                              Boolean favorito, String imagem) {
}
