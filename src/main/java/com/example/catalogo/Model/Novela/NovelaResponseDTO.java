package com.example.catalogo.Model.Novela;

public record NovelaResponseDTO(Long id, String nome, String descricao, String autor,
                                String estudio, String status, String disponibilidade,
                                int maxEps, String statusVisto) {
    public NovelaResponseDTO(Novela novela){
        this(novela.getId(),
                novela.getNome(),
                novela.getDescricao(),
                novela.getAutor(),
                novela.getEstudio(),
                novela.getStatus(),
                novela.getDisponibilidade(),
                novela.getMaxEps(),
                novela.getStatusVisto());
    }
}
