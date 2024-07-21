package com.example.catalogo.Model.Filme;

import java.sql.Date;
import java.util.Base64;

public record FilmeResponseDTO(Long id, String nome, String descricao, String auto,
                               String estudio, String disponibilidade, String statusVisto,
                               int duracao, Date mesAno, String imagem) {
    public FilmeResponseDTO(Filme filme){
        this(filme.getId(),
                filme.getNome(),
                filme.getAutor(),
                filme.getDescricao(),
                filme.getDisponibilidade(),
                filme.getEstudio(),
                filme.getStatusVisto(),
                filme.getDuracao(),
                filme.getMesAno(),
                Base64.getEncoder().encodeToString(filme.getImagem()));
    }
}
