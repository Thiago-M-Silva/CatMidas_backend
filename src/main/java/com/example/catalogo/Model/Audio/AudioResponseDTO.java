package com.example.catalogo.Model.Audio;

public record AudioResponseDTO(Long id, String nome, String autor, String descricao, String estudio,
                               String disponibilidade, String StatusVisto, Long duracao, String tipo) {

    public AudioResponseDTO(Audio audio){
        this(audio.getId(),
                audio.getNome(),
                audio.getAutor(),
                audio.getDescricao(),
                audio.getEstudio(),
                audio.getDisponibilidade(),
                audio.getStatusVisto(),
                audio.getDuracao(),
                audio.getTipo());
    }
}
