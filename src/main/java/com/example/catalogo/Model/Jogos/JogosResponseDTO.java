package com.example.catalogo.Model.Jogos;

import java.sql.Date;
import java.util.Base64;

public record JogosResponseDTO(Long id, String nome, String autor, String descricao, String estudio,
                               String disponibilidade, String StatusVisto, Long duracaoMedia, Date mesAno,
                               Boolean favorito, String imagem) {
    public JogosResponseDTO(Jogos jogos){
        this(jogos.getId(),
                jogos.getNome(),
                jogos.getAutor(),
                jogos.getDescricao(),
                jogos.getEstudio(),
                jogos.getDisponibilidade(),
                jogos.getStatusVisto(),
                jogos.getDuracaoMedia(),
                jogos.getMesAno(),
                jogos.getFavorito(),
                Base64.getEncoder().encodeToString(jogos.getImagem()));
    }
}
