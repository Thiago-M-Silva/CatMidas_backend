package com.example.catalogo.Model.Filme;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.Base64;

@Entity
@Table(name = "filme")
@Getter
@Setter
@ToString
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filme_id")
    private Long id;
    private String nome;
    private String descricao;
    @Column(name = "diretor")
    private String autor;
    private String estudio; //estudio proprietário ou editora
    private String disponibilidade; //onde a midia pode ser econtrada
    @Column(name = "dt_lanc")
    private Date mesAno; //data lancamento
    private Boolean favorito; //indica se a midia esta marcada como favorita ou nao
    @Column(name = "status_visto")
    private String statusVisto; //se o usuario esta assistindo ou ñ ou se pretende ver
    @Column(name = "duracaomin")
    private int duracao;
    @Lob
    @Column(name = "imagem")
    private String imagem;

    public Filme(){}

    public Filme(FilmeRequestDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.autor = data.autor();
        this.estudio = data.estudio();
        this.disponibilidade = data.disponibilidade();
        this.statusVisto = data.statusVisto();
        this.duracao = data.duracao();
        this.mesAno = data.mesAno();
        this.imagem = data.imagem();
    }

}
