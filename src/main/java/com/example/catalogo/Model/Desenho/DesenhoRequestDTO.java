package com.example.catalogo.Model.Desenho;

import java.sql.Date;

public record DesenhoRequestDTO(Long id, String nome, String autor, String descricao, String disponibilidade, String estudio, int maxeps,
                                Date mesAno, String nacionalidade, String status, String StatusVisto, int temps) {
}
