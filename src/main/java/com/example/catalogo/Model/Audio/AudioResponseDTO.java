package com.example.catalogo.Model.Audio;

import java.sql.Date;
import java.util.Base64;

public record AudioResponseDTO(Long id, String nome, String autor, String descricao, String estudio,
                               String disponibilidade, String StatusVisto, Long duracao, String tipo,
                               Date mesAno, Boolean favorito, String imagem) {

    public AudioResponseDTO(Audio audio){
        this(audio.getId(),
                audio.getNome(),
                audio.getAutor(),
                audio.getDescricao(),
                audio.getEstudio(),
                audio.getDisponibilidade(),
                audio.getStatusVisto(),
                audio.getDuracao(),
                audio.getTipo(),
                audio.getMesAno(),
                audio.getFavorito(),
                Base64.getEncoder().encodeToString(audio.getImagem()));
    }
}
