package com.example.catalogo.Model.Novela;

import java.sql.Date;
import java.util.Base64;

public record NovelaResponseDTO(Long id, String nome, String descricao, String autor,
                                String estudio, String status, String disponibilidade,
                                int maxEps, String statusVisto, Date mesAno, Boolean favorito,
                                String imagem) {
    public NovelaResponseDTO(Novela novela){
        this(novela.getId(),
                novela.getNome(),
                novela.getDescricao(),
                novela.getAutor(),
                novela.getEstudio(),
                novela.getStatus(),
                novela.getDisponibilidade(),
                novela.getMaxEps(),
                novela.getStatusVisto(),
                novela.getMesAno(),
                novela.getFavorito(),
                novela.getImagem());
    }
}
