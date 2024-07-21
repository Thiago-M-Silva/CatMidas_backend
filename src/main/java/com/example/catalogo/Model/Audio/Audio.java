package com.example.catalogo.Model.Audio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.Base64;

@Table(name = "audio")
@Entity
@Getter
@Setter
@ToString
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audio_id")
    private Long id;
    private String nome;
    private String autor;
    private String descricao;
    private String estudio;
    private String disponibilidade;
    private String statusVisto;
    private Long duracao;
    private String tipo; //musica, podcast, etc
    @Column(name = "dt_lanc")
    private Date mesAno; //data de lancamento
    @Lob
    @Column(name = "imagem")
    private byte[] imagem;

    public Audio(){}

    public Audio(AudioRequestDTO data){
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.autor = data.autor();
        this.estudio = data.estudio();
        this.disponibilidade = data.disponibilidade();
        this.statusVisto = data.StatusVisto();
        this.duracao = data.duracao();
        this.tipo = data.tipo();
        this.mesAno = data.mesAno();
        this.imagem = Base64.getDecoder().decode(data.imagem());
    }
}
