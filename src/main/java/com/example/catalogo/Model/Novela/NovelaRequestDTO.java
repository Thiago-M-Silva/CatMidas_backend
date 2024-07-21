package com.example.catalogo.Model.Novela;

import java.sql.Date;

public record NovelaRequestDTO(Long id, String nome, String descricao, String autor,
                               String estudio, String status, String disponibilidade,
                               int maxEps, String statusVisto, Date mesAno, String imagem) {
}
